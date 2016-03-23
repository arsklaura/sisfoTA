/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisfota;
import java.util.ArrayList;
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;

/**
 *
 * @author agungrb
 */
public class Application {
    private ArrayList<Mahasiswa> listMahasiswa;
    private ArrayList<Dosen> listDosen;
    
    public Application() {
        listMahasiswa = new ArrayList();
        listDosen = new ArrayList();
    }
    
    public void addDosen(String nama, long nip, byte statusPembimbing,int maxTopikTA) {
        listDosen.add(new Dosen(nama, nip, statusPembimbing, maxTopikTA));
    }
    
    public void addMahasiswa(String nama, long nim, int nSKS, boolean statusKP) {
        listMahasiswa.add(new Mahasiswa(nama, nim, nSKS, statusKP));
    }
    
    public Dosen getDosen(int idDosen) {
        return listDosen.get(idDosen-1);
    }
    
    public Mahasiswa getMahasiswa(int idMahasiswa) {
        return listMahasiswa.get(idMahasiswa-1);
    }

    public void saveFileDosen() {
        try(FileOutputStream fout = new FileOutputStream("Dosen.txt")) {
            ObjectOutputStream oout = new ObjectOutputStream(fout);
            oout.writeObject(listDosen);
            oout.flush();
        }catch(Exception e) {
            
        }
    }
    
    public void readFileDosen() {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Dosen.txt"))) {
            listDosen = (ArrayList<Dosen>) ois.readObject();
            ois.close();
            
        }catch(Exception e) {
            
        }
    }
    
    public void saveFileMahasiswa() {
        try(FileOutputStream fout = new FileOutputStream("Mahasiswa.txt")) {
            ObjectOutputStream oout = new ObjectOutputStream(fout);
            oout.writeObject(listMahasiswa);
            oout.flush();
        }catch(Exception e) {
            
        }
    }
    
    public void readFileMahasiswa() {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Mahasiswa.txt"))) {
            listMahasiswa = (ArrayList<Mahasiswa>) ois.readObject();
            ois.close();
            
        }catch(Exception e) {
            
        }
    }
    
    public ArrayList getListMahasiswa() {
        return listMahasiswa;
    }
    
    public ArrayList getListDosen() {
        return listDosen;
    }
}
