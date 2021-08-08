package ir.maktab.todo.front.menus;


import ir.maktab.todo.front.input.InputInt;

import java.util.List;

/*
* Menu is an abstract class that help you to create your sub menus
* */
public class Menu {
    private List<String> items;

    public Menu(List<String> items) {
        this.items = items;
    }

    // This method for showing menu for user
    public void showMenu() {
        System.out.println("------------------------------------------");
        for (int i = 0; i < items.size(); i++) {
            System.out.printf("[%d] - %s%n", (i+1), items.get(i));
        }
        System.out.println("------------------------------------------");
    }

    // This method taking input from user
    public int getChosenItem() {
        return new InputInt("Enter an item number: ", items.size(), 1, null)
                .getIntInput();
    }

    public List<String> getItems() {
        return items;
    }
}
