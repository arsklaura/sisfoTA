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
    
    private static Application app;
    private static byte pil;
    
    private static String nama,topik,judulTA;
    private static long nim, nip;
    private static byte statusPembimbing;
    private static int nSKS, maxTopikTA, id, maxAnggota, noTopikTA, noAnggota, noPembimbing;
    private static boolean statusKP;
    private static Dosen newDosen;
    
    private static Mahasiswa mhs;
    private static Dosen dsn;
    
    private static Scanner scanString = new Scanner(System.in);
    private static Scanner scanAngka = new Scanner(System.in);
    private static Scanner scanBoolean = new Scanner(System.in);
    
    public ConsoleUI(Application app) {
        this.app = app;
    }
    
    private static void pressAnyKeyToContinue() { 
        System.out.println("Press any key to continue...");
        try
        {
            System.in.read();
        }  
        catch(Exception e)
        {}  
    }
    
    public static void showMenu() {
        do{
            try{
                System.out.println("==MENU UTAMA==");
                System.out.println("1. Registrasi");
                System.out.println("2. Menu Dosen");
                System.out.println("3. Menu Mahasiswa");
                System.out.println("4. Menu Lihat Data");
                System.out.println("5. Simpan Data");
                System.out.println("6. Buka Data");
                System.out.println("0. Keluar");
                System.out.print("Pilihan Anda  : ");
                pil = scanAngka.nextByte();
                switch(pil) {
                    case 0 : break;
                    case 1 :
                        showRegistrasi();
                        break;
                    case 2 :
                        loginDosen();
                        showMenuDosen();
                        break;
                    case 3 :
                        loginMahasiswa();
                        showMenuMahasiswa();
                        break;
                    case 4 :
                        showViewData();
                        break;
                    case 5 :
                        app.saveFileDosen();
                        app.saveFileMahasiswa();
                        System.out.println("Data telah disimpan");
                        pressAnyKeyToContinue();
                        break;
                    case 6 :
                        app.readFileDosen();
                        app.readFileMahasiswa();
                        System.out.println("Data telah dibuka");
                        pressAnyKeyToContinue();
                        break;
                    default :  
                        System.out.println("Pilihan salah");
                        pressAnyKeyToContinue();
                } 
            }catch(Exception e) {
                System.out.println("Ada Error");
                pressAnyKeyToContinue();
            }
        }while(pil != 0);  
    }
    
    private static void showRegistrasi() {
        System.out.println("==Menu Registrasi==");
        System.out.println("1. Registrasi Dosen");
        System.out.println("2. Registrasi Mahasiswa");
        System.out.println("3. Kembali");
        System.out.print("Pilihan Anda  : ");
        pil = scanAngka.nextByte();
        switch(pil) {
            case 1 : 
                System.out.println("==Registrasi Dosen==");
                System.out.print("Nama  : ");nama = scanString.nextLine();
                System.out.print("NIP   : ");nip = scanAngka.nextLong();
                System.out.print("Status [1/2] : ");statusPembimbing = scanAngka.nextByte();
                System.out.print("Jumlah Kelompok TA : ");maxTopikTA = scanAngka.nextInt();
                app.addDosen(nama, nip, statusPembimbing, maxTopikTA);
                System.out.println("Registrasi BERHASIL, DSN-"+app.getListDosen().size());
                pressAnyKeyToContinue();
                showRegistrasi();
                break;
            case 2 :
                System.out.println("==Registrasi Mahasiswa==");
                System.out.print("Nama  : ");nama = scanString.nextLine();
                System.out.print("NIM   : ");nim = scanAngka.nextLong();
                System.out.print("Jumlah SKS : ");nSKS = scanAngka.nextInt();
                System.out.print("Status KP [true/false] : ");statusKP = scanBoolean.nextBoolean();
                app.addMahasiswa(nama, nim, nSKS, statusKP);
                System.out.println("Registrasi BERHASIL, MHS-"+app.getListMahasiswa().size());
                pressAnyKeyToContinue();
                showRegistrasi();
                break;
            case 3 : break;
            default :
                System.out.println("Pilihan salah");
                pressAnyKeyToContinue();
                showRegistrasi();
        }
    }
    
    private static void showViewData() {
        System.out.println("==Menu Lihat Data==");
        System.out.println("1. Lihat Data Dosen");
        System.out.println("2. Lihat Data Mahasiswa");
        System.out.println("3. Kembali");
        System.out.print("Pilihan Anda  : ");
        pil = scanAngka.nextByte();
        switch(pil) {
            case 1 :
                System.out.print("ID Dosen  : ");id = scanAngka.nextInt();
                System.out.println(app.getDosen(id));
                pressAnyKeyToContinue();
                showViewData();
                break;
            case 2 :
                System.out.print("ID Mahasiswa  : ");id = scanAngka.nextInt();
                System.out.println(app.getMahasiswa(id));
                pressAnyKeyToContinue();
                showViewData();
                break;
            case 3 : break;
            default :
                System.out.println("Pilihan salah");
                pressAnyKeyToContinue();
                showViewData();
        }
    }
    
    private static void showMenuDosen() {
        System.out.println("==Menu Dosen==");
        System.out.println("1. Buat Kelompok TA");
        System.out.println("2. Hapus Kelompok TA");
        System.out.println("3. Tambah Anggota");
        System.out.println("4. Hapus Anggota");
        System.out.println("5. Revisi Judul TA");
        System.out.println("6. Ganti Pembimbing");
        System.out.println("7. Kembali");
        System.out.print("Pilihan Anda  : ");
        pil = scanAngka.nextByte();
        switch(pil) {
            case 1 :
                System.out.print("Judul Topik : ");topik = scanString.nextLine();
                System.out.print("Jumlah Anggota : ");maxAnggota = scanAngka.nextInt();
                if(dsn.createKelompokTA(topik, maxAnggota)) {
                    System.out.println("Berhasil, noKelompok-"+(dsn.getnTopikTA()-1));
                }
                else {
                    System.out.println("Gagal");
                }
                pressAnyKeyToContinue();
                showMenuDosen();
                break;
            case 2 :
                System.out.print("Nomor Kelompok : ");noTopikTA = scanAngka.nextInt();
                if(dsn.removeKelompokTA(noTopikTA)) {
                    System.out.println("Berhasil, noKelompok-"+noTopikTA);
                }
                else {
                    System.out.println("Gagal");
                }
                pressAnyKeyToContinue();
                showMenuDosen();
                break;
            case 3 :
                System.out.print("Nomor Kelompok : ");noTopikTA = scanAngka.nextInt();
                System.out.print("ID Mahasiswa : ");id = scanAngka.nextInt();
                mhs = app.getMahasiswa(id);
                if(dsn.getTopikTA(noTopikTA).addAnggota(mhs)) {
                   System.out.println("Berhasil, noAnggota-"+(dsn.getTopikTA(noTopikTA).getnAnggota()-1)); 
                }
                else {
                    System.out.println("Gagal");
                }
                pressAnyKeyToContinue();
                showMenuDosen();
                break;
            case 4 :
                System.out.print("Nomor Kelompok : ");noTopikTA = scanAngka.nextInt();
                System.out.print("Nomor Anggota : ");noAnggota = scanAngka.nextInt();
                if(dsn.getTopikTA(noTopikTA).removeAnggota(noAnggota)) {
                    System.out.println("Berhasil, noAnggota-"+dsn.getTopikTA(noTopikTA).getnAnggota());
                }
                else {
                    System.out.println("Gagal");
                }
                pressAnyKeyToContinue();
                showMenuDosen();
                break;
            case 5 :
                System.out.print("Nomor Kelompok : ");noTopikTA = scanAngka.nextInt();
                System.out.print("Nomor Anggota : ");noAnggota = scanAngka.nextInt();
                System.out.print("Judul TA :");judulTA = scanString.nextLine();
                mhs = app.getMahasiswa(id);
                if(dsn.revisiJudulTA(noTopikTA, noAnggota, judulTA)) {
                   System.out.println("Berhasil, judul TA "+mhs.nama+" telah diganti"); 
                }
                else {
                    System.out.println("Gagal");
                }
                pressAnyKeyToContinue();
                showMenuDosen();
                break;
            case 6 :
                System.out.println("Nomor Kelompok :");noTopikTA = scanAngka.nextInt();
                System.out.println("ID Dosen baru : ");id = scanAngka.nextInt();
                newDosen = app.getDosen(id);
                if(dsn.replacePembimbing(newDosen, noTopikTA)) {
                    System.out.println("Berhasil");
                }
                else {
                    System.out.println("Gagal");
                }
                pressAnyKeyToContinue();
                showMenuDosen();
                break;
            case 7 :
                mhs = null;
                dsn = null;
                showMenu();
                break;
            default :
                System.out.println("Pilihan salah");
                pressAnyKeyToContinue();
                showMenuDosen();
        }
    }
    
    private static void showMenuMahasiswa() {
        System.out.println("==Menu Mahasiswa==");
        System.out.println("1. Buat Tugas Akhir");
        System.out.println("2. Daftar Tugas Akhir");
        System.out.println("3. Kembali");
        System.out.print("Pilihan Anda  : ");
        pil = scanAngka.nextByte();
        switch(pil) {
            case 1 :
                System.out.print("Judul tugas akhir : ");judulTA = scanString.nextLine();
                if(mhs.createTA(judulTA)) {
                    System.out.println("Berhasil");
                }
                else {
                    System.out.println("Gagal");
                }
                pressAnyKeyToContinue();
                showMenuMahasiswa();
                break;
            case 2 :
                System.out.print("ID Dosen : ");id = scanAngka.nextInt();
                System.out.print("No Pembimbing [0/1/2] : ");noPembimbing = scanAngka.nextInt();
                dsn = app.getDosen(id);
                if(mhs.getTugasAkhir().SetPembimbing(dsn, noPembimbing)) {
                    System.out.println("Berhasil");
                }
                else {
                    System.out.println("Gagal");
                }
                pressAnyKeyToContinue();
                showMenuMahasiswa();
                break;
            case 3 :
                mhs = null;
                dsn = null;
                showMenu();
                break;
        }
    }
    
    private static void loginDosen() {
        System.out.print("ID Dosen : ");id = scanAngka.nextInt();
        dsn = app.getDosen(id);
        System.out.println("Selamat Datang, "+dsn.nama);
        pressAnyKeyToContinue();      
    }
    
    private static void loginMahasiswa() {
        System.out.print("ID Mahasiswa : ");id = scanAngka.nextInt();
        mhs = app.getMahasiswa(id);
        System.out.println("Selamat Datang, "+mhs.nama);
        pressAnyKeyToContinue();
    }
}
