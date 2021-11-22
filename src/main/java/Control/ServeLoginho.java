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
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author carla
 */
@WebServlet(name = "ServeLoginho", urlPatterns = {"/ServeLoginho"})
public class ServeLoginho extends HttpServlet {

    private EmpresaDAO objEmpresaDAO = new EmpresaDAO();
    private EmpresaDTO objEmpresaDTO = new EmpresaDTO();
    
    String usuario;
    String senha;
    String pagina="";
    String codUsuario = "";
    

    protected void services(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
           usuario = request.getParameter("usuario");
           senha = request.getParameter("senha");    
           System.out.println("usuario e senha servLogin: "+'"'+ usuario+'"'+senha);
        if((!usuario.equals("")) && (!usuario.equals(null)) ){
            try {
            System.out.println(usuario+senha);

                if(objEmpresaDAO.validarLogin(usuario,senha)){
                    //Acesso liberado
                    //RequestDispatcher rd = request.getRequestDispatcher("pag_inicial_empresa.jsp");
                    //rd.forward(request, response);
                    recebeCodUsuario(usuario);
                    pagina = "pag_inicial_empresa.jsp";

                    System.out.println("AAAAAAAAA VALIDOU");
                }else{
                    //Acesso Negado
                    //RequestDispatcher rd = request.getRequestDispatcher("tenteNovamente.html");
                    //rd.forward(request, response);
                    pagina = "tenteNovamente.html";
                    System.out.println("AAAAAAAAAA NÃO VALIDOU");
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }else{
            pagina = "tenteNovamente.html";
            System.out.println("usuario vazio");
        }
        
    }
   private void recebeCodUsuario (String usuario) throws SQLException, ClassNotFoundException{
       codUsuario = objEmpresaDAO.mandaCodUsuario(usuario);
   }
   private void redirecionar(String pagina, HttpServletRequest request, HttpServletResponse response){
        HttpSession session = request.getSession();
        session.setAttribute("USUARIO", usuario);
        session.setAttribute("COD", codUsuario);
       
       RequestDispatcher rd = request.getRequestDispatcher(pagina);
       try{
            rd.forward(request,response);
        }catch(Exception e){
            e.printStackTrace();
        }
   }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        services(request, response);
        redirecionar(pagina, request, response);
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServeLoginho</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServeLoginho at " + request.getContextPath() + "</h1>");
            out.println("<h1>Servlet ServeLoginho at " +usuario+senha+ "</h1>");
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
