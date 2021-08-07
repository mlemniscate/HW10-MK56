package ir.maktab.todo.repository.impl;

import ir.maktab.todo.base.repository.impl.BaseRepositoryImpl;
import ir.maktab.todo.domain.Activity;
import ir.maktab.todo.repository.ActivityRepository;

import javax.persistence.EntityManager;

public class ActivityRepositoryImpl extends BaseRepositoryImpl<Activity, Long> implements ActivityRepository {

    public ActivityRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }
}
