package project.dao;

import project.Executor.Executor;
import project.UserDataSet.User;


import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO {
   private Executor executor;


    public UserDAO(Connection connection) {
        executor = new Executor(connection);
    }

    public User getUser(long id) throws SQLException {
        return executor.execQuery("select * from users where id=" + id, result -> {
            result.next();
            return new User(result.getLong(1), result.getString(2));
        } );
    }

    public long getUserId(String name) throws SQLException {
        return executor.execQuery("select * from users where user_name='" + name + "'", result -> {
            result.next();
            return result.getLong(1);
        });
    }

    public List<User> getUsersList() throws SQLException {
        List<User> list = new ArrayList<>();
        User user = new User();
        return executor.execQuery("select * from users", result -> {
            while(result.next()) {
                user.setId(result.getLong("id"));
                user.setName(result.getString("user_name"));
                user.setAge(result.getInt("user_age"));
                list.add(user);
                //list.add(new User(result.getLong(1), result.getString(2)));
            }
            return list;
        } );
    }

    public void addUser(String name, int age) throws SQLException {
       executor.execUpadate("insert into users (user_name, user_age) values('" + name + "',"+ age +")");
   }

   public void removeUser(String name) throws SQLException {
       executor.execUpadate("delete from users where user_name ='" + name + "'");
   }

    public void createTable() throws SQLException {
        executor.execUpadate("create table if not exists users (id bigint auto_increment, user_name varchar(256), user_age int, primary key(id))");
    }
    public void changeUser(long id, String changeName, int changeAge) throws SQLException {
        executor.execUpadate("update users set user_name ='" + changeName + "' , user_age ='" + changeAge + "' where id='" + id +"'");
    }

}
