package br.com.curso.controller.Catalogo;

import br.com.inter.dao.CatalogoDAO;
import br.com.inter.dao.GenericDAO;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CatalogoExcluir", urlPatterns = {"/CatalogoExcluir"})
public class CatalogoExcluir extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=iso-8859-1");
        int idCatalogo = Integer.parseInt(request.getParameter("idCatalogo"));
        String mensagem = null;
        try {
            GenericDAO dao = new CatalogoDAO();
            if (dao.excluir(idCatalogo)) {
                mensagem = "Catalogo excluido com Sucesso!";
            } else {
                mensagem = "Problemas ao excluir Catalogo";
            }
            request.setAttribute("mensagem", mensagem);
            response.sendRedirect("CatalogoListar");
        } catch (Exception ex) {
            System.out.println("Problemas no Servelet ao excluir Catalogo! Erro: " + ex.getMessage());
            ex.printStackTrace();
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
