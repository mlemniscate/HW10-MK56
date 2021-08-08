package ir.maktab.todo.front;

import ir.maktab.todo.domain.Activity;

import java.util.Comparator;

public class ActivityComparators{

    public static class CreatedDateComparator implements Comparator<Activity> {
        @Override
        public int compare(Activity activity1, Activity activity2) {
            return activity1.getCreatedDate().compareTo(activity2.getCreatedDate());
        }
    }

    public static class NameComparator implements Comparator<Activity> {
        @Override
        public int compare(Activity activity1, Activity activity2) {
            return activity1.getActivityName().compareTo(activity2.getActivityName());
        }
    }

    public static class LastUpdatedDateComparator implements Comparator<Activity> {
        @Override
        public int compare(Activity activity1, Activity activity2) {
            return activity1.getLastUpdatedDate().compareTo(activity2.getLastUpdatedDate());
        }
    }

    public static CreatedDateComparator getCreatedDateComparator() {
        return new CreatedDateComparator();
    }
}