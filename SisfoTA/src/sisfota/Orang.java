package sisfota;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author ZULFA UMI WARDANI
 */
import java.util.Date;
import java.io.Serializable;

public abstract class Orang implements Serializable {
    public String nama;
    public long ktp;
    public Date tglLahir = new Date();
    public String tempatLahir;
    public String agama;
}
