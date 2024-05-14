/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package ds.project;

/**
 *
 * @author mdani
 */
import java.util.*;

public class Test {
    public static void main(String[] args) {
        // Create some sample users using the register method
        User user1 = User.register("user1@example.com", "user1", "password1", Role.STUDENT);
        User user2 = User.register("user2@example.com", "user2", "password2", Role.TEACHER);
        User user3 = User.register("user3@example.com", "user3", "password3", Role.PARENT);
        User user4 = User.register("user4@example.com", "user4", "password4", Role.PARENT);

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

        // Print all students
        System.out.println("\nAll Students:");
        List<User> students = UserCSVStorage.getUsersByRole(Role.STUDENT);
        for (User student : students) {
            System.out.println(student);
        }

        // Print all teachers
        System.out.println("\nAll Teachers:");
        List<User> teachers = UserCSVStorage.getUsersByRole(Role.TEACHER);
        for (User teacher : teachers) {
            System.out.println(teacher);
        }

        // Print all parents
        System.out.println("\nAll Parents:");
        List<User> parents = UserCSVStorage.getUsersByRole(Role.PARENT);
        for (User parent : parents) {
            System.out.println(parent);
        }
    }
}



