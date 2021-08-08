package ir.maktab.todo;

import javax.persistence.EntityManagerFactory;

public class ToDoApp {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = HibernateUtil.getEntityManagerFactory();

    }
}
