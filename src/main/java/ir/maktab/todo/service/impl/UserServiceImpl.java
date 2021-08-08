package ir.maktab.todo.service.impl;

import ir.maktab.todo.base.service.impl.BaseServiceImpl;
import ir.maktab.todo.domain.User;
import ir.maktab.todo.repository.UserRepository;
import ir.maktab.todo.service.UserService;
import ir.maktab.todo.service.dto.CreateUserDTO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
        return save(new User(
                0L,
                createUserDTO.getFirstName(),
                createUserDTO.getLastName(),
                createUserDTO.getUsername(),
                createUserDTO.getPassword(),
                null
        ));
    }

    @Override
    public List<String> getAllUserNames() throws SQLException {
        List<User> users = findAll();
        List<String> usernames = new ArrayList<>();
        for (User user : users) {
            usernames.add(user.getUsername());
        }
        return usernames;
    }
}
