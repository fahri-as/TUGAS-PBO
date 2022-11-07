public class Elemen {
    public String nama;

    public Elemen(String nama) {
        /*
         * merupakan DOWNCASTING,karena constructor subclassnya
         * merujuk kepada class Elemen superclassnya
         */
        this.nama = nama;
    }

}

class Dosen extends Elemen {// merupakan polymorphisme
    public int jamsbuk;
    private int jmlhharikerja;

    public Dosen(String nama, int jmlhharikerja) {
        super(nama);
        jamsbuk = jmlhharikerja * 8;

    }

    public void tes() {
        System.out.println(nama + " dosen dengan jam sibuk =" + " " + jamsbuk);
    }

    public int getJamSibuk() {
        return jamsbuk;
    }
}

class Mahasiswa extends Elemen {// merupakan polymorphism
    private int sks;
    public int jamsbuk;

    public Mahasiswa(String nama, int sks) {
        super(nama);
        jamsbuk = sks * 3;
    }

    public int getJamSibuk() {
        return jamsbuk;

    }

    public void tes() {
        System.out.println(nama + " adalah seorang Mahasiswa dengan jam sibuk = " + " " + jamsbuk);
    }

}

class Asdos extends Mahasiswa {// merupakan polymorphisme
    private int jamngeasdos;

    public Asdos(String nama, int sks, int jamngeasdos) {
        super(nama, sks);
        jamsbuk = jamsbuk + jamngeasdos;

    }

    public int getJamSibuk() {
        return jamsbuk;
    }

    public void tes() {
        /*
         * merupakan UPCASTING,karena melakukan
         * perubahan isi method yang ada pada superclassnya
         */
        System.out.println(nama + " Asdos dengan jam sibuk =" + " " + jamsbuk);
    }

}
