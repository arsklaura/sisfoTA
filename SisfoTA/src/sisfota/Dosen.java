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
    private final int status;
    
    public Dosen(int maxTopikTA,int status) {
        this.maxTopikTA = maxTopikTA;
        if(status == 1 || status==2) {
            this.status = status;
        }
        topikTA = new KelompokTA[maxTopikTA];
    }
    
    public void createKelompokTA(String topik, int maxAnggota) {
        KelompokTA kta = new KelompokTA(topik, maxAnggota);
        topikTA[nTopikTA] = kta;
        nTopikTA++; 
    }
}
