package ir.maktab.todo.domain;

import ir.maktab.todo.base.domain.BaseEntity;
import ir.maktab.todo.domain.enumeration.ActivityStatus;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = Activity.TABLE_NAME)
public class Activity extends BaseEntity<Long> implements Comparable<Activity>{

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
    private Timestamp createdDate;

    @Column(name = LAST_UPDATED_DATE)
    private Timestamp lastUpdatedDate;

    @Column(name = ACTIVITY_STATUS)
    @Enumerated(EnumType.STRING)
    private ActivityStatus activityStatus;

    @ManyToOne
    @JoinColumn(name="user_id", nullable=false)
    private User user;

    public Activity(String activityName, String description, Timestamp createdDate, Timestamp lastUpdatedDate, ActivityStatus activityStatus, User user) {
        this.activityName = activityName;
        this.description = description;
        this.createdDate = createdDate;
        this.lastUpdatedDate = lastUpdatedDate;
        this.activityStatus = activityStatus;
        this.user = user;
    }

    public Activity() {
    }

    @Override
    public String toString() {
        return "Activity Name = " + activityName + '\n' +
                "Description = " + description + '\n' +
                "Activity Status = " + activityStatus + '\n' +
                "Created Date = " + createdDate + '\n' +
                "Last Updated Date = " + lastUpdatedDate;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public Timestamp getLastUpdatedDate() {
        return lastUpdatedDate;
    }

    public void setLastUpdatedDate(Timestamp lastUpdatedDate) {
        this.lastUpdatedDate = lastUpdatedDate;
    }

    public ActivityStatus getActivityStatus() {
        return activityStatus;
    }

    public void setActivityStatus(ActivityStatus activityStatus) {
        this.activityStatus = activityStatus;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public int compareTo(Activity o) {
        return activityName.compareTo(o.activityName);
    }
}
