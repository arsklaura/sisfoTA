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
public class Dosen extends Orang implements Serializable {
    private KelompokTA[] topikTA;
    private int nTopikTA = 0;
    private final int maxTopikTA;
    private int statusPembimbing = 0;
    private final long nip;
   
    public Dosen(String nama, long nip, int statusPembimbing,int maxTopikTA) {
        this.nama = nama;
        this.nip = nip;
        this.maxTopikTA = maxTopikTA;
        if(statusPembimbing == 1 || statusPembimbing==2) {
            this.statusPembimbing = statusPembimbing;
        }
        topikTA = new KelompokTA[maxTopikTA];
    }
    
    public boolean createKelompokTA(String topik, int maxAnggota) {
        if(nTopikTA < maxTopikTA){
            topikTA[nTopikTA] = new KelompokTA(topik, maxAnggota);
            nTopikTA++;
            return true;
        }
        else {
            return false;
        }
    }
 
    public boolean removeKelompokTA (int noTopikTA){
        if(noTopikTA < nTopikTA) {
           topikTA[noTopikTA] = null;
           return true;
        }
        else {
            return false;
        }
    }
    
    public boolean replacePembimbing(Dosen newDosen, int noTopikTA){
        if(newDosen.nTopikTA <= newDosen.maxTopikTA) {
           newDosen.topikTA[newDosen.nTopikTA] = topikTA[noTopikTA];
           newDosen.nTopikTA++;
           topikTA[noTopikTA] = null;
           return true;
        }
        else {
            return false;
        }
    }
    
    public boolean revisiJudulTA (int noTopikTA, int noAnggota, String judulTA){
        if(noTopikTA <= nTopikTA) {
            if(noAnggota <= topikTA[noTopikTA].getnAnggota()) {
                topikTA[noTopikTA].getAnggota(noAnggota).getTugasAkhir().setJudulTA(judulTA);
                return true;
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
    }

    @Override
    public String toString() {
        return nama+"||"+nip+", Ada "+nTopikTA+" Kelompok TA yg terdaftar"; 

    }

    public int getnTopikTA() {
        return nTopikTA;
    }
    
    public KelompokTA getTopikTA(int noTopikTA) {
        return topikTA[noTopikTA];
    }  
} 
