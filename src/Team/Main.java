package Team;

import java.util.Scanner;

public class Main {
    private static DoubleLinkedList list = new DoubleLinkedList();
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        list.insertFirst(new Mahasiswa("DanyChristian", Long.parseLong("20520241019"), "L"));
        list.insertFirst(new Mahasiswa("Muhammad Rizqi", Long.parseLong("20520241021"), "L"));
        list.insertLast(new Mahasiswa("Pulih Eka Legyana", Long.parseLong("20520241013"), "P"));
        boolean exit = false;
        while(!exit){
            menu();
            System.out.print("Menu yang dipilih : ");
            int menu = sc.nextInt();
            switch (menu) {
                case 1:
                    System.out.println("<---   M A S U K K A N   D A T A   --->");
                    System.out.println("---------------------------------------");
                    break;

                case 2:
                    System.out.println("<---  T A M P I L K A N   D A T A  --->");
                    System.out.println("---------------------------------------");
                    System.out.println("Opsi : ");
                    System.out.println("1. | Tampilkan Maju (first) --> (last)");
                    System.out.println("2. | Tampilkan Mundur (last) --> (first)");
                    System.out.print("Pilihan Anda ? ");
                    int opsi = sc.nextInt();
                    switch (opsi) {
                        case 1:
                            System.out.println("\n<--     M A J U     -->");
                            list.showForward();
                            break;

                        case 2:
                            System.out.println("<--   M U N D U R   -->");
                            list.showBackward();
                            break;
                    
                        default:
                            break;
                    }
                    break;

                case 3:
                    System.out.println("<---       U B A H   D A T A       --->");
                    System.out.println("---------------------------------------");
                    break;

                case 4:
                    System.out.println("<---      H A P U S   D A T A      --->");
                    System.out.println("---------------------------------------");
                    break;

                case 5:
                    System.out.println("<---       C A R I   D A T A       --->");
                    System.out.println("---------------------------------------");
                    break;

                case 6:
                    System.out.println("<---    T E R I M A   K A S I H    --->");
                    System.out.println("---------------------------------------");
                    exit = true;
                    break;
            
                default:
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

}
