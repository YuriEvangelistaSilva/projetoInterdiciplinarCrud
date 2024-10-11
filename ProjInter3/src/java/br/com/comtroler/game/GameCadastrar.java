
package br.com.comtroler.game;

import br.com.inter.dao.GameDAO;
import br.com.inter.dao.GenericDAO;
import br.curso.inter.model.Game;
import br.curso.inter.model.Genero;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "GameCadastrar", urlPatterns = {"/GameCadastrar"})
public class GameCadastrar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=iso-8859-1");
        int idGame = Integer.parseInt(request.getParameter("idgame"));
        int idGenero = Integer.parseInt(request.getParameter("idgenero"));
        String nome = request.getParameter("nome");
        String categoria = request.getParameter("categoria");
        String notaTotal = request.getParameter("notatotal");
        String descricaoGame = request.getParameter("descricaoGame");
        String situacao = request.getParameter("situacao");
        String mensagem = null;

        try {

            Game oGame= new Game();
            oGame.setIdGame(idGame);
            oGame.setNome(nome);
            oGame.setCategoria(categoria);
            oGame.setNotaTotal(notaTotal);
            oGame.setDescricaoGame(descricaoGame);
            oGame.setSituacao(situacao);
            oGame.setGenero(new Genero(idGenero, "", ""));

            GenericDAO dao = new GameDAO();
            if (dao.cadastrar(oGame)) {
                mensagem = "Game cadastrada com sucesso!";
            } else {
                mensagem = "Problemas ao cadastrar Game. Verefique os dados informados e tente novamente!";
            }
            request.setAttribute("mensagem", mensagem);
            response.sendRedirect("GameListar");
        } catch (Exception ex) {
            System.out.println("Problemas no Servelet ao cadastrar Cidade! Erro: " + ex.getMessage());
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
