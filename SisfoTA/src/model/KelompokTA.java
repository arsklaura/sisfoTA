/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.io.Serializable;

/**
 *
 * @author agungrb
 */
public class KelompokTA implements Serializable {
    private String topik;
    private Mahasiswa[] anggota;
    private final int maxAnggota;
    private int nAnggota;
    
    public KelompokTA(String topik, int maxAnggota) {
        this.maxAnggota = maxAnggota;
        this.topik = topik;
        anggota = new Mahasiswa[maxAnggota];
    }
    
    public boolean addAnggota(Mahasiswa m) {
        if(m.getTugasAkhir() != null) {
            anggota[nAnggota] = m;
            nAnggota++; 
            return true;
        }  
        else {
            return false;
        }  
    }
    public boolean removeAnggota(int noAnggota) {
        if(anggota[noAnggota] != null) {
            anggota[noAnggota] = null;
            return true;
        }
        else {
            return false;
        }
    }
    public Mahasiswa getAnggota(int noAnggota) {
        return anggota[noAnggota];
    }
    public int getnAnggota() {
        return nAnggota;
    }

    public String getTopik() {
        return topik;
    }
    
    
}
