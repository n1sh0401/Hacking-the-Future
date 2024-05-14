/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ds.project;

/**
 *
 * @author mdani
 */
public abstract class User {
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
        switch (role.getRoleName()) {
            case "student":
                return new Student(email, username, password);
            case "teacher":
                return new Teacher(email, username, password);
            case "parent":
                return new Parent(email, username, password);
            default:
                throw new IllegalArgumentException("Invalid role");
        }
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

    @Override
    public String toString() {
        return "Welcome\n" + username + " (" + role + ")\n";
    }
}


