package project.dao;


import project.DBHelper;
import project.UserDataSet.UsersEntity;

import javax.persistence.EntityManager;
import java.util.List;

public class UserDAOHibernate {
    private  EntityManager em;


    public UserDAOHibernate() {
       this.em = DBHelper.getEmf();
    }

    public UsersEntity getUser(long id) {
        return em.find(UsersEntity.class, id);
    }

    public long addUser(String name, int age) {
        UsersEntity user = new UsersEntity(name, age);
        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();

        return user.getId();
    }

    public void removeUser(long id) {
        UsersEntity user = getUser(id);
        em.getTransaction().begin();
        em.remove(user);
        em.getTransaction().commit();

    }

    public List<UsersEntity> listUser() {
        return em.createQuery("from UsersEntity").getResultList();
    }

    public void changeUser(long id, String newName, int newAge) {
        UsersEntity usersEntity = em.find(UsersEntity.class, id);
        em.getTransaction().begin();
        usersEntity.setName(newName);
        usersEntity.setAge(newAge);
        em.persist(usersEntity);
        em.getTransaction().commit();
        em.close();
    }

    public UsersEntity registrUser(String name, int age, String login, String password, String role) {
        UsersEntity entity = new UsersEntity(name, age, login, password, role);

        em.getTransaction().begin();
        em.persist(entity);
        em.getTransaction().commit();
        em.close();
        return entity;
    }

    public UsersEntity getUserWithLogin(String login) {
        return (UsersEntity) em.createQuery("from UsersEntity where login = :login").setParameter("login", login).getSingleResult();
    }

}
