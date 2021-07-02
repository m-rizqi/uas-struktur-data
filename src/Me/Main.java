package Me;
import java.util.Scanner;

public class Main {
    private static DoubleLinkedList list = new DoubleLinkedList();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        insertData(new Mahasiswa("a", 1, "P"));
        insertData(new Mahasiswa("b", 3, "L"));
        insertData(new Mahasiswa("c", 2, "L"));
        insertData(new Mahasiswa("d", 7, "P"));
        insertData(new Mahasiswa("e", 4, "L"));
        boolean exit = false;
        while (!exit) {
            menu();
            System.out.print("Menu yang dipilih : ");
            int menu = sc.nextInt();
            System.out.println();
            switch (menu) {
                case 1:
                    System.out.println("<--   I N S E R T   D A T A   -->");
                    System.out.println("---------------------------------");
                    System.out.println("Berapa data yang ingin dimasukkan ? ");
                    int datas = sc.nextInt();
                    for (int i = 0; i < datas; i++) {
                        System.out.println("\nMahasiswa " + (i + 1));
                        System.out.println("-----------------------");
                        System.out.print("Nama : ");
                        String name = sc.next();
                        name += " " + sc.nextLine();
                        System.out.print("NIM : ");
                        int nim = getAndValidateNim();
                        System.out.print("Gender(L/P) : ");
                        String in = sc.next();
                        while (!in.equalsIgnoreCase("L") && !in.equalsIgnoreCase("P")) {
                            System.err.println("Please, just type L or P");
                            in = sc.next();
                        }
                        String gender = in.equalsIgnoreCase("L") ? "L" : "P";
                        insertData(new Mahasiswa(name, nim, gender));
                    }
                    System.out.println();
                    break;

                case 2:
                    System.out.println("<--     S H O W   D A T A     -->");
                    System.out.println("---------------------------------");
                    System.out.println("Choice : ");
                    System.out.println("1. | Show Forward, or ");
                    System.out.println("2. | Show Backward, or ");
                    int choose = sc.nextInt();
                    switch (choose) {
                        case 1:
                            System.out.println("<--     F O R W A R D     -->");
                            list.showForward();
                            break;

                        case 2:
                            System.out.println("<--     B A C K W A R D     -->");
                            list.showBackward();
                            break;

                        default:
                            break;
                    }
                    break;

                case 3:
                    System.out.println("<--   U P D A T E   D A T A   -->");
                    System.out.println("---------------------------------");
                    list.showForward();
                    System.out.println("Masukkan NIM mahasiswa yang ingin diubah, ");
                    int NIM = sc.nextInt();
                    Node node = list.delete(NIM);
                    if (node != null) {
                        Mahasiswa mahasiswa = node.getMahasiswa();
                        System.out.println("Mahasiswa : ");
                        System.out.println("------------------------");
                        System.out.println("Nama : " + mahasiswa.getName());
                        System.out.println("NIM : " + mahasiswa.getNim());
                        System.out.println("Nama : " + mahasiswa.getGender());
                        boolean done = false;
                        while (!done) {
                            System.out.println("Pilihan ubah : ");
                            System.out.println("1. | Ubah Nama");
                            System.out.println("2. | Ubah NIM");
                            System.out.println("3. | Ubah Gender");
                            System.out.println("4. | Selesai");
                            int choice = sc.nextInt();
                            switch (choice) {
                                case 1:
                                    System.out.println("Nama Baru : ");
                                    String name = sc.next();
                                    name += " " + sc.nextLine();
                                    mahasiswa.setName(name);
                                    break;
                                case 2:
                                    System.out.println("NIM Baru : ");
                                    int nim = getAndValidateNim();
                                    mahasiswa.setNim(nim);
                                    ;
                                    break;
                                case 3:
                                    System.out.println("Gender Baru : ");
                                    String in = sc.next();
                                    while (!in.equalsIgnoreCase("L") && !in.equalsIgnoreCase("P")) {
                                        System.err.println("Please, just type L or P");
                                        in = sc.next();
                                    }
                                    String gender = in.equalsIgnoreCase("L") ? "L" : "P";
                                    mahasiswa.setGender(gender);
                                    ;
                                    break;
                                case 4:
                                    done = true;
                                    break;

                                default:
                                    break;
                            }
                        }
                        insertData(mahasiswa);
                    } else {
                        System.err.println("Data tidak ditemukan!");
                        System.out.println("Masukkan NIM dengan benar");
                    }
                    break;

                case 6:
                    exit = true;
                    break;
            }
        }
    }

    private static void menu() {
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

    private static void insertData(Mahasiswa mahasiswa) {
        Node first = list.getFirst();
        Node last = list.getLast();
        if (first == null) {
            list.insertFirst(mahasiswa);
        } else {
            String gender = mahasiswa.getGender();
            switch (gender) {
                case "L":
                    Mahasiswa firstMahs = first.getMahasiswa();
                    if (firstMahs.getGender().equals("P")) {
                        list.insertFirst(mahasiswa);
                    } else {
                        while (first.getMahasiswa().getGender().equals("L") && first!= null) {
                            if (mahasiswa.getNim() < first.getMahasiswa().getNim()) {
                                list.insertBefore(first.getMahasiswa(), mahasiswa);
                                break;
                            }
                            first = first.getNext();
                        }
                        if (first.getMahasiswa().getGender().equals("P")) {
                            list.insertBefore(first.getMahasiswa(), mahasiswa);
                        }
                    }
                    break;
                case "P":
                    Mahasiswa lastMahs = last.getMahasiswa();
                    if (lastMahs.getGender().equals("L")) {
                        list.insertLast(mahasiswa);
                    } else {
                        while (last.getMahasiswa().getGender().equals("P") && last != null) {
                            if (mahasiswa.getNim() > last.getMahasiswa().getNim()) {
                                list.insertAfter(last.getMahasiswa(), mahasiswa);
                                break;
                            }
                            last = last.getPrevious();
                        }
                    }
                    break;
                default:
                    break;
            }
        }
    }

    private static int getAndValidateNim() {
        boolean valid = false;
        int nim = 0;
        while (!valid) {
            String in = sc.next();
            try {
                nim = Integer.parseInt(in);
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
