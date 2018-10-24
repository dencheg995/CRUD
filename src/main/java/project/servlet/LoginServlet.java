package project.servlet;

import project.service.UserServise;
import project.module.UsersEntity;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(urlPatterns = "/filter")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        HttpSession session = req.getSession(true);
        UserServise userServise = new UserServise();
        UsersEntity profile = userServise.getUserLogin(login);
        if(login != null && password!= null && profile.getPassword().equals(password)) {
            if (profile.getRole().equals("User")) {
                session.setAttribute("userName", profile.getName());
                session.setAttribute("userAge", profile.getAge());
                session.setAttribute("userId", profile.getId());
                session.setAttribute("userRole", profile.getRole());
                resp.sendRedirect("forAuthorizingUser.jsp");
                return;
            }

            if (profile.getRole().equals("Admin")) {
                session.setAttribute("userRole", profile.getRole());
                resp.sendRedirect("/list");
            } else {
                resp.sendRedirect("index.jsp");
            }

        } else {
            resp.sendRedirect("index.jsp");
        }


    }


}
