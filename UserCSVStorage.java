/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package project;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author User
 */

public class UserCSVStorage {
    private static final String file = "C:\\Users\\User\\Documents\\degree\\SacramentocrimeJanuary2006.csv";

    public static void saveUsers(List<User> users) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
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
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                users.add(csvToUser(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return users;
    }

    // Helper method to convert user object to CSV string
    private static String userToCSV(User user) {
        return String.join(",", user.getEmail(), user.getUsername(), user.getPassword(), user.getRole().getRoleName());
    }

    // Helper method to convert CSV string to user object
    private static User csvToUser(String csv) {
        String[] parts = csv.split(",");
        String email = parts[0];
        String username = parts[1];
        String password = parts[2];
        Role role = getRoleFromString(parts[3]);
        return new User(email, username, password, role);
    }

    // Helper method to get Role object from string
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