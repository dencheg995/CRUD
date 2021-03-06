package project.servlet;


import project.service.UserServise;
import project.module.UsersEntity;

import javax.persistence.EntityManager;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import java.util.List;


@WebServlet(urlPatterns = "/list")

public class ListServlet extends HttpServlet {
    private EntityManager em;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            HttpSession session = req.getSession(true);
            UserServise userServise = new UserServise();
            if(session.getAttribute("userRole").equals("Admin")) {
                List<UsersEntity> list = userServise.listUser();
                req.setAttribute("list", list);
                getServletContext().getRequestDispatcher("/list.jsp").forward(req, resp);
            } else {
                resp.sendRedirect("forbidden.jsp");
            }


            //req.getRequestDispatcher("index.jsp").forward(req, resp);

    }
}
