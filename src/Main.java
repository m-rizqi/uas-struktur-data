import java.util.Scanner;

public class Main {
    private static DoubleLinkedList list = new DoubleLinkedList();
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        boolean exit = false;
        while (!exit) {
            menu();
            System.out.print("Menu yang dipilih : ");
            int menu = sc.nextInt();
            System.out.println();
            switch(menu){
                case 1:
                    System.out.println("<--   I N S E R T   D A T A   -->");
                    System.out.println("---------------------------------");
                    System.out.println("Ingin memasukkan berapa data sekaligus ?");
                    int datas = sc.nextInt();
                    Mahasiswa[] mahasiswas = new Mahasiswa[datas];
                    for (int i = 0; i < datas; i++) {
                        System.out.println("\nMahasiswa "+(i+1));
                        System.out.println("-----------------------");
                        System.out.print("Nama : ");
                        String name = sc.next();
                        name += " "+sc.nextLine();
                        System.out.print("NIM : ");
                        int nim = getAndValidateNim();
                        System.out.print("Gender(L/P) : ");
                        String in = sc.next();
                        while(!in.equalsIgnoreCase("L") && !in.equalsIgnoreCase("P")){
                            System.err.println("Please, just type L or P");
                            in = sc.next();
                        }
                        Gender gender = null;
                        if(in.equalsIgnoreCase("L")){
                            gender = Gender.L;
                        }else{
                            gender = Gender.P;
                        }
                        mahasiswas[i] = new Mahasiswa(name, nim, gender);
                    }
                    break;
                case 6:
                    exit = false;
                    break;
            }
        }
    }
    private static void menu(){
        System.out.println("------------------------------------");
        System.out.println("|              M E N U             |");
        System.out.println("------------------------------------");
        System.out.println("|1.| Memasukkan Data Mahasiswa     |");
        System.out.println("|2.| Menampilkan Semua Mahasiswa   |");
        System.out.println("|3.| Mengubah Data Mahasiswa       |");
        System.out.println("|4.| Menghapus Data Mahasiswa      |");
        System.out.println("|5.| Mencari Data Mahasiswa        |");
        System.out.println("|6.| Keluar                        |");
        System.out.println("------------------------------------");
        System.out.println();
    }
    private static void insertDatas(Mahasiswa[] mahasiswas){
        for (Mahasiswa mahasiswa : mahasiswas) {
            Node index = list.getFirst();
            if (mahasiswa.getGender().equals(Gender.L) && mahasiswa.getNim()< index.getMahasiswa().getNim()) {
                list.insertFirst(mahasiswa);
            }
            else if(mahasiswa.getGender().equals(Gender.P) && mahasiswa.getNim()> list.getLast().getMahasiswa().getNim()){
                list.insertLast(mahasiswa);
            }
            else{
                while (index != null) {
                    if(mahasiswa.getNim() > index.getMahasiswa().getNim()){
                        list.insertAfter(index.getMahasiswa(), mahasiswa);
                        break;
                    }
                    index = index.getNext();
                }
            }
        }
    }
    private static int getAndValidateNim(){
        boolean valid = false;
        int nim = 0;
        while (!valid) {
            try {
                nim = sc.nextInt();
                valid = true;
            } catch (Exception e) {
                System.err.println("Please, type only number");
            }
            if (valid) {
                Node index = list.getFirst();
                while (index != null) {
                    if (index.getMahasiswa().getNim() == nim) {
                        valid = false;
                        System.err.println("Sorry, that NIM already exists!");
                        System.err.println("Type another NIM");
                        break;
                    }
                    index = index.getNext();
                }
            }
        }
        return nim;
    }
}
