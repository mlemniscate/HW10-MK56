package ir.maktab.todo.domain;

import ir.maktab.todo.base.domain.BaseEntity;
import ir.maktab.todo.domain.enumeration.ActivityStatus;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = Activity.TABLE_NAME)
public class Activity extends BaseEntity<Long> {

    public static final String TABLE_NAME = "activities";
    public static final String ACTIVITY_NAME = "activity_name";
    public static final String CREATED_DATE = "created_date";
    public static final String ACTIVITY_STATUS = "activity_status";
    public static final String DESCRIPTION = "description";
    public static final String LAST_UPDATED_DATE = "last_updated_date";

    @Column(name = ACTIVITY_NAME)
    private String activityName;

    @Column(name = DESCRIPTION)
    private String description;

    @Column(name = CREATED_DATE)
    private Date createdDate;

    @Column(name = LAST_UPDATED_DATE)
    private Date lastUpdatedDate;

    @Column(name = ACTIVITY_STATUS)
    @Enumerated(EnumType.STRING)
    private ActivityStatus activityStatus;

}
