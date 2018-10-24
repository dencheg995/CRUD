package project.servlet;


import project.module.UsersEntity;
import project.service.UserServise;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebServlet(urlPatterns = "/changeUser")
public class ChangeServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long id = Long.valueOf(req.getParameter("idChange"));
        String name = req.getParameter("nameChange");
        int age = Integer.parseInt(req.getParameter("ageChange"));
        String login = req.getParameter("loginChange");
        String pass = req.getParameter("passwordChange");
            UserServise userServise = new UserServise();
            UsersEntity profile = new UsersEntity();
            profile.setId(id);
            profile.setName(name);
            profile.setAge(age);
            profile.setLogin(login);
            profile.setPassword(pass);
            profile.setRole("User");
            userServise.changeUser(profile);
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
        String login = req.getParameter("loginChange");
        req.setAttribute("loginChange", login);
        String pass = req.getParameter("passwordChange");
        req.setAttribute("passwordChange", pass);
        getServletContext().getRequestDispatcher("/changeUser.jsp").forward(req, resp);
    }
}
