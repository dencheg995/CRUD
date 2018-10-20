package project.servlet;

import project.DBService;
import project.UserDataSet.User;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;


@WebServlet(urlPatterns = "/list")
public class ListServlet extends HttpServlet {

    DBService dbService;

    {
        try {
            dbService = new DBService();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            ArrayList<User> list = dbService.getUsers();
            req.setAttribute("list", list);
            getServletContext().getRequestDispatcher("/list.jsp").forward(req, resp);
            //req.getRequestDispatcher("index.jsp").forward(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
