/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ds.project;

/**
 *
 * @author mdani
 */

import java.io.*;
import java.util.*;

public class UserCSVStorage {
    private static final String FILE_NAME = "users.csv";

    public static void saveUsers(List<User> users) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (User user : users) {
                writer.write(userToCSV(user));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<User> loadUsers() {
        List<User> users = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                users.add(csvToUser(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

    public static List<User> getUsersByRole(Role role) {
        List<User> allUsers = loadUsers();
        List<User> filteredUsers = new ArrayList<>();
        for (User user : allUsers) {
            if (user.getRole().equals(role)) {
                filteredUsers.add(user);
            }
        }
        return filteredUsers;
    }

    private static String userToCSV(User user) {
        return String.join(",", user.getEmail(), user.getUsername(), user.getPassword(), user.getRole().getRoleName());
    }

    private static User csvToUser(String csvLine) {
        String[] parts = csvLine.split(",");
        String email = parts[0];
        String username = parts[1];
        String password = parts[2];
        Role role = getRoleFromString(parts[3]);
        return User.register(email, username, password, role);
    }

    private static Role getRoleFromString(String roleName) {
        switch (roleName) {
            case "teacher":
                return Role.TEACHER;
            case "student":
                return Role.STUDENT;
            case "parent":
                return Role.PARENT;
            default:
                throw new IllegalArgumentException("Invalid role name: " + roleName);
        }
    }
}

