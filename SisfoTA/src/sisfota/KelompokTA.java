/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisfota;
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
    
    public void addAnggota(Mahasiswa m) {
        if(nAnggota <= maxAnggota) {
            anggota[nAnggota] = m;
            nAnggota++;  
        }  
    }
    public void removeAnggota(Mahasiswa m) {
        for(int i=0;i<=anggota.length;i++) {
            if(anggota[i] == m) {
                anggota[i] = null;
            }
        }
    }
    public Mahasiswa getAnggota(int noAnggota) {
        return anggota[noAnggota];
    }
    public int getnAnggota() {
        return nAnggota;
    }
}
