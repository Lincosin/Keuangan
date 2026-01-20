/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.projek.keuangan;

/**
 *
 * @author dira
 */
public class Transaksi {
    private String keterangan;
    private double nominal;
    private String jenis; // Pemasukan atau Pengeluaran

    public Transaksi(String keterangan, double nominal, String jenis) {
        this.keterangan = keterangan;
        this.nominal = nominal;
        this.jenis = jenis;
    }

    // Getter
    public String getKeterangan() { return keterangan; }
    public double getNominal() { return nominal; }
    public String getJenis() { return jenis; }
}