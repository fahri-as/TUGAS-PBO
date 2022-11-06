public class Main {
    public static void main(String[] args) {
        Gaji s = new Gaji("Wahyu ", "KUBAR ", 3, 5000.00);
        Pegawai e = new Gaji("Ini Nama ", "Samarinda ", 2, 2500.00);
        System.out.println("Memanggil mailCheck Berdasarkan Referensi Gaji --");
        s.mailCheck();
        System.out.println("");
        System.out.println("Memanggil mailCheck Berdasarkan Referensi Pegawai--");
        e.mailCheck();

        

        
    }
}
