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

    public Dosen(String password, String nama, long nip, int statusPembimbing, int maxTopikTA) {
        this.password = password;
        this.nama = nama;
        this.nip = nip;
        this.maxTopikTA = maxTopikTA;
        if (statusPembimbing == 1 || statusPembimbing == 2) {
            this.statusPembimbing = statusPembimbing;
        }
        topikTA = new KelompokTA[maxTopikTA];
    }

    public void createKelompokTA(String topik, int maxAnggota) {
        topikTA[nTopikTA] = new KelompokTA(topik, maxAnggota);
        nTopikTA++;
    }

    public boolean removeKelompokTA(int noTopikTA) {
        if (topikTA[noTopikTA] != null) {
            topikTA[noTopikTA] = null;
            return true;
        } else {
            return false;
        }
    }

    public boolean replacePembimbing(Dosen newDosen, int noTopikTA) {
        if (topikTA[noTopikTA] != null) {
            newDosen.topikTA[newDosen.nTopikTA] = topikTA[noTopikTA];
            newDosen.nTopikTA++;
            topikTA[noTopikTA] = null;
            return true;
        } else {
            return false;
        }

    }

    public void revisiJudulTA(int noTopikTA, int noAnggota, String judulTA) {
        topikTA[noTopikTA].getAnggota(noAnggota).getTugasAkhir().
                setJudulTA(judulTA);
    }

    @Override
    public String toString() {
        return nama + "||" + nip + ", Ada " + nTopikTA + " Kelompok TA yg terdaftar";

    }

    public int getnTopikTA() {
        return nTopikTA;
    }

    public KelompokTA getTopikTA(int noTopikTA) {
        return topikTA[noTopikTA];
    }

    public long getNip() {
        return nip;
    }

    public int getStatusPembimbing() {
        return statusPembimbing;
    }

    public int getMaxTopikTA() {
        return maxTopikTA;
    }

    public int getnTopikTA2() {
        int temp = 0;
        for (KelompokTA x : topikTA) {
            if (x != null) {
                temp++;
            }
        }
        return temp;
    }

}
