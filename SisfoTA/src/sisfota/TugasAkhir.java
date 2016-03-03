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
    private Dosen[] Pembimbing = new Dosen[2];
    public void SetPembimbing(Dosen d,int i){
        Pembimbing[i]=d;
    }
    public Dosen getPembimbing(int i){
            return Pembimbing[i];
        }
    }
