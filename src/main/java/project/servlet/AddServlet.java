package project.servlet;

import project.module.UsersEntity;
import project.service.UserServise;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = "/Add-User")
public class AddServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String pass = req.getParameter("password");
        String name = req.getParameter("name");
        String role = req.getParameter("role");
        int age = Integer.parseInt(req.getParameter("age"));
        UserServise userServise = new UserServise();
        UsersEntity profile = new UsersEntity(name, age, login, pass, role);
        userServise.addUser(profile);
        resp.sendRedirect("/list");
        // req.getRequestDispatcher("/AddUser.jsp").forward(req, resp);
    }
}
