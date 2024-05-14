/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package project;

import java.util.Random;

/**
 *
 * @author User
 */
public class User {
    private String email;
    private String username;
    private String password;
    private Role role;
    
    public User(String email, String username, String password, Role role) {
        this.email = email;
        this.username = username;
        this.password = password;
        this.role = role;
    }
    
    public static User register(String email, String username, String password, Role role) {
        return new User(email, username, password, role);
    }
    
    public boolean login(String emailOrUsername, String password) {
        return (emailOrUsername.equals(email) || emailOrUsername.equals(username)) && password.equals(this.password);
    }
    
    public String getEmail() {
        return email;
    }
    
    public String getUsername() {
        return username;
    }
    
    public String getPassword() {
        return password;
    }
    
    public Role getRole() {
        return role;
    }
    
    public String toString() {
        return  "Welcome\n" + username + " (" + role + ")\n";
    }
}
