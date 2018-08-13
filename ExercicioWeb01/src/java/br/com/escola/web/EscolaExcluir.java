package br.com.escola.web;

import br.com.escola.dao.EscolaDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Gabriel de Oliveira Ferreira
 */
@WebServlet(urlPatterns = "/escola/excluir")
public class EscolaExcluir extends HttpServlet{

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        int id = Integer.parseInt(req.getParameter("id"));
        boolean apagou = new EscolaDAO().excluir(id);
        
        if (apagou) {
            resp.getWriter().print("Apagou com sucesso");
        } else {
            resp.getWriter().print("Não foi possivel apagar");
        }
    }
    
    
}
