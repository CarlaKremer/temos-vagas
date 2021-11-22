/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import DAO.EmpresaDAO;
import DTO.EmpresaDTO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author carla
 */
@WebServlet(name = "ServUsuario", urlPatterns = {"/ServUsuario"})
public class ServUsuario extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    private void recebeUsuario(HttpServletRequest request, HttpServletResponse response){
                            System.out.println("Vai entrar no Try");
           try{
            EmpresaDTO objEmpresaDTO = new EmpresaDTO();
            System.out.println("executando o Try");
      
            objEmpresaDTO.setRazao_social(request.getParameter("razao_social"));
            objEmpresaDTO.setUsuario(request.getParameter("usuario"));
            objEmpresaDTO.setSenha(request.getParameter("senha"));
            objEmpresaDTO.setCnpj(request.getParameter("cnpj"));
            objEmpresaDTO.setInscricao_estadual(request.getParameter("inscricao_estadual"));
            objEmpresaDTO.setEmail(request.getParameter("email"));
            objEmpresaDTO.setTelefone1(request.getParameter("telefone1"));
            objEmpresaDTO.setTelefone2(request.getParameter("telefone2"));
            objEmpresaDTO.setRamo_de_atuacao(request.getParameter("atuacao"));
        
            EmpresaDAO objEmpresaDAO = new EmpresaDAO();
            
            objEmpresaDAO.inserir(objEmpresaDTO);
            
           response.sendRedirect("login.jsp");
           }catch (Exception e){
               System.out.println(e);
           }
            
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        recebeUsuario(request, response);
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServUsuario</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServUsuario at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

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
        processRequest(request, response);
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
        processRequest(request, response);
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
