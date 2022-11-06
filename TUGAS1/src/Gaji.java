public class Gaji extends Pegawai {/*extend merupakan salah satu syarat 
    melakukan pewarisan(POLYMORPHISME) dari superclass ke subclass*/

    private double salary;

    public Gaji(String name, String address, int number, double salary) {
        super(name, address, number);
        setSalary(salary);
    }

    public void mailCheck() {
        /*method mailcheck() adalah method yang dimiliki oleh subclass yaitu class pegawai,dimana terjadi
        overriding karna memiliki nama yang sama dengan method yg ada pada superclass,karna method pada subclass
        ini mengubah isinya dengan atau referensinya yg mana bukan lagi bereferensi pada superclass.Maka ini dinamakan
        UPCASTING
         */
        System.out.println("Memeriksa Kelas Gaji dalam Surat ");
        System.out.println("Surat Tertuju Untuk " + getName() + "dengan gaji " + salary);
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double newSalary) {
        if (newSalary >= 0.0) {
            salary = newSalary;
        }
    }

    public double computerPay() {
        System.out.println("Menghitung Pembayaran Gaji Untuk " + getName());
        return salary / 52;
    }

}
