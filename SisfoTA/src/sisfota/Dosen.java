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
    
    public void createKelompokTA(String topikTA, int maxAnggota) {
        KelompokTA kta = new KelompokTA(topikTA, maxAnggota);
    }
}
