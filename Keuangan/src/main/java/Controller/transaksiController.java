/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

/**
 *
 * @author Will
 */
import Model.Transaksi;
import javax.swing.table.DefaultTableModel;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class transaksiController {

    // Load data ke tabel
    public void loadData(DefaultTableModel model) {
        Transaksi.loadData(model);
    }

    // Tambah transaksi dengan validasi
    public boolean tambahTransaksi(Transaksi t) {
        // Validasi nominal
        if (t.jumlah <= 0) {
            JOptionPane.showMessageDialog(null, "Nominal harus lebih dari 0!");
            return false;
        }

        // Validasi jenis
        if (t.jenis == null || t.jenis.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Jenis transaksi harus dipilih!");
            return false;
        }

        // Validasi event
        if (t.event == null || t.event.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Event harus dipilih!");
            return false;
        }

        // Validasi keterangan
        if (t.deskripsi == null || t.deskripsi.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Keterangan tidak boleh kosong!");
            return false;
        }

        // Validasi tanggal
        if (t.tanggal == null) {
            JOptionPane.showMessageDialog(null, "Tanggal transaksi harus diisi!");
            return false;
        }

        // Kalau lolos semua validasi → simpan
        return t.insert();
    }

    // Edit transaksi dengan validasi
    public boolean editTransaksi(Transaksi t) {
        if (t.jumlah <= 0) {
            JOptionPane.showMessageDialog(null, "Nominal harus lebih dari 0!");
            return false;
        }

        if (t.tanggal == null) {
            JOptionPane.showMessageDialog(null, "Tanggal transaksi harus diisi!");
            return false;
        }

        return t.update();
    }

    // Hitung saldo
    public double hitungSaldo() {
        return Transaksi.hitungSaldo();
    }
}