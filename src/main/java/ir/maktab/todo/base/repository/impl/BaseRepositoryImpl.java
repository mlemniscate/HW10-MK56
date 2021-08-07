package ir.maktab.todo.base.repository.impl;

import ir.maktab.todo.base.domain.BaseEntity;
import ir.maktab.todo.base.repository.BaseRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public class BaseRepositoryImpl<E extends BaseEntity<ID>, ID extends Serializable> implements
        BaseRepository<E, ID> {

    private final EntityManager entityManager;

    public BaseRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public E save(E e) {
        return null;
    }

    @Override
    public E update(E e) {
        return null;
    }

    @Override
    public List<E> findAll() throws SQLException {
        return null;
    }

    @Override
    public List<E> findAllByIds(Collection<ID> ids) {
        return null;
    }

    @Override
    public E findByID(ID id) {
        return null;
    }

    @Override
    public Boolean deleteById(ID id) {
        return null;
    }

    @Override
    public Boolean isExist(ID id) {
        return null;
    }
}
