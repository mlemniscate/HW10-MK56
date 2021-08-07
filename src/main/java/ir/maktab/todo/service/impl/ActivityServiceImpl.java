package ir.maktab.todo.service.impl;

import ir.maktab.todo.base.service.impl.BaseServiceImpl;
import ir.maktab.todo.domain.Activity;
import ir.maktab.todo.repository.ActivityRepository;

public class ActivityServiceImpl extends BaseServiceImpl<Activity, Long, ActivityRepository> {

    public ActivityServiceImpl(ActivityRepository repository) {
        super(repository);
    }

}
