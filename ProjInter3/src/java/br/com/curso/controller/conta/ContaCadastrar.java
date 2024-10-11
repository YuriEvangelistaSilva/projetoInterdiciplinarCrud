/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.curso.controller.conta;

import br.com.inter.dao.ContaDAO;
import br.com.inter.dao.GenericDAO;
import br.com.curso.model.Conta;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Aluno
 */
@WebServlet(name = "ContaCadastrar", urlPatterns = {"/ContaCadastrar"})
public class ContaCadastrar extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=iso-8859-1");
        int idConta = Integer.parseInt(request.getParameter("idconta"));
        String nomeUsuario = request.getParameter("nomeusuario");
        String emailConta = request.getParameter("emailconta");
        String senhaConta = request.getParameter("senhaconta");
        String mensagem = null;

        Conta oConta = new Conta();
        oConta.setIdConta(idConta);
        oConta.setNomeUsuario(nomeUsuario);
        oConta.setEmailConta(emailConta);
        oConta.setSenhaConta(senhaConta);
        try{
            GenericDAO dao = new ContaDAO();
            if (dao.cadastrar(oConta)){
                mensagem = "Conta cadastrado com sucesso!";                
            } else {
                mensagem = "Problemas ao cadastrar Conta.Verifique os dados informados e tente novamente!";
            }
            request.setAttribute("mensagem", mensagem);
            response.sendRedirect("ContaListar");
        } catch (Exception ex){
             System.out.println("Problemas no Servlet ao cadastrar Conta! Erro: " + ex.getMessage());
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
