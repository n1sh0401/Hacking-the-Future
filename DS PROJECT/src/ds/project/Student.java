/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ds.project;

/**
 *
 * @author mdani
 */
public class Student extends User {
    public Student(String email, String username, String password) {
        super(email, username, password, Role.STUDENT);
    }

    // Additional methods specific to Student can be added here
}


