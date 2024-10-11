/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.inter.controller.plataforma;


import br.com.inter.dao.GenericDAO;
import br.com.inter.dao.PlataformaDAO;
import br.curso.inter.model.Plataforma;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "PlataformaCadastrar", urlPatterns = {"/PlataformaCadastrar"})
public class PlataformaCadastrar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=iso-8859-1");
        int idPlataforma = Integer.parseInt(request.getParameter("idPlataforma"));
        String nomePlataforma = request.getParameter("nomePlataforma");
        String mensagem = null;

        Plataforma oPlataforma = new Plataforma();
        oPlataforma.setIdPlataforma(idPlataforma);
        oPlataforma.setNomePlataforma(nomePlataforma);
        try {
            GenericDAO dao = new PlataformaDAO();
            if (dao.cadastrar(oPlataforma)) {
                mensagem = "Plataforma cadastrado com sucesso!";
            } else {
                mensagem = "Problemas ao cadastrar Plataforma.Verifique os dados informados e tente novamente!";
            }
            request.setAttribute("mensagem", mensagem);
                response.sendRedirect("PlataformaListar");
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
