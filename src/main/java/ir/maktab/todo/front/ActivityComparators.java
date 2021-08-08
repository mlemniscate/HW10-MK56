package ir.maktab.todo.front;

import ir.maktab.todo.domain.Activity;
import ir.maktab.todo.front.enumeration.ComparatorOrder;

import java.util.Comparator;

public class ActivityComparators{

    private static class CreatedDateComparator implements Comparator<Activity> {
        private final ComparatorOrder comparatorOrder;

        public CreatedDateComparator(ComparatorOrder comparatorOrder) {
            this.comparatorOrder = comparatorOrder;
        }

        @Override
        public int compare(Activity activity1, Activity activity2) {
            return comparatorOrder.equals(ComparatorOrder.ASC) ?
                    activity1.getCreatedDate().compareTo(activity2.getCreatedDate()) :
                    activity2.getCreatedDate().compareTo(activity1.getCreatedDate());
        }
    }

    public static class NameComparator implements Comparator<Activity> {
        private final ComparatorOrder comparatorOrder;

        public NameComparator(ComparatorOrder comparatorOrder) {
            this.comparatorOrder = comparatorOrder;
        }

        @Override
        public int compare(Activity activity1, Activity activity2) {
            return comparatorOrder.equals(ComparatorOrder.ASC) ?
                    activity1.getActivityName().compareTo(activity2.getActivityName()) :
                    activity2.getActivityName().compareTo(activity1.getActivityName());
        }
    }

    public static class LastUpdatedDateComparator implements Comparator<Activity> {
        private final ComparatorOrder comparatorOrder;

        public LastUpdatedDateComparator(ComparatorOrder comparatorOrder) {
            this.comparatorOrder = comparatorOrder;
        }

        @Override
        public int compare(Activity activity1, Activity activity2) {
            return comparatorOrder.equals(ComparatorOrder.ASC) ?
                    activity1.getLastUpdatedDate().compareTo(activity2.getLastUpdatedDate()) :
                    activity2.getLastUpdatedDate().compareTo(activity1.getLastUpdatedDate());
        }
    }

    public static class StatusComparator implements Comparator<Activity> {
        private final ComparatorOrder comparatorOrder;

        public StatusComparator(ComparatorOrder comparatorOrder) {
            this.comparatorOrder = comparatorOrder;
        }

        @Override
        public int compare(Activity activity1, Activity activity2) {
            return comparatorOrder.equals(ComparatorOrder.ASC) ?
                    activity1.getActivityStatus().compareTo(activity2.getActivityStatus()) :
                    activity2.getActivityStatus().compareTo(activity1.getActivityStatus());
        }
    }

    public static CreatedDateComparator getCreatedDateComparator(ComparatorOrder comparatorOrder) {
        return new CreatedDateComparator(comparatorOrder);
    }

    public static NameComparator getNameComparator(ComparatorOrder comparatorOrder) {
        return new NameComparator(comparatorOrder);
    }

    public static LastUpdatedDateComparator getLastUpdatedDateComparator(ComparatorOrder comparatorOrder) {
        return new LastUpdatedDateComparator(comparatorOrder);
    }

    public static StatusComparator getStatusComparator(ComparatorOrder comparatorOrder) {
        return new StatusComparator(comparatorOrder);
    }
}
