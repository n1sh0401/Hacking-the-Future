/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package project;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */
public class Test {
    public static void main(String[] args) {
        // Create some sample users
        User user1 = new User("user1@example.com", "user1", "password1", Role.STUDENT);
        User user2 = new User("user2@example.com", "user2", "password2", Role.TEACHER);
        User user3 = new User("user3@example.com", "user3", "password3", Role.PARENT);
        User user4 = new User("user4@example.com", "user4", "password4", Role.PARENT);

        // Save users to CSV file
        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);
        users.add(user4);
        UserCSVStorage.saveUsers(users);

        // Load users from CSV file
        List<User> loadedUsers = UserCSVStorage.loadUsers();

        // Print loaded users
        System.out.println("Loaded Users:");
        for (User user : loadedUsers) {
            System.out.println(user);
        }
    }

}
