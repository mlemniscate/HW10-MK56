package ir.maktab.todo.front.menus;


import ir.maktab.todo.ApplicationContext;
import ir.maktab.todo.domain.Activity;
import ir.maktab.todo.domain.User;
import ir.maktab.todo.domain.enumeration.ActivityStatus;
import ir.maktab.todo.front.input.InputInt;
import ir.maktab.todo.front.input.InputString;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class UserMenu extends Menu implements RunnableMenu<Void>{
    private final User user;

    public UserMenu(List<String> items, User user) {
        super(items);
        this.user = user;
        System.out.printf("\n\nWelcome to your page %s %s.%n", user.getFirstName(), user.getLastName());
        showActivities();
    }

    @Override
    public Void runMenu() throws SQLException {
        while (true) {
            showMenu();
            switch (getChosenItem()) {
                case 1:
                    Activity savedActivity = getActivityInformation();
                    user.getActivities().add(ApplicationContext.activityService.save(savedActivity));
                    showActivities();
                    break;
                case 2:
                    Activity activity = changeStatusOfAnActivity();
                    ApplicationContext.activityService.update(activity);
                    showActivities();
                    break;
//                case 3:
//                    ApplicationContext.customerService.depositBalance(user);
//                    break;
                case 4:

                    break;
                case 5:
                    if (new CheckMenu(new ArrayList<String>() {{
                        add("Yes");
                        add("No");
                    }},
                            "Are you sure you want to log out?").runMenu()) return null;
                    else break;
            }
        }
    }

    private Activity changeStatusOfAnActivity() {
        Activity activity = chooseActivity();
        System.out.println("\n1.Open\n2.In Progress\n3.Completed");
        int chosenItem = new InputInt("Choose a status for your activity: ", 3, 1, null).getIntInput();
        activity.setActivityStatus(
                chosenItem == 1 ? ActivityStatus.OPEN
                        : chosenItem == 2 ? ActivityStatus.IN_PROGRESS
                        : ActivityStatus.COMPLETED);
        activity.setLastUpdatedDate(new Timestamp(System.currentTimeMillis()));
        return activity;
    }

    private Activity chooseActivity() {
        List<Activity> activities = showActivities();
        int chosenItem = new InputInt("Enter your activity number: ",
                user.getActivities().size(), 1, null).getIntInput() - 1;
        return activities.get(chosenItem);
    }

    private Activity getActivityInformation() {
        return new Activity(
                enterName(),
                enterDescription(),
                new Timestamp(System.currentTimeMillis()),
                new Timestamp(System.currentTimeMillis()),
                ActivityStatus.OPEN,
                user
        );
    }

    private String enterDescription() {
        return new InputString("Enter your activity description: ").getStringInput();
    }

    private String enterName() {
        return new InputString("Enter your activity name: ").getStringInput();
    }

    private List<Activity> showActivities(Comparator<Activity> comparator) {
        List<Activity> activities = new ArrayList<>(user.getActivities());
        activities.sort(comparator);
        int count = 0;
        for (Activity activity : activities) {
            System.out.printf("%n#%02d%n%s%n", ++count, activity.toString());
        }
        return activities;
    }
}


