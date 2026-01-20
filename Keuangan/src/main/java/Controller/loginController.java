/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author Will
 */
import Model.user;

public class loginController {
    
    // Method login: menerima username & password dari View
    public user login(String username, String password) {
        // Panggil static method login di model.user
        user u = user.login(username, password);
        
        if (u != null) {
            System.out.println("Login berhasil: " + u.getUsername());
            return u; // return objek user ke View
        } else {
            System.out.println("Login gagal: username/password salah");
            return null; // return null kalau gagal
        }
    }
}