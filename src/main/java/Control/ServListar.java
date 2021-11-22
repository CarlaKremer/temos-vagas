
package Control;

import DTO.VagasDTO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "ServListar", urlPatterns = {"/ServListar"})
public class ServListar extends HttpServlet {
    //ESTE SERVLET TEM A FUNÇÃO DE GUARDAR PARAMETROS QUE SERÃO USADOS NA PRÓXIMA PÁGINA E REDIRECIONAR
    //ESSAS VARIAVEIS SERÃO O TÍTULO DA PÁGINA QUE LISTA AS VAGAS E NO CASO DE nomeVaga É O QUE VOU USAR PARA PESQUISAR NO BANCO
    String nomeVaga;
    String tipoVaga;
    String codUsuario;
    
    private void recebeCandidato(HttpServletRequest request, HttpServletResponse response){
        nomeVaga = request.getParameter("hdnNomeVaga");
        tipoVaga = request.getParameter("hdnTipoVaga");
        codUsuario = request.getParameter("hdnCodUsuario");
        System.out.println("nomeVaga: " + nomeVaga);
    }
    private void redirecionar(HttpServletRequest request, HttpServletResponse response){
       //PARA ACESSAR OS PARAMETROS EM listarVagas.jsp:
       HttpSession session = request.getSession();
       session.setAttribute("NOME", nomeVaga);
       session.setAttribute("TIPO", tipoVaga);
       session.setAttribute("CODIGO_USUARIO", codUsuario);
       
       RequestDispatcher rd = request.getRequestDispatcher("listarVagas.jsp");
       try{
            rd.forward(request,response);
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        recebeCandidato(request, response);
        redirecionar(request, response);
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServListar</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServListar at " + request.getContextPath() + "</h1>");
            out.println("<h1>Servlet ServListar at " + request.getContextPath() + "</h1>");
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
