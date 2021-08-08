package ir.maktab.todo.repository.impl;

import ir.maktab.todo.base.repository.impl.BaseRepositoryImpl;
import ir.maktab.todo.domain.Activity;
import ir.maktab.todo.repository.ActivityRepository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.sql.SQLException;
import java.util.Collection;
import java.util.List;

public class ActivityRepositoryImpl extends BaseRepositoryImpl<Activity, Long> implements ActivityRepository {

    public ActivityRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public Activity save(Activity activity) {
        entityManager.getTransaction().begin();
        entityManager.persist(activity);
        entityManager.getTransaction().commit();
        Query query = entityManager.createQuery("from Activity order by id DESC");
        query.setMaxResults(1);
        return (Activity) query.getResultList().get(0);
    }

    @Override
    public Activity update(Activity activity) {
        return null;
    }

    @Override
    public List<Activity> findAll() throws SQLException {
        return null;
    }

    @Override
    public List<Activity> findAllByIds(Collection<Long> longs) {
        return null;
    }

    @Override
    public Activity findByID(Long aLong) {
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
