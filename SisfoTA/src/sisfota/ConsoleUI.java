/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisfota;
import java.util.Scanner;

/**
 *
 * @author agungrb
 */
public class ConsoleUI {
    
    static Application app;
    private static byte pil;
    
    private static String nama;
    private static long nim, nip;
    private static byte statusPembimbing;
    private static int nSKS, maxTopikTA, id;
    private static boolean statusKP;
    
    static Scanner scanString = new Scanner(System.in);
    static Scanner scanAngka = new Scanner(System.in);
    static Scanner scanBoolean = new Scanner(System.in);
    
    public ConsoleUI(Application app) {
        this.app = app;
    }
    
    public static void showMenu() {
        do{ 
            System.out.println("MENU UTAMA");
            System.out.println("1. Registrasi");
            System.out.println("2. Menu Dosen");
            System.out.println("3. Menu Mahasiswa");
            System.out.println("4. Menu View Data");
            System.out.print("Pilihan Anda    : ");
            pil = scanAngka.nextByte();
            switch(pil) {
                case 1 :
                    showRegistrasi();
                    break;
                case 2 :
                case 3 :
                case 4 :
                    showViewData();
                    break;
                
                default :    
            }
        }while(pil != 0);   
    }
    private static void showRegistrasi() {
        System.out.println("Menu Registrasi");
        System.out.println("1. Registrasi Dosen");
        System.out.println("2. Registrasi Mahasiswa");
        System.out.println("3. Kembali");
        System.out.print("Pilihan Anda    : ");
        pil = scanAngka.nextByte();
        switch(pil) {
            case 1 : 
                System.out.println("Registrasi Dosen");
                System.out.print("Nama            : ");nama = scanString.nextLine();
                System.out.print("NIP             : ");nip = scanAngka.nextLong();
                System.out.print("Status          : ");statusPembimbing = scanAngka.nextByte();
                System.out.print("Topik Maksimum  : ");maxTopikTA = scanAngka.nextInt();
                app.addDosen(nama, nip, statusPembimbing, maxTopikTA);
                System.out.println("Registrasi BERHASIL, dsn-"+app.getnDosen());
                break;
            case 2 :
            case 3 : showMenu();
            default :
        }
    }
    
    private static void showViewData() {
        System.out.println("Menu Registrasi");
        System.out.println("1. Lihat Data Dosen");
        System.out.println("2. Lihat Data Mahasiswa");
        System.out.println("3. Kembali");
        System.out.print("Pilihan Anda    : ");
        pil = scanAngka.nextByte();
        switch(pil) {
            case 1 :
                System.out.print("ID Dosen    : ");id = scanAngka.nextInt();
                System.out.println(app.getDosen(id));
                break;
            case 2 :
                System.out.print("ID Mahasiswa    : ");id = scanAngka.nextInt();
                System.out.println(app.getMahasiswa(id));
                break;
            case 3 :
                showMenu();
                break;
            default :
        }
    }
}
