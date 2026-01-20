/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author Will
 */
import koneksi.config;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class user {
    private int id; 
    private String username; 
    private String password;
    
    public user(int id, String username, String password) { 
        this.id = id; 
        this.username = username; 
        this.password = password; 
    }
    
    public int getId() { return id; } 
    public String getUsername() { return username; } 
    public String getPassword() { return password; }

    // static login method
    public static user login(String username, String password) {
        try (Connection conn = config.getConnection()) {
            String sql = "SELECT * FROM user WHERE username=? AND password=?";
            PreparedStatement stmt = conn.prepareStatement(sql);
            stmt.setString(1, username);
            stmt.setString(2, password);

            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return new user(
                    rs.getInt("user_id"),   // pastikan kolom di DB memang "user_id"
                    rs.getString("username"),
                    rs.getString("password")
                );
            }
        } catch (SQLException e) {
            System.out.println("Error login: " + e.getMessage());
        }
        return null;
    }
}