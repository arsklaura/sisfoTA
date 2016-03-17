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
public class Dosen extends Orang {
    private KelompokTA[] topikTA;
    private int nTopikTA;
    private final int maxTopikTA;
    private byte statusPembimbing;
    private final long nip;
   
    public Dosen(long nip, int maxTopikTA, byte statusPembimbing) {
        this.nip = nip;
        this.maxTopikTA = maxTopikTA;
        if(statusPembimbing == 1 || statusPembimbing==2) {
            this.statusPembimbing = statusPembimbing;
        }
        else {
            this.statusPembimbing = 0;
        }
        topikTA = new KelompokTA[maxTopikTA];
    }
    
    public void createKelompokTA(String topik, int maxAnggota) {
        if(nTopikTA<=maxTopikTA){
            topikTA[nTopikTA] = new KelompokTA(topik, maxAnggota);
            nTopikTA++;
        }
    }
 
    public void removeKelompokTA (int noTopikTA){
        if(noTopikTA<=nTopikTA) {
           topikTA[noTopikTA]= null; 
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
            if(noAnggota <= topikTA[noTopikTA].getNAnggota()) {
                topikTA[noTopikTA].getAnggota(noAnggota).getTugasAkhir().setJudulTA(judulTA);
            }
        }
    }
} 
