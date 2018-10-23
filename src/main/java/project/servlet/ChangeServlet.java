package project.servlet;

import project.DBHelper;
import project.DBServise;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/changeUser")
public class ChangeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("idChange"));
        String name = req.getParameter("nameChange");
        int age = Integer.parseInt(req.getParameter("ageChange"));
            DBServise dbServise = new DBServise();
            dbServise.changeUser(id, name, age);
            resp.sendRedirect("/list");


    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("idChange"));
        req.setAttribute("idChange", id);
        String name = req.getParameter("nameChange");
        req.setAttribute("nameChange", name);
        int age = Integer.parseInt(req.getParameter("ageChange"));
        req.setAttribute("ageChange", age);
        getServletContext().getRequestDispatcher("/changeUser.jsp").forward(req, resp);
    }
}
