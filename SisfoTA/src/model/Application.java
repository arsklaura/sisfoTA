/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.util.ArrayList;
import model.Dosen;
import model.Mahasiswa;

/**
 *
 * @author agungrb
 */
public class Application {
    public ArrayList<Mahasiswa> listMahasiswa;
    public ArrayList<Dosen> listDosen;
    
    public Application() {
        listMahasiswa = new ArrayList();
        listDosen = new ArrayList();
    }
    
    public void addDosen(String password, String nama, long nip, int statusPembimbing,int maxTopikTA) {
        listDosen.add(new Dosen(password, nama, nip, statusPembimbing, maxTopikTA));
    }
    
    public void addMahasiswa(String password, String nama, long nim, int nSKS, boolean statusKP) {
        listMahasiswa.add(new Mahasiswa(password, nama, nim, nSKS, statusKP));
    }
    
    public Dosen getDosen(int idDosen) {
        return listDosen.get(idDosen-1);
    }
    
    public Mahasiswa getMahasiswa(int idMahasiswa) {
        return listMahasiswa.get(idMahasiswa-1);
    }
}
