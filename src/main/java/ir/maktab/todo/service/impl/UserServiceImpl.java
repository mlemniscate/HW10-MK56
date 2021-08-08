package ir.maktab.todo.service.impl;

import ir.maktab.todo.base.service.impl.BaseServiceImpl;
import ir.maktab.todo.domain.User;
import ir.maktab.todo.repository.UserRepository;
import ir.maktab.todo.service.UserService;
import ir.maktab.todo.service.dto.CreateUserDTO;

public class UserServiceImpl extends BaseServiceImpl<User, Long, UserRepository> implements UserService {

    public UserServiceImpl(UserRepository repository) {
        super(repository);
    }

    @Override
    public User logIn(String username, String password) {
        return null;
    }

    @Override
    public User signUp(CreateUserDTO createUserDTO) {
        return null;
    }
}
