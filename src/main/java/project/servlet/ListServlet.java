package project.servlet;

import project.DBService;
import project.UserDataSet.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;


@WebServlet
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
            execute(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            execute(req, resp);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException, SQLException {
        List<User> userList = dbService.getUsers();
        req.setAttribute("userList", userList);
        req.getRequestDispatcher("web/index.jsp").forward(req, resp);
    }
}
