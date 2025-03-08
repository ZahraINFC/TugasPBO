import javax.xml.crypto.Data;
import java.sql.SQLOutput;
import java.util.Scanner;

public class UserInterface {
    public static void TampilkanMenu (){
        System.out.println();
        System.out.println("+===============+");
        System.out.println("|   Pilih Menu  |");
        System.out.println("+---------------+");
        System.out.println("+|   [C] Crate  |");
        System.out.println("+|   [R] Read   |");
        System.out.println("+|   [U] Update |");
        System.out.println("+|   [D] Delate |");
        System.out.println("+|   [X] Exit   |");
        System.out.println("+================+");
    }
    public static void main(String[] args) {
        DataBase db = new DataBase();
        System.out.println("APLIKASI SIMPLE CURD TEXT DATABASE");
        while(true){
            TampilkanMenu();
            Scanner iq = new Scanner(System.in);
            System.out.print("Piilih : ");
            String pilihan = iq.nextLine();
            pilihan =pilihan.toUpperCase();

            switch(pilihan){
                case "C":
                    System.out.println("INF0 : anda memilih menu CRATE");
                    System.out.println("------------------------------>");
                    System.out.println("INPUT DATA BARU ");
                    System.out.print("NIM                : ");
                    String nim = iq.nextLine();
                    System.out.print("NAMA MAHASISWA     : ");
                    String nama = iq.nextLine();
                    System.out.print("ALAMAT MAHASISWA   : ");
                    String alamat = iq.nextLine();
                    System.out.print("SEMESTER           : ");
                    int semester = iq.nextInt();
                    System.out.print("JUMLAH SKS         : ");
                    int sks = iq.nextInt();
                    System.out.print("NILAI IPK          : ");
                    double ipk = iq.nextDouble();
                    iq.nextLine();
                    System.out.println("------------------------------->");
                    boolean status = db.insert(nim, nama,  alamat, semester, sks, ipk);
                    if(status == true){
                        System.out.println("DATA BERHASIL DITAMBAH ");
                    }else{
                        System.out.println("NIM"+nim+" SUdah ada di DataBaase");
                        System.err.println("GAGAL MENAMBAHKAN DATA BARU");
                    }
                    System.out.println("------------------------------->");
                    break;
                case "R":
                    System.out.println("INFO : anda memilih menu read ");
                    db.view();
                    break;
                case "U":
                    System.out.println("INF0 : anda memilih menu UPDATE");
                    db.view();
                    System.out.print("INPUT key (NIM mahasiswa yang  akan diUpdate  ) : ");
                    String key = iq.nextLine();
                    int index = db.search(key);
                    if(index >= 0){
                        System.out.println("Anda akan meng-update data " + db.getData().get(index));
                        System.out.println("------------------------------>");
                        System.out.println("INPUT DATA BARU    : ");
                        System.out.print("NIM                : ");
                        nim = iq.nextLine();
                        System.out.print("NAMA MAHASISWA     :");
                        nama = iq.nextLine();
                        System.out.print("ALAMAT MAHASISWA   : ");
                        alamat = iq.nextLine();
                        System.out.print("SEMESTER           : ");
                        semester = iq.nextInt();
                        System.out.print("JUMLAH SKS         : ");
                        sks = iq.nextInt();
                        System.out.print("NILAI IPK          : ");
                        ipk = iq.nextDouble();
                        iq.nextLine();
                        System.out.println("------------------------------->");
                        status = db.update(index, nim, nama, alamat, semester, sks, ipk);
                        if (status == true){
                            System.out.println("DATA BERHASIL DI PERBABRUI");
                        }else{
                            System.err.println("DATA GAGAL DIPERBARUI");
                        }
                    }else{
                        System.err.println("Mahasiswa dengan nim" + key +" tIdak ada di database");
                    }
                    break;
                case "D":
                    System.out.println("INF0 : Anda memilih Menu DELATE");
                    db.view();
                    System.out.print("INPUT Key (NIM Mahasiswa yang akan dihapus) : ");
                    key = iq.nextLine();
                    index = db.search(key);
                    if (index >= 0 ){
                        System.out.println("Apakah anda yakin akan menghapus data Y/N" + db.getData().get(index));
                        System.out.print("Pilih : ");
                        pilihan = iq.nextLine();
                        if(pilihan.equalsIgnoreCase("Y")){
                            status = db.delate(index);
                            if(status == true){
                                System.out.println("DATA BERHASIL DOHAPUS");
                            }else{
                                System.err.println("DATA GAGAL DIHAPUS");
                            }
                        }
                    }
                    break;
                case "X":

                    System.out.println("INFO : Anda Memilih Menu EXIT");
                    System.out.println("Apakah anda yakin inngnin keluar dari aplikasi Y/N");
                    System.out.print("Pilih : ");
                    pilihan = iq.nextLine();
                    if(pilihan.equalsIgnoreCase("Y")){
                        System.exit(0);
                    }
                    break;
            }
        }
    }
}
