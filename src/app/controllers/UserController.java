package app.controllers;

import app.views.*;

import java.util.Scanner;

public class UserController {
    public void usersControllerProcessing() {
        String title = """
                ###############################
                Realize home work 11 Functional
                ###############################
                """;
        System.out.println(title);
        boolean running = true;
        Scanner scanner = new Scanner(System.in);
        while (running) {
            String menu = """ 
                    --------------
                    Choice action:
                    --------------
                    Choice 1 => see all users list
                    Choice 2 => see specific user
                    Choice 3 => create new user
                    Choice 4 => update exist user
                    Choice 5 => delete user
                    Choice 6 => stop and exit
                    """;
            System.out.println(menu);
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine().trim();

            switch (choice) {
                case "1":
                    AllUsersView allUsersView = new AllUsersView();
                    allUsersView.showAllUsers();
                    break;
                case "2":
                    SpecificUserView specificUserView = new SpecificUserView();
                    specificUserView.showUser(scanner);
                    break;
                case "3":
                    CreateUserView createUserView = new CreateUserView();
                    createUserView.createUser(scanner);
                    break;
                case "4":
                    UpdateUserView updateUserView = new UpdateUserView();
                    updateUserView.updateShow(scanner);
                    break;
                case "5":
                    DeleteUserView deleteUserView = new DeleteUserView();
                    deleteUserView.showDelete(scanner);
                    break;
                case "6":
                    running = false;
                    System.out.println("Exit...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
        scanner.close();
    }
}
