/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.Application;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author agungrb
 */
public class FileIO {
    Application app;
    public FileIO(Application app) {
        this.app = app;
    }
    
    public void readFileDosen() {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Dosen.txt"))) {
            app.listDosen = (ArrayList<Dosen>) ois.readObject();
            ois.close();
            
        }catch(Exception e) {
            
        }
    }
    
    public void saveFileMahasiswa() {
        try(FileOutputStream fout = new FileOutputStream("Mahasiswa.txt")) {
            ObjectOutputStream oout = new ObjectOutputStream(fout);
            oout.writeObject(app.listMahasiswa);
            oout.flush();
        }catch(Exception e) {
            
        }
    }
    
    public void readFileMahasiswa() {
        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("Mahasiswa.txt"))) {
            app.listMahasiswa = (ArrayList<Mahasiswa>) ois.readObject();
            ois.close();
            
        }catch(Exception e) {
            
        }
    }
    
    public void saveFileDosen() {
        try(FileOutputStream fout = new FileOutputStream("Dosen.txt")) {
            ObjectOutputStream oout = new ObjectOutputStream(fout);
            oout.writeObject(app.listDosen);
            oout.flush();
        }catch(Exception e) {
            
        }
    }
}
