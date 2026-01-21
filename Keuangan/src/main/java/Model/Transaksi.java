/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author dira
 */
import Model.Transaksi;
import koneksi.config;
import java.sql.*;
import javax.swing.table.DefaultTableModel;
import koneksi.config;

public class Transaksi {
    public int transaksiId;
    public int userId;
    public Date tanggal;
    public String jenis;
    public String event;
    public double jumlah;
    public String deskripsi;

    // Constructor tanpa ID (untuk insert baru)
    public Transaksi(int userId, Date tanggal, String jenis, String event, double jumlah, String deskripsi) {
        this.userId = userId;
        this.tanggal = tanggal;
        this.jenis = jenis;
        this.event = event;
        this.jumlah = jumlah;
        this.deskripsi = deskripsi;
    }
    
    //constructor untuk edit
    public Transaksi(int transaksiId, Date tanggal, String jenis, String event, double jumlah, String deskripsi, int userId) {
        this.transaksiId = transaksiId;
        this.tanggal = tanggal;
        this.jenis = jenis;
        this.event = event;
        this.jumlah = jumlah;
        this.deskripsi = deskripsi;
        this.userId = userId;
    }

    public static void loadData(DefaultTableModel model) {
        model.setRowCount(0);
        try (Connection conn = config.getConnection();
             Statement st = conn.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT * FROM transaksi ORDER BY transaksi_id DESC");
            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("transaksi_id"),
                    rs.getDate("tanggal"),
                    rs.getString("jenis"),
                    rs.getString("event"),
                    rs.getDouble("jumlah"),
                    rs.getString("deskripsi")
                });
            }
        } catch (Exception e) {
            System.out.println("Gagal memuat data: " + e.getMessage());
        }
    }

    public boolean insert() {
        try (Connection conn = config.getConnection()) {
            String sql = "INSERT INTO transaksi (user_id, tanggal, jenis, event, jumlah, deskripsi) VALUES (?,?,?,?,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);
            ps.setDate(2, tanggal);
            ps.setString(3, jenis);
            ps.setString(4, event);
            ps.setDouble(5, jumlah);
            ps.setString(6, deskripsi);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Gagal tambah transaksi: " + e.getMessage());
            return false;
        }
    }

    public boolean update() {
        try (Connection conn = config.getConnection()) {
            String sql = "UPDATE transaksi SET user_id=?, tanggal=?, jenis=?, event=?, jumlah=?, deskripsi=? WHERE transaksi_id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, userId);
            ps.setDate(2, tanggal);
            ps.setString(3, jenis);
            ps.setString(4, event);
            ps.setDouble(5, jumlah);
            ps.setString(6, deskripsi);
            ps.setInt(7, transaksiId);
            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            System.out.println("Gagal edit transaksi: " + e.getMessage());
            return false;
        }
    }

    public static double hitungSaldo() {
        double saldo = 0;
        try (Connection conn = config.getConnection();
             Statement st = conn.createStatement()) {
            ResultSet rsIn = st.executeQuery("SELECT SUM(jumlah) AS total FROM transaksi WHERE jenis='Pemasukan'");
            if (rsIn.next()) saldo += rsIn.getDouble("total");

            ResultSet rsOut = st.executeQuery("SELECT SUM(jumlah) AS total FROM transaksi WHERE jenis='Pengeluaran'");
            if (rsOut.next()) saldo -= rsOut.getDouble("total");
        } catch (Exception e) {
            System.out.println("Gagal hitung saldo: " + e.getMessage());
        }
        return saldo;
    }
}