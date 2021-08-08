package ir.maktab.todo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class ToDoApp {

    private static EntityManager entityManager;

    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = HibernateUtil.getEntityManagerFactory();
        entityManager = entityManagerFactory.createEntityManager();
    }

    public static EntityManager getEntityManager() {
        return entityManager;
    }
}
