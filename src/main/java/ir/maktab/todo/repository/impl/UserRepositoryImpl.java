package ir.maktab.todo.repository.impl;

import ir.maktab.todo.base.repository.impl.BaseRepositoryImpl;
import ir.maktab.todo.domain.User;
import ir.maktab.todo.repository.UserRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public class UserRepositoryImpl extends BaseRepositoryImpl<User, Long> implements UserRepository {

    public UserRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public User save(User user) {
        entityManager.getTransaction().begin();
        entityManager.persist(user);
        entityManager.getTransaction().commit();
        Query query = entityManager.createQuery("from User order by id DESC");
        query.setMaxResults(1);
        User resultUser = (User) query.getResultList().get(0);
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
