/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisfota;

/**
 *
 * @author SD
 */
public class Mahasiswa extends Orang {
    private TugasAkhir tugasAkhir;
    private int nSKS = 0;
    private boolean statusKP = false;
    private final long nim;
    private static int idMahasiswa;
    
    public Mahasiswa(String nama, long nim, int nSKS, boolean statusKP) {
        this.nama = nama;
        this.nim = nim;
        this.nSKS = nSKS;
        this.statusKP = statusKP;
        idMahasiswa++;
    }
    
    public void CreateTA(String judulTA){
        if(nSKS>=100 && statusKP) {
           tugasAkhir = new TugasAkhir(judulTA); 
        }
    }
    
    public TugasAkhir getTugasAkhir() {
        return tugasAkhir;
    }

    @Override
    public String toString() {
        return "Nama : "+nama+" NIM : "+nim;
    }
    
}