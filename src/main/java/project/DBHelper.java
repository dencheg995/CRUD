package project;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBHelper {
    private static EntityManagerFactory emf;


     static {
         try {

         emf = Persistence.createEntityManagerFactory("PERSISTENCE");
         } catch (Throwable e) {
             System.out.println("Failure during static initialization" + e);
             throw e;
         }
     }

    public static EntityManager getEmf() {
        return emf.createEntityManager();
    }

    public static void close() {
         emf.close();
    }
}
