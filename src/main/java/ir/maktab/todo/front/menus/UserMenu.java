package ir.maktab.todo.front.menus;


import ir.maktab.todo.ApplicationContext;
import ir.maktab.todo.domain.Activity;
import ir.maktab.todo.domain.User;
import ir.maktab.todo.domain.enumeration.ActivityStatus;
import ir.maktab.todo.front.input.InputString;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
                    Activity activity = getActivityInformation();
                    user.getActivities().add(ApplicationContext.activityService.save(activity));
                    break;
//                case 2:
//                    Product product = ApplicationContext.productService.getProduct();
//                    int quantity = new InputInt("How much do you want?", product.getStock(), 1, null).getIntInput();
//                    ApplicationContext.cartService.addProductToCart(product, cart, quantity);
//                    break;
//                case 3:
//                    ApplicationContext.customerService.depositBalance(user);
//                    break;
//                case 4:
//                    new EditUserInformationMenu(user).runMenu();
//                    break;
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

    private Activity getActivityInformation() {
        return new Activity(
                enterName(),
                enterDescription(),
                new Date(System.currentTimeMillis()),
                new Date(System.currentTimeMillis()),
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

    private void showActivities() {
        Set<Activity> activities = user.getActivities();
        int count = 0;
        for (Activity activity : activities) {
            System.out.printf("%02d%n%s%n",++count , activity.toString());
        }
    }
}


