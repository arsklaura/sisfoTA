/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisfota;
import java.io.Serializable;

/**
 *
 * @author SD
 */
public class TugasAkhir implements Serializable {
    private Dosen[] pembimbing = new Dosen[2];
    private String judulTA;
    
    public TugasAkhir(String judulTA) {
        this.judulTA = judulTA;
    }
    public void SetPembimbing(Dosen d,int noPembimbing){
        pembimbing[noPembimbing] = d;
    }
    public Dosen getPembimbing(int noPembimbing){
        return pembimbing[noPembimbing];
    }

    public String getJudulTA() {
        return judulTA;
    }

    public void setJudulTA(String judulTA) {
        this.judulTA = judulTA;
    }
    
}