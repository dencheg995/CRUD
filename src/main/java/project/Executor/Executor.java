package project.Executor;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Executor {
    private Connection connection;

    public Executor(Connection connection) {
        this.connection = connection;
    }

    public void execUpadate(String update) throws SQLException {
        Statement stm = connection.createStatement();
        stm.execute(update);
        stm.close();
    }

    public <T> T execQuery(String update, ResultHandler<T> handler) throws SQLException {
        Statement stm = connection.createStatement();
        stm.execute(update);
        ResultSet result = stm.getResultSet();
        T value = handler.handle(result);
        result.close();
        stm.close();
        return value;
    }

}
