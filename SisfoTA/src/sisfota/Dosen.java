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
public class Dosen extends Orang implements Serializable {
    private KelompokTA[] topikTA;
    private int nTopikTA = 0;
    private final int maxTopikTA;
    private byte statusPembimbing = 0;
    private final long nip;
    private static int idDosen = 1;
   
    public Dosen(String nama, long nip, byte statusPembimbing,int maxTopikTA) {
        this.nama = nama;
        this.nip = nip;
        this.maxTopikTA = maxTopikTA;
        if(statusPembimbing == 1 || statusPembimbing==2) {
            this.statusPembimbing = statusPembimbing;
        }
        topikTA = new KelompokTA[maxTopikTA];
        idDosen++;
    }
    
    public void createKelompokTA(String topik, int maxAnggota) {
        if(nTopikTA<=maxTopikTA){
            topikTA[nTopikTA] = new KelompokTA(topik, maxAnggota);
            nTopikTA++;
        }
    }
 
    public void removeKelompokTA (int noTopikTA){
        if(noTopikTA<=nTopikTA) {
           topikTA[noTopikTA] = null; 
        }
    }
    
    public void replacePembimbing(Dosen newDosen, int noTopikTA){
        if(newDosen.nTopikTA <= newDosen.maxTopikTA) {
           newDosen.topikTA[newDosen.nTopikTA] = topikTA[noTopikTA];
           newDosen.nTopikTA++;
           topikTA[noTopikTA] = null; 
        }
    }
    
    public void revisiJudulTA (int noTopikTA, int noAnggota, String judulTA){
        if(noTopikTA <= nTopikTA) {
            if(noAnggota <= topikTA[noTopikTA].getnAnggota()) {
                topikTA[noTopikTA].getAnggota(noAnggota).getTugasAkhir().setJudulTA(judulTA);
            }
        }
    }

    @Override
    public String toString() {
        return "Nama : "+nama+" || NIP : "+nip;
    }
    
    
} 
