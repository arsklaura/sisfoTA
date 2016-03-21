/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisfota;
import java.util.ArrayList;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author agungrb
 */
public class Application {
    ArrayList<Mahasiswa> listMahasiswa;
    ArrayList<Dosen> listDosen;
    
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
    
    public Dosen getDosen(int noDosen) {
        return listDosen.get(noDosen);
    }
    
    public Mahasiswa getMahasiswa(int noMahasiswa) {
        return listMahasiswa.get(noMahasiswa);
    }

    public void saveFileDosen() {
        try(FileOutputStream fout = new FileOutputStream("Dosen.txt")) {
            ObjectOutputStream oout = new ObjectOutputStream(fout);
            oout.writeObject(listDosen);
            oout.flush();
        }catch(IOException e) {
            
        }
    }
    
    public void readFileDosen() {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Dosen.txt"))) {
            listDosen = (ArrayList<Dosen>) ois.readObject();
            ois.close();
            
        }catch(IOException e) {
            
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
