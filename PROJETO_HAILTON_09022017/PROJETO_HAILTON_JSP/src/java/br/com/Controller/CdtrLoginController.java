 
package br.com.Controller;

import br.com.DAO.CdtrPessoaDAO;
import br.com.Model.CdtrPessoa;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author miromar
 */
public class CdtrLoginController extends HttpServlet {

    
//    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
//            throws ServletException, IOException {
//        response.setContentType("text/html;charset=UTF-8");
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet CdtrLoginController</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet CdtrLoginController at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
//    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         String acao = request.getParameter("acao");
       if(acao.equals("sair")){
            HttpSession sessao = request.getSession();
        
            sessao.invalidate();
           response.sendRedirect("login.html");
            //request.getRequestDispatcher("login.html").forward(request, response);
          }
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        
        CdtrPessoa cdtrPessoa = new CdtrPessoa();
        
        cdtrPessoa.setPessLogin(login);
        cdtrPessoa.setPessSenha(senha);
        
        CdtrPessoaDAO loginDAO = new CdtrPessoaDAO();   
     CdtrPessoa loginAtivo    = loginDAO.getByLogin(cdtrPessoa);
     
     
     
       if(loginAtivo!=null){
           HttpSession sessao  = request.getSession();
           sessao.setAttribute("loginAtivo",loginAtivo );
         request.getRequestDispatcher("Pages/index.jsp").forward(request, response);
       }else{
            response.sendRedirect("login.html");
        }
       
       

    }
    
    
    @Override
    public String getServletInfo() {
        
        return "Short description";
    }// </editor-fold>

}
