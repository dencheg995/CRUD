package project.dao;

import project.module.UsersEntity;

import java.util.List;

public class UserDAOJdbc implements UserDAO {
    @Override
    public UsersEntity getUser(long id) {
        return null;
    }

    @Override
    public long addUser(UsersEntity usersEntity) {
        return 0;
    }

    @Override
    public void removeUser(long id) {

    }

    @Override
    public List<UsersEntity> listUser() {
        return null;
    }

    @Override
    public void changeUser(UsersEntity usersEntity) {


    }

    @Override
    public void registrUser(UsersEntity usersEntity) {

    }

    @Override
    public UsersEntity getUserWithLogin(String login) {
        return null;
    }
}
