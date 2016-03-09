/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisfota;

/**
 *
 * @author ZULFA UMI WARDANI
 */
public class Dosen {
    private KelompokTA[] topikTA= new KelompokTA[5];
    private byte statusPembimbing;
    private String jabatan;
    private int nTopikTA;
    private int maxTopikTA;
    private long NIP;
    
    public Dosen(){};
    public void createKelompkTA(int i){
        for ( i=0; i<=5; i++) {
            kelompokTA[i]= getAnggota();
        }
    }
    public void revisiJudulTA (){
        System.out.println("Judul direvisi ");
    };
    public removeKelompokTA (){
        anggota[i]= null;
        System.out.println(" Kelompok telah dihapus ");
    }
}
  
    
    
}
