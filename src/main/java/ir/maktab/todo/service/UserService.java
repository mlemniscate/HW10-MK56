package ir.maktab.todo.service;

import ir.maktab.todo.base.service.BaseService;
import ir.maktab.todo.domain.User;

public interface UserService extends BaseService<User, Long> {
    User logIn(String username, String password);

    User signUp(User user);
}