package ir.maktab.todo.repository.impl;

import ir.maktab.todo.base.repository.impl.BaseRepositoryImpl;
import ir.maktab.todo.domain.User;
import ir.maktab.todo.repository.UserRepository;

import javax.persistence.EntityManager;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public class UserRepositoryImpl extends BaseRepositoryImpl<User, Long> implements UserRepository {

    public UserRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public User save(User user) {
        return null;
    }

    @Override
    public User update(User user) {
        return null;
    }

    @Override
    public List<User> findAll() throws SQLException {
        return entityManager.createQuery("from User", User.class).getResultList();
    }

    @Override
    public List<User> findAllByIds(Collection<Long> longs) {
        return null;
    }

    @Override
    public User findByID(Long aLong) {
        return null;
    }

    @Override
    public Boolean deleteById(Long aLong) {
        return null;
    }

    @Override
    public Boolean isExist(Long aLong) {
        return null;
    }
}
