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
    private boolean StatusKP;
    private long NIM;
    
    public Mahasiswa (String Nama, long NIM){
        this.NIM = NIM;
    }
    
    public void CreateTA(String judulTA){
        tugasAkhir = new TugasAkhir(judulTA);
    }
}
