package ir.maktab.todo.front.menus;


import ir.maktab.todo.ApplicationContext;
import ir.maktab.todo.domain.User;
import ir.maktab.todo.front.input.InputDouble;
import ir.maktab.todo.front.input.InputString;
import ir.maktab.todo.service.dto.CreateUserDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class FirstMenu extends Menu implements RunnableMenu<Void> {

    public FirstMenu(ArrayList<String> items) {
        super(items);
    }

    // This method do all the first menu tasks
    @Override
    public Void runMenu() throws SQLException {
        while (true) {
            showMenu();
            switch (getChosenItem()) {
                case 1:
//                    User loginUser = ApplicationContext.userService.login();
//                    if(!Objects.isNull(loginUser)) {
//                        new UserMenu(loginUser).runMenu();
//                    }
                    break;
                case 2:
                    CreateUserDTO signUpUserDTO = getSignUpUserInfo();
                    ApplicationContext.userService.signUp(signUpUserDTO);
                    break;
                case 3:
                    if (new CheckMenu(new ArrayList<String>() {{add("Yes");add("No");}},
                            "Are you sure you want to exit?").runMenu()) return null;
                    else break;
            }
        }
    }

    private CreateUserDTO getSignUpUserInfo() {
        return null;
    }

    // This method take all the information for sign a user and return an User user that information
    private CreateUserDTO enterUserInformation() throws SQLException {
        return new CreateUserDTO(
                enterFirstName(),
                enterLastName(),
                enterUsername(),
                enterPassword()
        );
    }

//    // Get a String array that made of all the users usernames
//    private String[] getUserNuser() throws SQLException {
//        ArrayList<String> list = new ArrayList<>();
//        List<User>user = findAll();
//        for (User user : users) {
//            list.add(user.getUsername());
//        }
//        return list.toArray(new String[0]);
//    }

    // Get user username
    private String enterUsername() throws SQLException {
        return new InputString("Enter your username: ",
                "Your username not valid(use 8 to 20 alphanumeric characters).\nNotice: Maybe this username taken by other authors.",
                "^(?=.{8,20}$)(?![_.])(?!.*[_.]{2})[a-zA-Z0-9._]+(?<![_.])$",
                ApplicationContext.userService.getAllUserNames()).getStringInput();
    }

    // Get user last name
    private String enterLastName() {
        return new InputString("Enter your last name: ",
                "Your last name must be 2 to 20 alphabetic characters.",
                "^[a-zA-Z]{2,20}$", null).getStringInput();
    }

    // Get user first name
    private String enterFirstName() {
        return new InputString("Enter your first name: ",
                "Your first name must be 2 to 20 alphabetic characters.",
                "^[a-zA-Z]{2,20}$", null).getStringInput();
    }

    // Get user password
    private String enterPassword() throws SQLException {
        return new InputString("Enter your password: ",
                "Your password must be minimum 8 characters, at least one letter and one number.",
                "^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$", null).getStringInput();
    }

    // Get deposit amount from user
    private double enterDepositAmount() throws SQLException {
        return new InputDouble("Enter your deposit amount between 1$ and 10,000$: ", 10_000, 1, null
        ).getDoubleInput();
    }

    public void editFirstName(User user) throws SQLException {
        user.setFirstName(enterFirstName());
    }

    public void editLastName(User user) throws SQLException {
        user.setLastName(enterLastName());
    }

    public void editUsername(User user) throws SQLException {
        user.setUsername(enterUsername());
    }

    public void editPassword(User user) throws SQLException {
        user.setPassword(enterPassword());
    }
}
