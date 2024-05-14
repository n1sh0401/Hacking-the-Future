/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ds.project;

/**
 *
 * @author mdani
 */
public class Teacher extends User {
    public Teacher(String email, String username, String password) {
        super(email, username, password, Role.TEACHER);
    }

    // Additional methods specific to Teacher can be added here
}


