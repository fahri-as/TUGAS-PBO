package FahriAndika;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

//implementasi interface
public class Pelanggan implements Pemesanan {
    public Integer noPemesanan;
    public String namaCustomer;
    public String jenisvilla;
    public Integer hargavilla;
    public Integer lamaMenginap;
    public Integer totalHarga;

    Scanner input = new Scanner(System.in);

    // constructor
    public Pelanggan() {
        noPemesanan = 2111523006;
        namaCustomer = "Fahri Andika Sanjaya";
        jenisvilla = "Villa Merah";
        hargavilla = 3000000;
        lamaMenginap = 2;
    }

    // method date
    public void tanggal() {
        Date date = new Date();
        SimpleDateFormat tanggal = new SimpleDateFormat("EEEE, dd MMM yyyy");
        System.out.println("Tanggal Transaksi           = " + tanggal.format(date));
    }

    public void waktu() {
        Date time = new Date();
        SimpleDateFormat waktu = new SimpleDateFormat("HH:mm:ss");
        System.out.println("Waktu Transaksi             = " + waktu.format(time));
    }

    @Override
    public void noPemesanan() {
        System.out.print("Inputkan No Pemesanan         = ");
        noPemesanan = input.nextInt();
    }

    @Override
    public void namaCustomer() {
        System.out.print("Inputkan Nama Customer        = ");
        namaCustomer = input.next();
    }

    @Override
    public void jenisvilla() {
        System.out.print("Inputkan Jenis Kamar               = ");
        jenisvilla = input.next();
    }

    @Override
    public void hargavilla() {
        System.out.print("Inputkan Harga Kamar          = ");
        hargavilla = input.nextInt();

    }

    @Override
    public void lamaMenginap() {
        System.out.print("Inputkan Lama Menginap        = ");
        lamaMenginap = input.nextInt();
    }

    @Override
    public void totalHarga() {
        // proses matematika
        totalHarga = hargavilla * lamaMenginap;
        System.out.println("Total Harga                 = " + totalHarga);

    }

}
