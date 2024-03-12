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
        users.forEach(user -> sb.append("===================")
                .append(" User Name: ").append(user.getUsername()).append(" ===================").append("\n")
                .append("Email: ").append(user.getEmail()).append("\n")
                .append("Phone: ").append(user.getPhone()).append("\n")
                .append("Name: ").append(user.getName()).append("\n")
                .append("Salt: ").append(user.getSalt()).append("\n")
                .append("IsActive: ").append(user.isActive()? "Yes" : "No").append("\n")
                .append("IsAdmin: ").append(user.isAdmin() ? "Yes" : "No").append("\n")
                .append("Creation Timestamp: ").append(user.getCreateTimestamp()).append("\n")
                .append("Last Update Timestamp: ").append(user.getUpdateTimestamp())
                .append("\n")
                .append("\n"));
        System.out.println(sb);
    }

    private static void printSharedData(List<User> users) {
        StringBuilder sb = new StringBuilder();
        users.forEach(user -> sb.append("===================")
                .append(" User Name: ").append(user.getUsername()).append(" ===================").append("\n")
                .append("Email: ").append(user.getEmail()).append("\n")
                .append("\n")
                .append("\n"));
        System.out.println(sb);
    }
}
