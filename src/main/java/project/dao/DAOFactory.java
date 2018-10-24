package project.dao;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class DAOFactory {
    public static UserDAO getUserDAO() throws IOException {
        FileInputStream fs;
        Properties properties = new Properties();
        fs = new FileInputStream("/Users/denisgrebenuk/Desktop/проекты Java/GRUD/src/main/resources/aplication.properties");
        properties.load(fs);
        String type = properties.getProperty("dao");
        if (type.equalsIgnoreCase("hibernate")) {
            return new UserDAOHibernate();
        }
        else {
            return new UserDAOJdbc();
            }
        }
}

