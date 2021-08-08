package ir.maktab.todo;

import ir.maktab.todo.repository.impl.ActivityRepositoryImpl;
import ir.maktab.todo.repository.impl.UserRepositoryImpl;
import ir.maktab.todo.service.impl.ActivityServiceImpl;
import ir.maktab.todo.service.impl.UserServiceImpl;

public class ApplicationContext {
    public static final UserServiceImpl cartService = new UserServiceImpl(new UserRepositoryImpl(ToDoApp.getEntityManager()));

    public static final ActivityServiceImpl customerService = new ActivityServiceImpl(new ActivityRepositoryImpl(ToDoApp.getEntityManager()));

}
