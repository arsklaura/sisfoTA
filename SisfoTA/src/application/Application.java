/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package application;
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
}
