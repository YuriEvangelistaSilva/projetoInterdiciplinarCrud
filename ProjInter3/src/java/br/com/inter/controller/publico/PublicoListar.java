
package br.com.inter.controller.publico;

import br.com.inter.dao.GenericDAO;
import br.com.inter.dao.PublicoDao;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet(name = "PublicoListar", urlPatterns = {"/PublicoListar"})
public class PublicoListar extends HttpServlet {

   protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=iso-8859-1");
        try {
            GenericDAO dao = new PublicoDao();
            request.setAttribute("publico", dao.listar());
            request.getRequestDispatcher("/cadastros/publico/publico.jsp").forward(request, response);
        } catch (Exception ex) {
            System.out.println("Problemas no Servlet ao Listar" + " Publico! Erro: " + ex.getMessage());
            ex.printStackTrace();
        }
    }

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       try {
           processRequest(request, response);
       } catch (Exception ex) {
           Logger.getLogger(PublicoListar.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       try {
           processRequest(request, response);
       } catch (Exception ex) {
           Logger.getLogger(PublicoListar.class.getName()).log(Level.SEVERE, null, ex);
       }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
