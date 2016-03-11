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
public class KelompokTA {
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
            if(anggota[i] == m) {                       //Mahasiswa ditemukan
                anggota[i] = null;
            }
        }
    }
    public void replacePembimbing(Dosen d){
        
    }
}
