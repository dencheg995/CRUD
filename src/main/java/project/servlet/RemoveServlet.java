package project.servlet;

import project.DBService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import java.sql.SQLException;
import java.util.Date;

@WebServlet(urlPatterns = "/Remove-User")
public class RemoveServlet extends HttpServlet {
    Date data = new Date();
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        try {
            DBService dbService = new DBService();
            dbService.removeUser(name);
            resp.getWriter().println("Removed succseful");
            resp.sendRedirect("/list");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
