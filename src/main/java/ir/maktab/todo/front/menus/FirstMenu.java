package ir.maktab.todo.front.menus;


import ir.maktab.todo.ApplicationContext;
import ir.maktab.todo.domain.User;
import ir.maktab.todo.front.input.InputString;
import ir.maktab.todo.service.dto.CreateUserDTO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

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
                    String username = new InputString("Enter your username: ").getStringInput();
                    String password = new InputString("Enter your password: ").getStringInput();
                    User loginUser = ApplicationContext.userService.logIn(username, password);
                    if (!Objects.isNull(loginUser)) {
                        new UserMenu(
                                new ArrayList<String>() {{
                                    add("");
                                }},
                                loginUser
                        ).runMenu();
                    } else {
                        System.out.println("Your password or username is wrong!");
                    }
                    break;
                case 2:
                    CreateUserDTO signUpUserDTO = enterUserInformation();
                    ApplicationContext.userService.signUp(signUpUserDTO);
                    break;
                case 3:
                    if (new CheckMenu(new ArrayList<String>() {{
                        add("Yes");
                        add("No");
                    }},
                            "Are you sure you want to exit?").runMenu()) return null;
                    else break;
            }
        }
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
