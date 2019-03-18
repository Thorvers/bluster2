package controller;

import model.GameDao;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(
        name = "select",
        urlPatterns = "")
public class PageController extends HttpServlet {

    @EJB
    GameDao gameDao;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        try {
            req.setAttribute("gameList",this.gameDao.getAll());
            req.getRequestDispatcher("/WEB-INF/pages/select.jsp").forward(req, resp);
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}
