package FahriAndika;

public class Fahri {
    public String PBO;
    public String mahasiswa;
    public String NIM;
    public String jurusan;
    public String fakultas;

    public Fahri() {
        PBO = "====================TUGAS BESAR PBO====================";
        mahasiswa = "FAHRI ANDIKA SANJAYA";
        NIM = "2111523006";
        jurusan = "Sistem Informasi";
        fakultas = "Fakultas Teknologi Informasi";
    }

    public void display() {
        System.out.println(PBO);
        System.out.println("Nama Mahasiswa      = " + mahasiswa);
        System.out.println("NIM Mahasiswa       = " + NIM);
        System.out.println("Jurusan Mahasiswa   = " + jurusan);
        System.out.println("Fakultas Mahasiswa  = " + fakultas);
    }
}
