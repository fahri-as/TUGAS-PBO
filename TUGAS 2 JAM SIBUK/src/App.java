public class App {
    public static void main(String[] args) {
        Asdos a = new Asdos("fairuzikun", 23, 4);
        Dosen b = new Dosen("Raja OP damanik", 5);
        Asdos c = new Asdos("Angel-chan", 20, 4);
        Mahasiswa d = new Mahasiswa("Firman", 20);
        Mahasiswa e = new Mahasiswa("Nid to Pass this sem", 23);
        Dosen f = new Dosen("Nivotko", 3);
        
        
        a.tes();
        b.tes();
        c.tes();
        d.tes();
        e.tes();
        f.tes();
        int totalJamSibuk = a.getJamSibuk() + b.getJamSibuk() + c.getJamSibuk() + d.getJamSibuk() + e.getJamSibuk() + f.getJamSibuk();
        System.out.println("Total jam sibuk elemen fasilkom adalah " + totalJamSibuk);
    }
}
