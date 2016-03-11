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
    private int nSKS;
    private boolean statusKP = false;
    private long nim;
    
    public Mahasiswa(long nim,int nSKS, boolean statusKP) {
        this.nim = nim;
        this.nSKS = nSKS;
        this.statusKP = statusKP;
    }
}