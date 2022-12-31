package FahriAndika;

import java.sql.*;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Date;

//inheritance
public class Transaksi extends Pelanggan {
    static Connection con;
    public String villa;
    public Integer pilihvilla;

    String url = "jdbc:mysql://localhost:3306/sewavilla";
    String username = "root";
    String password = "";

    Date date = new Date();
    String tanggal = String.format("%tF", date);

    @Override
    public void jenisvilla() {
        System.out.print("Inputkan Nomor Villa         = ");
        pilihvilla = input.nextInt();

        // percabangan
        if (pilihvilla == 1) {
            jenisvilla = "Villa Biru";
        }

        else if (pilihvilla == 2) {
            jenisvilla = "Villa Putih";
        }

        else if (pilihvilla == 3) {
            jenisvilla = "Villa Merah";
        }

    }

    @Override
    public void hargavilla() {
        // percabangan
        if (pilihvilla == 1) {
            hargavilla = 1000000;
        }

        else if (pilihvilla == 2) {
            hargavilla = 2000000;
        }

        else if (pilihvilla == 3) {
            hargavilla = 3000000;
        }

    }

    // ==============================================================================================================================================================================================================================================================================
    // pengolahan database
    public void tambahData() throws SQLException, ClassNotFoundException {
        // exception
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);

            String text = "========reservasi villa========";
            // METHOD STRING, mengubah tulisan kecil jadi besar
            System.out.println(text.toUpperCase());
            System.out.println("===============================");

            namaCustomer();
            jenisvilla();
            hargavilla();
            lamaMenginap();
            System.out.println("\n=====Ringkasan Reservasi=====");
            System.out.println("Jenis Villa                 = " + jenisvilla);
            System.out.println("Harga Villa                 = " + hargavilla);
            totalHarga();
            tanggal();
            waktu();

            String sql = "INSERT INTO reservasi (namacustomer, jenisvilla, hargavilla, lamamenginap, totalharga, tanggaltransaksi) VALUES ('"
                    + namaCustomer + "','" + jenisvilla + "','" + hargavilla + "','"
                    + lamaMenginap + "', '" + totalHarga + "', '" + tanggal + "')";

