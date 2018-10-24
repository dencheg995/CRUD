package project.service;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DBHelper {
    private EntityManagerFactory emf;
    private static DBHelper singlton = new DBHelper();

    private DBHelper() {
    }

    public static DBHelper getInstance() {
        return singlton;
    }

    public EntityManagerFactory getEmf() {
        if(emf == null) {
            emf = Persistence.createEntityManagerFactory("PERSISTENCE");
        }
        return emf;
    }

    //    private static EntityManagerFactory emf;
//
//
//     static {
//         try {
//         emf = Persistence.createEntityManagerFactory("PERSISTENCE");
//         } catch (Throwable e) {
//             System.out.println("Failure during static initialization" + e);
//             throw e;
//         }
//     }
//
//    public static EntityManager getEmf() {
//        return emf.createEntityManager();
//    }
//
//    public static void close() {
//         emf.close();
//    }
}
