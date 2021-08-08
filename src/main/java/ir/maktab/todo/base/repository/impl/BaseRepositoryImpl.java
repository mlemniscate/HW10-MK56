package ir.maktab.todo.base.repository.impl;

import ir.maktab.todo.base.domain.BaseEntity;
import ir.maktab.todo.base.repository.BaseRepository;

import javax.persistence.EntityManager;
import java.io.Serializable;

public abstract class BaseRepositoryImpl<E extends BaseEntity<ID>, ID extends Serializable> implements
        BaseRepository<E, ID> {

    protected final EntityManager entityManager;

    public BaseRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
}
