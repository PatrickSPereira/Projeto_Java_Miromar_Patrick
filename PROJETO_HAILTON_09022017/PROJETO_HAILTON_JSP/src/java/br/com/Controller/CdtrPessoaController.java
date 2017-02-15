package br.com.Controller;

import br.com.DAO.CdtrCursoDAO;
import br.com.DAO.CdtrFuncaoDAO;
import br.com.DAO.CdtrPessoaDAO;
import br.com.Model.CdtrCurso;
import br.com.Model.CdtrFuncao;
import br.com.Model.CdtrPessoa;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author miromar
 */
public class CdtrPessoaController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//      
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet CdtrPessoaController</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet CdtrPessoaController at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
//    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");

        if (acao.equals("lis")) {
            CdtrPessoaDAO pessoaDAO = new CdtrPessoaDAO();
            List<CdtrPessoa> lista = pessoaDAO.getByAll();

            request.setAttribute("lista", lista);

            request.getRequestDispatcher("Pages/ListaUsuarios.jsp").forward(request, response);

        }

        if (acao.equals("cadPessoa")) {

            CdtrFuncaoDAO idFuncaoDAO = new CdtrFuncaoDAO();
            CdtrCursoDAO idCursoDao = new CdtrCursoDAO();
            //busca lista de funçoes
            List<CdtrFuncao> listaFuncao = idFuncaoDAO.getByAll();
            request.setAttribute("listaFuncao", listaFuncao);
            //busca lista de cursos
            List<CdtrCurso> listaCurso = idCursoDao.getByAll();
            request.setAttribute("listaCurso", listaCurso);
            request.getRequestDispatcher("Pages/CadastrarUsuario.jsp").forward(request, response);
        }
        if (acao.equals("home")) {
            request.getRequestDispatcher("Pages/index.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String nomePessoa = request.getParameter("nomePessoa");
        String lattespessoa = request.getParameter("lattesPessoa");
        String idCurso = request.getParameter("idCurso");
        String loginPessoa = request.getParameter("loginPessoa");
        String senhaPessoa = request.getParameter("senhaPessoa");
        String idFuncao = request.getParameter("idFuncao");

        CdtrPessoa cdtrPessoa = new CdtrPessoa();

        cdtrPessoa.setPessNome(nomePessoa);
        cdtrPessoa.setPessLattes(lattespessoa);
        cdtrPessoa.setCafuPk(Integer.parseInt(idFuncao));
        cdtrPessoa.setPessLogin(loginPessoa);
        cdtrPessoa.setPessSenha(senhaPessoa);
        cdtrPessoa.setCursPk(Integer.parseInt(idCurso));

        CdtrPessoaDAO pessoaDao = new CdtrPessoaDAO();
        pessoaDao.insert(cdtrPessoa);
        response.sendRedirect("Pessoa.do?acao=lis");

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
