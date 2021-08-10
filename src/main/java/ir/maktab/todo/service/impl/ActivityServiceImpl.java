package ir.maktab.todo.service.impl;

import ir.maktab.todo.base.service.impl.BaseServiceImpl;
import ir.maktab.todo.domain.Activity;
import ir.maktab.todo.repository.ActivityRepository;
import ir.maktab.todo.service.ActivityService;

public class ActivityServiceImpl extends BaseServiceImpl<Activity, Long, ActivityRepository> implements ActivityService {

    public ActivityServiceImpl(ActivityRepository repository) {
        super(repository);
    }
}
