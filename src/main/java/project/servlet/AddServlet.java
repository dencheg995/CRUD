package project.servlet;

import project.DBException;
import project.DBService;
import project.UserDataSet.User;

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

        try {
            DBService dbService = new DBService();
            long id = dbService.addUser(name,age);
            User profile = dbService.getUser(id);
            resp.getWriter().println(profile.getName());
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (DBException e) {
            e.printStackTrace();
        }


        // req.getRequestDispatcher("/AddUser.jsp").forward(req, resp);
    }
}
