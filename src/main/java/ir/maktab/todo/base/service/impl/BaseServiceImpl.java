package ir.maktab.todo.base.service.impl;

import ir.maktab.todo.base.domain.BaseEntity;
import ir.maktab.todo.base.repository.BaseRepository;
import ir.maktab.todo.base.service.BaseService;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public class BaseServiceImpl<E extends BaseEntity<ID>, ID extends Serializable, R extends BaseRepository<E, ID>>
        implements BaseService<E, ID> {

    protected final R repository;

    public BaseServiceImpl(R repository) {
        this.repository = repository;
    }

    @Override
    public E save(E e) {
        return repository.save(e);
    }

    @Override
    public E update(E e) {
        return repository.update(e);
    }

    @Override
    public List<E> findAll() throws SQLException {
        return repository.findAll();
    }

    @Override
    public List<E> findAllByIds(Collection<ID> ids) {
        return repository.findAllByIds(ids);
    }

    @Override
    public E findByID(ID id) {
        return repository.findByID(id);
    }

    @Override
    public Boolean deleteById(ID id) {
        return repository.deleteById(id);
    }

    @Override
    public Boolean isExist(ID id) {
        return repository.isExist(id);
    }
}
