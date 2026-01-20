/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package View;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author A4
 */
public class dashForm extends javax.swing.JFrame {
    DefaultTableModel model;
    /**
     * Creates new form dashForm
     */
    public dashForm() {
        initComponents();
        loadSummary();
        loadTransaksi();
    }

    private void loadSummary() {
        try (Connection conn = Koneksi.sambung();
             Statement st = conn.createStatement()) {

            // total pemasukan
            ResultSet rs1 = st.executeQuery(
                    "SELECT IFNULL(SUM(nominal),0) AS total FROM transaksi WHERE jenis_transaksi='Pemasukan'"
            );
            rs1.next();
            double totalPemasukan = rs1.getDouble("total");

            // total pengeluaran
            ResultSet rs2 = st.executeQuery(
                    "SELECT IFNULL(SUM(nominal),0) AS total FROM transaksi WHERE jenis_transaksi='Pengeluaran'"
            );
            rs2.next();
            double totalPengeluaran = rs2.getDouble("total");

            double saldo = totalPemasukan - totalPengeluaran;

            lblTotalPemasukan.setText("Rp " + formatRupiah(totalPemasukan));
            lblTotalPengeluaran.setText("Rp " + formatRupiah(totalPengeluaran));
            lblSaldo.setText("Saldo: Rp " + formatRupiah(saldo));

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error load summary: " + e.getMessage());
        }
    }

    private void loadTransaksi() {
        model.setRowCount(0);
        try (Connection conn = Koneksi.sambung();
             Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery(
                     "SELECT id_transaksi, tgl_transaksi, jenis_transaksi, event, nominal, keterangan "
                             + "FROM transaksi ORDER BY id_transaksi DESC")) {

            while (rs.next()) {
                model.addRow(new Object[]{
                    rs.getInt("id_transaksi"),
                    rs.getString("tgl_transaksi"),
                    rs.getString("jenis_transaksi"),
                    rs.getString("event"),
                    rs.getDouble("nominal"),
                    rs.getString("keterangan")
                });
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Error load transactions: " + e.getMessage());
        }
    }

    private String formatRupiah(double value) {
        return String.format("%,.0f", value).replace(',', '.');
    }
    
     private void initComponents() {

        lblHeader = new javax.swing.JLabel();
        lblTotalPemasukan = new javax.swing.JLabel();
        lblTotalPengeluaran = new javax.swing.JLabel();
        lblSaldo = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTransaksi = new javax.swing.JTable();
        btnTambah = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblHeader.setFont(new java.awt.Font("Arial", 1, 24));
        lblHeader.setText("Dashboard Keuangan UKM");

        lblTotalPemasukan.setFont(new java.awt.Font("Arial", 1, 18));
        lblTotalPemasukan.setText("Rp 0");

        lblTotalPengeluaran.setFont(new java.awt.Font("Arial", 1, 18));
        lblTotalPengeluaran.setText("Rp 0");

        lblSaldo.setFont(new java.awt.Font("Arial", 1, 18));
        lblSaldo.setText("Saldo: Rp 0");

        tblTransaksi.setModel(new DefaultTableModel(
            new Object [][] {},
            new String [] {
                "ID","Tanggal","Jenis","Event","Nominal","Keterangan"
            }
        ));
        model = (DefaultTableModel) tblTransaksi.getModel();
        jScrollPane2.setViewportView(tblTransaksi);

        btnTambah.setText("Tambah Transaksi");
        btnTambah.addActionListener(evt -> {
            dispose();
        });

        btnRefresh.setText("Refresh");
        btnRefresh.addActionListener(evt -> {
            loadSummary();
            loadTransaksi();
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(lblHeader, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblTotalPemasukan)
                .addGap(50, 50, 50)
                .addComponent(lblTotalPengeluaran)
                .addGap(50, 50, 50)
                .addComponent(lblSaldo)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(jScrollPane2)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(btnTambah)
                .addGap(20, 20, 20)
                .addComponent(btnRefresh)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(lblHeader)
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lblTotalPemasukan)
                    .addComponent(lblTotalPengeluaran)
                    .addComponent(lblSaldo))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTambah)
                    .addComponent(btnRefresh))
                .addGap(20, 20, 20))
        );

        pack();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblHeader = new javax.swing.JLabel();
        lblTotalPemasukan = new javax.swing.JLabel();
        lblTotalPengeluaran = new javax.swing.JLabel();
        lblSaldo = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tblTransaksi = new javax.swing.JTable();
        btnTambah = new javax.swing.JButton();
        btnRefresh = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblHeader.setText("Dashboard Keuangan UKM");

        lblTotalPemasukan.setText("Total Pemasukan");

        lblTotalPengeluaran.setText("Total Pengeluaran");

        lblSaldo.setText("Saldo");

        tblTransaksi.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID Transaksi", "Tanggal Transaksi", "Jenis Transaksi", "Event", "Nominal", "Keterangan"
            }
        ));
        jScrollPane2.setViewportView(tblTransaksi);

        btnTambah.setText("Tambah Transaksi");

        btnRefresh.setText("Refrresh");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblTotalPemasukan)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(lblTotalPengeluaran)
                .addGap(160, 160, 160)
                .addComponent(lblSaldo)
                .addGap(139, 139, 139))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(43, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 671, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(36, 36, 36))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblHeader)
                        .addGap(300, 300, 300))))
            .addGroup(layout.createSequentialGroup()
                .addGap(144, 144, 144)
                .addComponent(btnTambah)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnRefresh)
                .addGap(186, 186, 186))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(lblHeader)
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTotalPengeluaran)
                    .addComponent(lblSaldo)
                    .addComponent(lblTotalPemasukan))
                .addGap(31, 31, 31)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTambah)
                    .addComponent(btnRefresh))
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(dashForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(dashForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(dashForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(dashForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new dashForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnRefresh;
    private javax.swing.JButton btnTambah;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblHeader;
    private javax.swing.JLabel lblSaldo;
    private javax.swing.JLabel lblTotalPemasukan;
    private javax.swing.JLabel lblTotalPengeluaran;
    private javax.swing.JTable tblTransaksi;
    // End of variables declaration//GEN-END:variables
}
