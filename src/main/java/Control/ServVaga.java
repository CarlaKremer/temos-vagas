
package Control;

import DAO.VagasDAO;
import DTO.VagasDTO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ServVaga", urlPatterns = {"/ServVaga"})
public class ServVaga extends HttpServlet {

    private void recebeVaga(HttpServletRequest request, HttpServletResponse response){
        
        System.out.println("Vai entrar no Try");
           try{
            VagasDTO objVagasDTO = new VagasDTO();
            System.out.println("executando o Try");
            
            objVagasDTO.setNome_vaga(request.getParameter("nome_vaga"));
            objVagasDTO.setDescricao(request.getParameter("descricao"));
            objVagasDTO.setBolsa(request.getParameter("bolsa"));
            objVagasDTO.setSemestre(request.getParameter("semestre"));
            objVagasDTO.setCurso(request.getParameter("curso"));
            objVagasDTO.setAno_conclusao(request.getParameter("ano_conclusao"));
            objVagasDTO.setTipoVaga(request.getParameter("tipo_vaga"));
            objVagasDTO.setCodUsuario(request.getParameter("hdnCod"));
            
            VagasDAO objVagasDAO = new VagasDAO();
            
            objVagasDAO.inserir(objVagasDTO);
            
             response.sendRedirect("pag_inicial_empresa.jsp");
            System.out.print("DEU CERTO!!!");
           }catch (Exception e){
               System.out.println(e);
           }
            
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        recebeVaga(request, response);
        try ( PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ServVaga</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ServVaga at " + request.getContextPath() + "</h1>");
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
