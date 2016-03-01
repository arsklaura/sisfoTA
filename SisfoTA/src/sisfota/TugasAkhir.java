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
    private Dosen Pembimbing[2] = new Dosen();
    public void SetPembimbing(Dosen d, int i){
        for (int i=0; i<=2; i++){
            Pembimbing[i]=setNama(d);
        }
    }
    public String getPembimbing(){
        for (int i=0; i<=2; i++){
            return getNama.Pembimbing[i];
        }
    }
}
