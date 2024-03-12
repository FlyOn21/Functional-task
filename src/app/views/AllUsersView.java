package app.views;

import app.entitys.User;
import app.models.AllUsersOrSpecificUserModel;
import app.utils.Printer;

import java.util.List;

public class AllUsersView {
    private final AllUsersOrSpecificUserModel allUsersModel = new AllUsersOrSpecificUserModel();

    public void showAllUsers() {
        List<User> users = allUsersModel.allUsersGet();
        if (users.isEmpty()) {
            System.out.println("There is no users");
            return;
        }
        Printer.printUser(users, false);
    }

}
