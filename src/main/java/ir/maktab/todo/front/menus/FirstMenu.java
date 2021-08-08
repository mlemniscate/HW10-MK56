package ir.maktab.todo.front.menus;


import ir.maktab.todo.service.dto.CreateUserDTO;

import java.sql.SQLException;

public class FirstMenu extends Menu implements RunnableMenu<Void> {

    public FirstMenu() {
        super(new String[]{"Login", "Sign Up", "Exit"});
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
//                    ApplicationContext.userService.signUp(signUpUser);
                    break;
                case 3:
                    if (new CheckMenu("Are you sure you want to exit?").runMenu()) return null;
                    else break;
            }
        }
    }

    private CreateUserDTO getSignUpUserInfo() {
        return null;
    }
}
