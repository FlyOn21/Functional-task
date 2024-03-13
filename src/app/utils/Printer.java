package app.utils;

import app.entitys.User;

import java.util.List;

public class Printer {
    public static void printUser(List<User> users, boolean printAll) {
        if (printAll) {
            printAllData(users);
        } else {
            printSharedData(users);
        }
    }
    private static void printAllData(List<User> users) {
        StringBuilder sb = new StringBuilder();
        users.forEach(user -> sb.append(String.format(
                "=================== User Name: %s ===================\n" +
                        "Email: %s\n" +
                        "Phone: %s\n" +
                        "Name: %s\n" +
                        "Salt: %s\n" +
                        "IsActive: %s\n" +
                        "IsAdmin: %s\n" +
                        "Creation Timestamp: %s\n" +
                        "Last Update Timestamp: %s\n\n",
                user.getUsername(), user.getEmail(), user.getPhone(), user.getName(),
                user.getSalt(), user.isActive() ? "Yes" : "No", user.isAdmin() ? "Yes" : "No",
                user.getCreateTimestamp(), user.getUpdateTimestamp())));
        System.out.println(sb);
    }

    private static void printSharedData(List<User> users) {
        StringBuilder sb = new StringBuilder();
        users.forEach(user -> sb.append(String.format(
                "=================== User Name: %s ===================\n" +
                        "Email: %s\n\n",
                user.getUsername(), user.getEmail())));
        System.out.println(sb);
    }
}
