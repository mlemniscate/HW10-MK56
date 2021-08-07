package ir.maktab.todo.service.impl;

import ir.maktab.todo.base.service.impl.BaseServiceImpl;
import ir.maktab.todo.domain.User;
import ir.maktab.todo.repository.UserRepository;

public class UserServiceImpl extends BaseServiceImpl<User, Long, UserRepository> {

    public UserServiceImpl(UserRepository repository) {
        super(repository);
    }

}
