package br.com.curso.controller.genero;
import br.com.inter.dao.GeneroDAO;
import br.com.inter.dao.GenericDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet(name = "GeneroListar", urlPatterns = {"/GeneroListar"})
public class GeneroListar extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, Exception {
        response.setContentType("text/html;charset=iso-8859-1");
        try {
            GenericDAO dao = new GeneroDAO();
            request.setAttribute("generos", dao.listar());
            request.getRequestDispatcher("/cadastros/genero/genero.jsp").forward(request, response);
        } catch (Exception ex) {
            System.out.println("Problemas no Servlet ao Listar" + " Generos! Erro: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
@Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(GeneroListar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        try {
            processRequest(request, response);
        } catch (Exception ex) {
            Logger.getLogger(GeneroListar.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
 @Override
    public String getServletInfo(){
        return "Short description";
    }
}
