/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projek.keuangan;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author dira
 */
public class Koneksi {
    public static Connection sambung() {
        try {
            String url = "jdbc:mysql://localhost:3306/db_keuangan_ukm";
            String user = "root";
            String pass = "D1r4ndr4"; // Kosongkan jika tidak ada password di MySQL
            return DriverManager.getConnection(url, user, pass);
        } catch (SQLException e) {
            System.out.println("Koneksi Gagal: " + e.getMessage());
            return null;
        }
    }
}
