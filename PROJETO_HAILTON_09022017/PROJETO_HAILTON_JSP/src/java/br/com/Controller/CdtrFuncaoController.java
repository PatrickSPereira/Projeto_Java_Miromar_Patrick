/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.Controller;

import br.com.DAO.CdtrFuncaoDAO;
import br.com.Model.CdtrFuncao;
import java.io.IOException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Patrick
 */
@WebServlet(name = "Cdtr_Funcao_Controller", urlPatterns = {"/Funcao.do"})
public class CdtrFuncaoController extends HttpServlet {

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
//            /* TODO output your page here. You may use following sample code. */
//            out.println("<!DOCTYPE html>");
//            out.println("<html>");
//            out.println("<head>");
//            out.println("<title>Servlet CdtrFuncaoController</title>");            
//            out.println("</head>");
//            out.println("<body>");
//            out.println("<h1>Servlet CdtrFuncaoController at " + request.getContextPath() + "</h1>");
//            out.println("</body>");
//            out.println("</html>");
//        }
//    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
            String acao = request.getParameter("acao");
            if(acao.equals("lis")){
                CdtrFuncaoDAO funcaoDAO = new CdtrFuncaoDAO();
                List<CdtrFuncao> lista = funcaoDAO.getByAll();

                request.setAttribute("lista", lista);

                RequestDispatcher saida = request.getRequestDispatcher("Pages/ListaFuncao.jsp");
                saida.forward(request, response);                
            }
            
            if(acao.equals("cadFuncao")){
               request.getRequestDispatcher("Pages/CadastrarFuncao.jsp").forward(request, response);                
            }
           // response.sendRedirect("Funcao.do?acao=lis");
                
        }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {        
            CdtrFuncao cdtrFuncao = new CdtrFuncao();
            
            cdtrFuncao.setCafuDescricao(request.getParameter("descricaoFuncao"));            

            CdtrFuncaoDAO funcaoDao = new CdtrFuncaoDAO();
            funcaoDao.insert(cdtrFuncao);
           response.sendRedirect("Funcao.do?acao=lis");
                
                
         
               
         
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
