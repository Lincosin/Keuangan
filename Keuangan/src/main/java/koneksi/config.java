/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package koneksi;

/**
 *
 * @author Will
 */
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
public class config {
    
    public static Connection getConnection() {
        try {
            String url = "jdbc:mysql://localhost:3306/keuangan";
            String USER = "root";
            String PASS = "";
            Connection conn = DriverManager.getConnection(url, USER, PASS);
            System.out.println("Koneksi berhasil");
            return conn;
        } catch (SQLException e) {
            System.out.println("Koneksi gagal: " + e.getMessage());
            return null;
        }
    }
}