package br.com.curso.controller.genero;

import br.com.inter.dao.GenericDAO;
import br.com.inter.dao.GeneroDAO;
import br.curso.inter.model.Genero;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "GeneroCadastrar", urlPatterns = {"/GeneroCadastrar"})
public class GeneroCadastrar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=iso-8859-1");
        int idGenero = Integer.parseInt(request.getParameter("idgenero"));
        String tipoGenero = request.getParameter("tipogenero");
        String descricaoGenero = request.getParameter("descricaogenero");
        String mensagem = null;

        Genero oGenero = new Genero();
        oGenero.setIdGenero(idGenero);
        oGenero.setTipoGenero(tipoGenero);
        oGenero.setDescricaoGenero(descricaoGenero);
        try{
            GenericDAO dao = new GeneroDAO();
            if (dao.cadastrar(oGenero)){
                mensagem = "Genero cadastrado com sucesso!";                
            } else {
                mensagem = "Problemas ao cadastrar Genero.Verifique os dados informados e tente novamente!";
            }
            request.setAttribute("mensagem", mensagem);
            response.sendRedirect("GeneroListar");
        } catch (Exception ex){
             System.out.println("Problemas no Servlet ao cadastrar Genero! Erro: " + ex.getMessage());
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
