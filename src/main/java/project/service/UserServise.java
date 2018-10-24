package project.service;

import project.dao.DAOFactory;

import project.dao.UserDAO;
import project.module.UsersEntity;
import project.dao.UserDAOHibernate;


import java.io.IOException;
import java.util.List;

public class UserServise {

    private UserDAO dao;

    public UserServise() throws IOException {
        dao = DAOFactory.getUserDAO();
    }

    public long addUser(UsersEntity usersEntity) {
        return dao.addUser(usersEntity);
    }

    public UsersEntity getUser(long id) {
        return dao.getUser(id);
    }

    public void removeUser(long id) {
        dao.removeUser(id);
    }

    public List<UsersEntity> listUser() {
        return dao.listUser();

    }

    public void changeUser(UsersEntity usersEntity) {
        dao.changeUser(usersEntity);

    }
    public void registrUser(UsersEntity usersEntity) {
        dao.registrUser(usersEntity);

    }

    public UsersEntity getUserLogin(String login) {
        return dao.getUserWithLogin(login);
    }



}
