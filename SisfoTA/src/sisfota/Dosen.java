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
    private String tempJudul;
    private String setJudulTA;
    private int i;
    private null[] anggota;
    private null[] anggota;
    public Dosen(){};
    public void createKelompkTA(int i){
        for ( i=0; i<=5; i++) {
            kelompokTA[i]= getAnggota();
        }
    }
    
    public void revisiJudulTA (){
        tempJudul = TugasAkhir.getjudulTA();
        System.out.println("masukkan judul baru : "+setJudulTA());
    }
    public void removeKelompokTA (){
        anggota[i]= null;
        System.out.println(" Kelompok telah dihapus ");
    }

    private String getjudulTA() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String setJudulTA() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
