package project.servlet;

import project.DBServise;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet(urlPatterns = "/Add-User")
public class AddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));

        DBServise dbServise = new DBServise();
        dbServise.addUser(name, age);
        resp.sendRedirect("/list");
        // req.getRequestDispatcher("/AddUser.jsp").forward(req, resp);
    }
}
