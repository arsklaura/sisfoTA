/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisfota;

/**
 *
 * @author agungrb
 */
public class Application {
    Mahasiswa[] listMahasiswa;
    Dosen[] listDosen;
    
    private int nDosen = 0;
    private int nMahasiswa = 0;
    
    public Application() {
        listMahasiswa = new Mahasiswa[10];
        listDosen = new Dosen[10];
    }
    
    public void addDosen(String nama, long nip, byte statusPembimbing,int maxTopikTA) {
        listDosen[nDosen] = new Dosen(nama, nip, statusPembimbing, maxTopikTA);
        nDosen++;
    }
    
    public void addMahasiswa(String nama, long nim, int nSKS, boolean statusKP) {
        listMahasiswa[nMahasiswa] = new Mahasiswa(nama, nim, nSKS, statusKP);
        nMahasiswa++;
    }
    
    public Dosen getDosen(int noDosen) {
        return listDosen[noDosen];
    }
    
    public Mahasiswa getMahasiswa(int noMahasiswa) {
        return listMahasiswa[noMahasiswa];
    }

    public int getnDosen() {
        return nDosen;
    }

    public int getnMahasiswa() {
        return nMahasiswa;
    }

}
