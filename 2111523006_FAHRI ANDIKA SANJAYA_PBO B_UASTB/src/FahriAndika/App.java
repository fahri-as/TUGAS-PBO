package FahriAndika;

import java.util.Date;
import java.util.HashMap;
import java.util.Scanner;
import java.sql.*;

public class App {
    static Connection con;
    static Date date = new Date();

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        String pilihan;
        boolean perulangan = true;

        Transaksi transaksi = new Transaksi();

        String url = "jdbc:mysql://localhost:3306/sewavilla";
        String username = "root";
        String password = "";

        System.out.println("\n");
        Fahri mahasiswa = new Fahri();
        mahasiswa.display();
        System.out.println("\n");

        // EXCEPTION DAN KONEKSI KE DATABASE
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, username, password);
        }

        catch (ClassNotFoundException ex) {
            System.err.println("Driver Error");
            System.exit(0);
        }

        catch (SQLException e) {
            System.out.println("Koneksi Ke Database Gagal");
        }

        // =======================================================================================================================

        System.out.println("#-------------------------------------------#");
        System.out.println("|              SELAMAT DATANG DI            |");
        System.out.println("|                THE VILLA'S                |");
        System.out.println("#-------------------------------------------#");
        System.out.println("|        " + date + "       |");
        System.out.println("#===========================================#");

        // PERULANGAN
        do {
            System.out.println("#-------------------------------------------#");
            System.out.println("|     Silahkan Pilih Menu di bawah ini      |");
            System.out.println("#-------------------------------------------#");
            System.out.println("|  [1] Pemesanan Villa                      |");
            System.out.println("|  [2] Tampilkan Semua Data Pemesanan       |");
            System.out.println("|  [3] Cari Pemesanan                       |");
            System.out.println("|  [4] Ubah Pemesanan                       |");
            System.out.println("|  [5] Hapus Pemesanan                      |");
            System.out.println("|  [6] Reset Data Pemesanan                 |");
            System.out.println("|  [7] Keluar                               |");
            System.out.println("#-------------------------------------------#");

            System.out.print("Masukkan Pilihan Anda : ");
            pilihan = input.next();

            // PERCABANGAN
            switch (pilihan) {
                case "1":
                    // COLLECTION MENGGUNAKAN HASHMAP
                    HashMap<Integer, String> cul = new HashMap<Integer, String>();
                    cul.put(1000000, "Villa Biru");
                    cul.put(2000000, "Villa Putih");
                    cul.put(3000000, "Villa Merah");

                    System.out.println(
                            "==================================================================================================");
                    System.out.println("\nDaftar Pilihan Villa \t : " + cul.entrySet());
                    System.out.println("Banyak Villa Yang Dapat Dipesan : " + cul.size());
                    System.out.println(
                            "==================================================================================================");
                    System.out.println("\n");

                    transaksi.tambahData();

                    break;

                case "2":
                    transaksi.tampilkandata();
                    break;
                case "3":
                    transaksi.caridata();
                    break;
                case "4":
                    transaksi.ubahdata();
                    break;
                case "5":
                    transaksi.hapusdata();
                    break;
                case "6":
                    transaksi.resetdata();
                    break;
                case "7":
                    System.out.println("---------------------------------------------------------");
                    System.out.println("                 PROGRAM TELAH SELESAI                   ");
                    System.out.println("Terima Kasih Telah Mengunjungi Situs Pemesanan Villa Kami");
                    System.out.println("---------------------------------------------------------");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Maaf, Pilihan Tidak Tersedia!");
                    break;
            }

            System.out.print("\nLanjut Menggunakan Program[y/n]?");
            pilihan = input.next();
            perulangan = pilihan.equalsIgnoreCase("y");

        } while (perulangan);

        System.out.println("\n=========================================================");
        System.out.println("                   PROGRAM TELAH SELESAI                   ");
        System.out.println(" Terima Kasih Telah Mengunjungi Situs Pemesanan Villa Kami ");
        System.out.println("===========================================================");
    }

}
