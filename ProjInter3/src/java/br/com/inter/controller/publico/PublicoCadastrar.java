/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.inter.controller.publico;

import br.com.inter.dao.GenericDAO;
import br.com.inter.dao.PublicoDao;
import br.curso.inter.model.Publico;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PublicoCadastrar", urlPatterns = {"/PublicoCadastrar"})
public class PublicoCadastrar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=iso-8859-1");
        int idPublico = Integer.parseInt(request.getParameter("idPublico"));
        String idadePublico = request.getParameter("idadePublico");
        String mensagem = null;

        Publico oPublico = new Publico();
        oPublico.setIdPublico(idPublico);
        oPublico.setIdadePublico(idadePublico);
        try {
            GenericDAO dao = new PublicoDao();
            if (dao.cadastrar(oPublico)) {
                mensagem = "Publico cadastrado com sucesso!";
            } else {
                mensagem = "Problemas ao cadastrar Publico.Verifique os dados informados e tente novamente!";
            }
            request.setAttribute("mensagem", mensagem);
            response.sendRedirect("PublicoListar");
        } catch (Exception ex) {
            System.out.println("Problemas no Servlet ao cadastrar Publico! Erro: " + ex.getMessage());
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
