package ir.maktab.todo;

import ir.maktab.todo.front.menus.FirstMenu;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.sql.SQLException;
import java.util.ArrayList;

public class ToDoApp {

    private static EntityManager entityManager;

    public static void main(String[] args) throws SQLException {
        EntityManagerFactory entityManagerFactory = HibernateUtil.getEntityManagerFactory();
        entityManager = entityManagerFactory.createEntityManager();
        new FirstMenu(new ArrayList<String>(){{add("Log In");add("Sign Up");add("Exit");}}).runMenu();
    }

    public static EntityManager getEntityManager() {
        return entityManager;
    }
}
