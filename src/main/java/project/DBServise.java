package project;

import project.UserDataSet.UsersEntity;
import project.dao.UserDAOHibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class DBServise {



    public long addUser(String name, int age) {
        return new UserDAOHibernate().addUser(name, age);
    }

    public UsersEntity getUser(long id) {
        return new UserDAOHibernate().getUser(id);
    }

    public void removeUser(long id) {
        UserDAOHibernate userDAOHibernate = new UserDAOHibernate();
        userDAOHibernate.removeUser(id);
    }

    public List<UsersEntity> listUser() {
        return new UserDAOHibernate().listUser();
    }

    public void changeUser(long id, String newName, int newAge) {
        UserDAOHibernate daoHibernate = new UserDAOHibernate();
        daoHibernate.changeUser(id,newName,newAge);
    }
    public UsersEntity registrUser(String name, int age, String login, String password, String role) {
        UserDAOHibernate dao = new UserDAOHibernate();
        return dao.registrUser(name, age, login, password,role);
    }

    public UsersEntity getUserLogin(String login) {
        return new UserDAOHibernate().getUserWithLogin(login);
    }

}
