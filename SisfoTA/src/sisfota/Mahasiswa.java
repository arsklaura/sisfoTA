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
public class Mahasiswa extends Orang {
    private TugasAkhir tugasAkhir;
    private int nSKS;
    private boolean statusKP;
    private long nim;
    
    public Mahasiswa (String Nama, long nim){
        this.nim = nim;
    }
    
    public void CreateTA(String judulTA){
        if(nSKS>=100 && statusKP==true) {
           tugasAkhir = new TugasAkhir(judulTA); 
        }
    }
}
