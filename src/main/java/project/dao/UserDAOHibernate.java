package project.dao;


import project.service.DBHelper;
import project.module.UsersEntity;

import javax.persistence.EntityManager;
import java.util.List;

public class UserDAOHibernate implements UserDAO {
    private  EntityManager em;


    public UserDAOHibernate() {
        em = DBHelper.getInstance().getEmf().createEntityManager();
    }

    public UsersEntity getUser(long id) {
        return em.find(UsersEntity.class, id);
    }

    public long addUser(UsersEntity usersEntity) {
        em.getTransaction().begin();
        if(!em.contains(usersEntity)) {
            em.persist(usersEntity);
            em.flush();
        }
        em.getTransaction().commit();
        return usersEntity.getId();
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

    public void changeUser(UsersEntity usersEntity) {
        em.getTransaction().begin();
        em.merge(usersEntity);
        em.getTransaction().commit();

    }

    public void registrUser(UsersEntity usersEntity) {
            em.getTransaction().begin();
            if(!em.contains(usersEntity)) {
                em.persist(usersEntity);
                em.flush();
            }
            em.getTransaction().commit();
    }

    public UsersEntity getUserWithLogin(String login) {
        return (UsersEntity) em.createQuery("from UsersEntity where login = :login").setParameter("login", login).getSingleResult();
    }

}
