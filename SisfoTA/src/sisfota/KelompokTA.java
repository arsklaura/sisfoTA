/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sisfota;

/**
 *
 * @author ZULFA UMI WARDANI
 */
class KelompokTA {
    private String topik;
    private Mahasiswa[] anggota = new Mahasiswa[2];
    
    public KelompokTA (){};
    public void addAnggota(){
        for (int i; i<=0; i++){
        anggota[i] = new Mahasiswa [i];
        anggota[i].nama= "ulfa";
        anggota[i].ktp = 1301144082;
        anggota[i].tglLahir = 23/02/1996;
        anggota[i].tempatLahir = " Semarang";
        anggota[i].agama = "Islam";
        }
    };
    public void removeAnggota(){
        System.out.println("Anggota dengan no ktp"+anggota[i].getktp()+" Telah di keluarkan dari kelompok ");
    };
    public replacePembimbing(){
        System.out.println("Dosen dengan status "+getstatus()+ " Telah dipindahkan ");
    }
    
    
    
}
