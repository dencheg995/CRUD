package project.servlet;

import project.DBServise;
import project.UserDataSet.UsersEntity;
import sun.jvm.hotspot.opto.HaltNode;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(urlPatterns = "/register")
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String pass = req.getParameter("password");
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));
        DBServise dbServise = new DBServise();
        UsersEntity profile = dbServise.registrUser(name, age, login, pass, "User");
        if(profile!=null) {
            resp.sendRedirect("user.jsp");
        }
    }
}
