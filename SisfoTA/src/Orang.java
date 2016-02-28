
import java.sql.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ZULFA UMI WARDANI
 */
public abstract class Orang {
    private String nama;
    private Date tgl_lahir;
    private long ktp;
    private char jKelamin;
    private String agama;
    private String tempatLahir;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public Date getTgl_lahir() {
        return tgl_lahir;
    }

    public void setTgl_lahir(Date tgl_lahir) {
        this.tgl_lahir = tgl_lahir;
    }

    public long getKtp() {
        return ktp;
    }

    public void setKtp(long ktp) {
        this.ktp = ktp;
    }

    public char getjKelamin() {
        return jKelamin;
    }

    public void setjKelamin(char jKelamin) {
        this.jKelamin = jKelamin;
    }

    public String getAgama() {
        return agama;
    }

    public void setAgama(String agama) {
        this.agama = agama;
    }

    public String getTempatLahir() {
        return tempatLahir;
    }

    public void setTempatLahir(String tempatLahir) {
        this.tempatLahir = tempatLahir;
    }
    
    
}
