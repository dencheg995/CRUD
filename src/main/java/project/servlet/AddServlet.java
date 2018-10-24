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
        String name = req.getParameter("name");
        int age = Integer.parseInt(req.getParameter("age"));

        UserServise userServise = new UserServise();
        UsersEntity usersEntity = new UsersEntity();
        usersEntity.setName(name);
        usersEntity.setAge(age);
        userServise.addUser(usersEntity);
        resp.sendRedirect("/list");
        // req.getRequestDispatcher("/AddUser.jsp").forward(req, resp);
    }
}
