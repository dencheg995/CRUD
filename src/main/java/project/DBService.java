package project;

;
import project.UserDataSet.User;
import project.dao.UserDAO;

import java.sql.Array;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DBService {

    private Connection connection;

    public DBService() throws SQLException, ClassNotFoundException {
        this.connection = getDbConnection();
    }


    public User getUser(long id) throws SQLException {
        return (new UserDAO(connection).getUser(id));
    }

    public ArrayList<User> getUsers() throws SQLException {
        return (new UserDAO(connection)).getUsersList();
    }

    public long addUser(String name, int age) throws DBException {
      try {
        connection.setAutoCommit(false);
        UserDAO dao = new UserDAO(connection);
        dao.createTable();
        dao.addUser(name, age);
        connection.commit();
        return dao.getUserId(name);
      } catch (SQLException e) {
          try {
              connection.rollback();
          } catch (SQLException e1) {
              e1.printStackTrace();
          }
          throw new DBException(e);
      }
      finally {
          try {
              connection.setAutoCommit(true);
          } catch (SQLException e) {
              e.printStackTrace();
          }
      }
    }

    public void removeUser(long id)  {
        try {
            connection.setAutoCommit(false);
            UserDAO dao = new UserDAO(connection);
            dao.removeUser(id);
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }

    public void changeUser(long id, String changeName, int changeAge) {
        try {
            connection.setAutoCommit(false);
            UserDAO dao = new UserDAO(connection);
            dao.changeUser(id, changeName, changeAge);
            connection.commit();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException e1) {
                e1.printStackTrace();
            }
        }
    }

    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + "localhost" + ":" + "3306" + "/" + "db_users" + "?useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";;
        //Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(connectionString, "root", "denis080412");
        return connection;
    }
}



