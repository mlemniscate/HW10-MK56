package ir.maktab.todo.service;

import ir.maktab.todo.base.service.BaseService;
import ir.maktab.todo.domain.User;
import ir.maktab.todo.service.dto.CreateUserDTO;

import java.sql.SQLException;
import java.util.List;

public interface UserService extends BaseService<User, Long> {
    User logIn(String username, String password);

    User signUp(CreateUserDTO createUserDTO);

    List<String> getAllUserNames() throws SQLException;
}