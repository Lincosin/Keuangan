CREATE DATABASE IF NOT EXISTS db_keuangan_ukm;
USE db_keuangan_ukm;

-- Tabel User (Untuk LoginForm)
CREATE TABLE IF NOT EXISTS user (
    id_user INT PRIMARY KEY AUTO_INCREMENT,
    username VARCHAR(50) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL
);

-- Tabel Transaksi (Sinkron dengan TransaksiForm)
CREATE TABLE IF NOT EXISTS transaksi (
    id_transaksi INT PRIMARY KEY AUTO_INCREMENT,
    tgl_transaksi DATE NOT NULL,          -- Untuk datePicker1
    jenis_transaksi ENUM('Pemasukan', 'Pengeluaran'), -- Untuk cbJenis
    event VARCHAR(100),                   -- Untuk cbEvent
    nominal DOUBLE NOT NULL,               -- Untuk txtNominal
    keterangan TEXT                        -- Untuk txtKeterangan
);

-- Data Awal
INSERT INTO user (username, password) VALUES ('admin', 'admin123');