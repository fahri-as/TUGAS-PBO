import java.util.HashMap;

public class hashmap2 {
    public static void main(String[] args) {
        // membuat objek hashmap
        HashMap<Integer, String> days = new HashMap<Integer,String>();

        // mengisi value ke objek key
        days.put(1, "Minggu");
        days.put(2, "Senin");
	  days.put(3, "Selasa");
	  days.put(4, "Rabu");
	  days.put(5, "Kamis");
	  days.put(6, "Jumat");
	  days.put(7, "Sabtu");

        // mencetak semua isi dari objek days
        System.out.println("Isi objek days: " + days);
	
	  //mengambil hari senin
	  System.out.println("Hari kedua:" + days.get(2));
    }
}
