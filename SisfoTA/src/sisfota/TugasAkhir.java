/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisfota;

/**
 *
 * @author SD
 */
public class TugasAkhir {
    private Dosen[] pembimbing = new Dosen[2];
    private String judulTA;
    
    public TugasAkhir(String judulTA) {
        this.judulTA = judulTA;
    }
    public void SetPembimbing(Dosen d,int i){
        pembimbing[i]=d;
    }
    public Dosen getPembimbing(int i){
        return pembimbing[i];
    }
}
