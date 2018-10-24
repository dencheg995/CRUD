package project.servlet;

import project.service.UserServise;
import project.module.UsersEntity;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = "/register")
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String pass = req.getParameter("password");
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        UserServise userServise = new UserServise();
        UsersEntity profile = new UsersEntity(name, age, login, pass, "User");
        userServise.registrUser(profile);
        if(profile!=null) {
            resp.sendRedirect("user.jsp");
        }
    }
}
