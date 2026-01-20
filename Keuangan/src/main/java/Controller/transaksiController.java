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

public class transaksiController {
    public void loadData(DefaultTableModel model) {
        Transaksi.loadData(model);
    }

    public boolean tambahTransaksi(Transaksi t) {
        return t.insert();
    }

    public boolean editTransaksi(Transaksi t) {
        return t.update();
    }

    public double hitungSaldo() {
        return Transaksi.hitungSaldo();
    }
}