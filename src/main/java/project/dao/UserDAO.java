package project.dao;

import project.module.UsersEntity;

import java.util.List;

public interface UserDAO {
    public UsersEntity getUser(long id);
    public long addUser(UsersEntity usersEntity);
    public void removeUser(long id);
    public List<UsersEntity> listUser();
    public void changeUser(UsersEntity usersEntity);
    public void registrUser(UsersEntity usersEntity);
    public UsersEntity getUserWithLogin(String login);
}
