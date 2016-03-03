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
    private final byte statusPembimbing;
    private long nip;
    private String jabatan;
    
    public Dosen(int maxTopikTA,byte status) {
        this.maxTopikTA = maxTopikTA;
        if(status == 1 || status==2) {
            this.statusPembimbing = status;
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
}