            Statement statement = con.createStatement();
            statement.execute(sql);
            System.out.println("Data Berhasil Diinputkan!");
        }

        catch (SQLException e) {
            System.err.println("\nTerjadi kesalahan input data");
        } catch (InputMismatchException e) {
            System.err.println("\nInputlah dengan angka saja");
        }
    }

    // ==============================================================================================================================================================================================================================================================================
    // pengolahan database
    public void tampilkandata() throws SQLException, ClassNotFoundException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(url, username, password);
        String text = "=======DATA RESERVASI VILLA=======";
        System.out.println(text.toUpperCase());
        System.out.println("====================================");

        String sql = "SELECT * FROM reservasi";
        Statement statement = con.createStatement();
        ResultSet result = statement.executeQuery(sql);

        System.out.println(
                "\n=====================================================================================================");
        String format1 = "|%-2s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|\n";
        System.out.printf(format1, "No", "Nama Customer", "Jenis Villa", "Harga Villa", "Lama Menginap",
                "Total Harga", "Tanggal");
        System.out.println(
                "\n=====================================================================================================");

        while (result.next()) {
            String format2 = "|%-2s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|\n";
            System.out.printf(format2, result.getInt("nopemesanan"), result.getString("namacustomer"),
                    result.getString("jenisvilla"), result.getInt("hargavilla"), result.getInt("lamamenginap"),
                    result.getInt("totalharga"), result.getDate("tanggaltransaksi"));
            System.out.println(
                    "\n-----------------------------------------------------------------------------------------------------");
        }
    }

    // ==============================================================================================================================================================================================================================================================================
    // pengolahan database
    public void ubahdata() throws SQLException, ClassNotFoundException {
        String text = "=====UBAH DATA PEMBELIAN=====";
        System.out.println(text.toUpperCase());
        System.out.println("=============================");

        Scanner inputan = new Scanner(System.in);

        // exception
        try {
            tampilkandata();

            System.out.print("Masukkan No Pemesanan  yang Akan diubah : ");
            noPemesanan = Integer.parseInt(inputan.nextLine());

            String sql = "SELECT * FROM reservasi WHERE nopemesanan = " + noPemesanan;

            Statement statement = con.createStatement();
            ResultSet result = statement.executeQuery(sql);

            if (result.next()) {
                System.out.print("Nama Pelanggan [" + result.getString("namacustomer") + "]\t: ");
                namaCustomer = inputan.next();

                System.out.println("\n");

                sql = "UPDATE reservasi SET namacustomer='" + namaCustomer + "' WHERE nopemesanan='" + noPemesanan
                        + "' ";

                if (statement.executeUpdate(sql) > 0) {
                    System.out.println("Data Berhasil diperbarui!");
                }
            }
            statement.close();
        }

        catch (SQLException e) {
            System.err.println("Terjadi kesalahan Ubah data");
            System.err.println(e.getMessage());

        }

    }

    // =======================================================================================================================================================================================================================
    // pengolahan database
    public void hapusdata() throws SQLException, ClassNotFoundException {
        String text = "=====HAPUS DATA PEMBELIAN=====";
        System.out.println(text.toUpperCase());
        System.out.println("==============================");

        Scanner inputan = new Scanner(System.in);

        tampilkandata();

        // exception
        try {

            System.out.print("Ketik nomor pemesanan yang akan dihapus : ");
            noPemesanan = Integer.parseInt(inputan.nextLine());

            String sql = "DELETE FROM reservasi WHERE nopemesanan = " + noPemesanan;
            Statement statement = con.createStatement();

            if (statement.executeUpdate(sql) > 0) {
                System.out.println("Berhasil menghapus data dengan nomor pemesanan (" + noPemesanan + ")");
            }
        } catch (SQLException e) {
            System.out.println("Terjadi kesalahan dalam menghapus data barang");
            System.err.println(e.getMessage());
        }

    }

    // ==========================================================================================================================================================================================================================================================
    // pengolahan database
    public void caridata() throws SQLException, ClassNotFoundException {
        String text = "=====Cari Data PEMBELIAN=====";
        System.out.println(text.toUpperCase());
        System.out.println("=============================");

        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(url, username, password);

        Scanner inputan = new Scanner(System.in);

        System.out.print("Masukkan Nomor Pemesanan : ");

        String keyword = inputan.nextLine();
        Statement statement = con.createStatement();
        String sql = "SELECT * FROM reservasi WHERE nopemesanan LIKE '%" + keyword + "%'";
        ResultSet result = statement.executeQuery(sql);

        tanggal();

        // exception
        try {
            System.out.println(
                    "\n=====================================================================================================");
            String format1 = "|%-2s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|\n";
            System.out.printf(format1, "No", "Nama Customer", "Jenis Villa", "Harga Villa",
                    "Lama Menginap", "Total Harga", "Tanggal");
            System.out.println(
                    "\n=====================================================================================================");

            while (result.next()) {
                String format2 = "|%-2s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|\n";
                System.out.printf(format2, result.getInt("nopemesanan"), result.getString("namacustomer"),
                        result.getString("jenisvilla"), result.getInt("hargavilla"), result.getInt("lamamenginap"),
                        result.getInt("totalharga"), result.getDate("tanggaltransaksi"));
                System.out.println(
                        "\n-----------------------------------------------------------------------------------------------------");

            }
            System.out.println("Berhasil mencari data pemesanan");

        } catch (SQLException e) {
            System.out.println("Terjadi kesalahan dalam mencari data pemesanan");
            System.err.println(e.getMessage());
        }

    }

    // ===========================================================================================================================================================================================================================================================================================================================================================================================
    // pengolahan database
    public void resetdata() throws SQLException, ClassNotFoundException {
        String text = "=====RESET DATA PEMBELIAN=====";
        System.out.println(text.toUpperCase());
        System.out.println("==============================");

        tampilkandata();

        // exception
        try {

            String sql = "DELETE FROM reservasi";
            Statement statement = con.createStatement();

            if (statement.executeUpdate(sql) > 0) {
                System.out.println("Berhasil mereset data pemesanan");
            }
        } catch (SQLException e) {
            System.out.println("Terjadi kesalahan dalam mereset data pemesanan");
            System.err.println(e.getMessage());
        }

    }
}
