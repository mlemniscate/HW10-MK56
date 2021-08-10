package ir.maktab.todo.front.menus;

import java.sql.SQLException;

public interface RunnableMenu<T> {
    T runMenu() throws SQLException;
}
