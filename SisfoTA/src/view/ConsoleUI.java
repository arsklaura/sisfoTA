/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import model.Application;
import java.util.Scanner;
import model.Dosen;
import control.FileIO;
import model.Mahasiswa;

/**
 *
 * @author agungrb
 */
public class ConsoleUI {
    
    private Application app;
    private FileIO io;
    
    private byte pil;
    private char yn;
    
    private String nama,topik,judulTA;
    private long nim, nip;
    private int nSKS, maxTopikTA, id, maxAnggota, noTopikTA, 
            noAnggota, noPembimbing, statusPembimbing;
    private boolean statusKP;
    private Dosen newDosen;
    
    private Mahasiswa mhs;
    private Dosen dsn;
    
    private Scanner scanString = new Scanner(System.in);
    private Scanner scanChar = new Scanner(System.in);
    private Scanner scanAngka = new Scanner(System.in);
    
    public ConsoleUI(Application app, FileIO io) {
        this.app = app;
        this.io = io;
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
    
    public void showMenu() {
        do{
            try{
                System.out.println("==MENU UTAMA==");
                System.out.println("1. Registrasi");
                System.out.println("2. Menu Dosen");
                System.out.println("3. Menu Mahasiswa");
                System.out.println("4. Menu Lihat Data");
                System.out.println("5. Menu File");
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
                        showMenuFile();
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
    
    private void showRegistrasi() {
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
                System.out.print("Status [1/2] : ");statusPembimbing = scanAngka.nextInt();
                System.out.print("Jumlah Kelompok TA : ");maxTopikTA = scanAngka.nextInt();
                app.addDosen(null, nama, nip, statusPembimbing, maxTopikTA);
                System.out.println("Registrasi BERHASIL, DSN-"+app.listDosen.size());
                pressAnyKeyToContinue();
                showRegistrasi();
                break;
            case 2 :
                System.out.println("==Registrasi Mahasiswa==");
                System.out.print("Nama  : ");nama = scanString.nextLine();
                System.out.print("NIM   : ");nim = scanAngka.nextLong();
                System.out.print("Jumlah SKS : ");nSKS = scanAngka.nextInt();
                System.out.print("Status KP [y/n] : ");yn = scanChar.next().charAt(0);
                if(yn == 'y') {
                    statusKP = true;
                }
                else {
                    statusKP = false;
                }
                app.addMahasiswa(null, nama, nim, nSKS, statusKP);
                System.out.println("Registrasi BERHASIL, MHS-"+app.listMahasiswa.size());
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
    
    private void showViewData() {
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
    
    private void showMenuDosen() {
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
                dsn.createKelompokTA(topik, maxAnggota);
                System.out.println("Berhasil, noKelompok-"+(dsn.getnTopikTA()-1));
                pressAnyKeyToContinue();
                showMenuDosen();
                break;
            case 2 :
                System.out.print("Nomor Kelompok : ");noTopikTA = scanAngka.nextInt();
                dsn.removeKelompokTA(noTopikTA);
                System.out.println("Berhasil, noKelompok-"+noTopikTA);
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
                System.out.print("Judul TA baru :");judulTA = scanString.nextLine();
                mhs = dsn.getTopikTA(noTopikTA).getAnggota(noAnggota);
                dsn.revisiJudulTA(noTopikTA, noAnggota, judulTA);
                System.out.println("Berhasil, judul TA "+mhs.nama+" telah diganti"); 
                pressAnyKeyToContinue();
                showMenuDosen();
                break;
            case 6 :
                System.out.print("Nomor Kelompok :");noTopikTA = scanAngka.nextInt();
                System.out.print("ID Dosen baru : ");id = scanAngka.nextInt();
                newDosen = app.getDosen(id);
                dsn.replacePembimbing(newDosen, noTopikTA);
                System.out.println("Berhasil, dipindah ke "+newDosen.nama);
                pressAnyKeyToContinue();
                showMenuDosen();
                break;
            case 7 :
                newDosen = null;
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
    
    private void showMenuMahasiswa() {
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
                System.out.print("No Pembimbing [1/2] : ");noPembimbing = scanAngka.nextInt();
                dsn = app.getDosen(id);
                if(mhs.getTugasAkhir().setPembimbing(dsn, noPembimbing)) {
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
    
    private void loginDosen() {
        System.out.print("ID Dosen : ");id = scanAngka.nextInt();
        dsn = app.getDosen(id);
        System.out.println("Selamat Datang, "+dsn.nama);
        pressAnyKeyToContinue();      
    }
    
    private void loginMahasiswa() {
        System.out.print("ID Mahasiswa : ");id = scanAngka.nextInt();
        mhs = app.getMahasiswa(id);
        System.out.println("Selamat Datang, "+mhs.nama);
        pressAnyKeyToContinue();
    }
    
    private void showMenuFile() {
        System.out.println("Menu File");
        System.out.println("1. Save file");
        System.out.println("2. Open file");
        System.out.print("Pilihan Anda  : ");
        pil = scanAngka.nextByte();
        switch(pil) {
            case 1 :
                System.out.print("Anda yakin? [y/n]: ");yn = scanChar.next().charAt(0);
                if(yn == 'y') {
                    io.saveFileDosen();
                    io.saveFileMahasiswa();
                    System.out.println("Berhasil");
                }
                pressAnyKeyToContinue();
                break;
            case 2:
                System.out.print("Anda yakin? [y/n]: ");yn = scanChar.next().charAt(0);
                if(yn == 'y') {
                    io.readFileDosen();
                    io.readFileMahasiswa();
                    System.out.println("Berhasil");  
                }
                pressAnyKeyToContinue();
                break;
            default :
                System.out.println("Pilihan salah");
                pressAnyKeyToContinue();
        }
    }
}