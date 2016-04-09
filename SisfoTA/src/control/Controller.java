/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import view.View;
import model.Application;
import model.Mahasiswa;
import model.Dosen;

/**
 *
 * @author agungrb
 */
public class Controller implements ActionListener {

    private View view;
    private Application app;
    private FileIO io;
    private Dosen dsn;
    private Mahasiswa mhs;

    public Controller(Application app, FileIO io) {
        view = new View();
        view.setVisible(true);
        view.getPanelLoginDosen().setVisible(false);
        view.getPanelLoginMahasiswa().setVisible(false);
        view.getPanelRegDosen().setVisible(false);
        view.getPanelRegMahasiswa().setVisible(false);
        view.getPanelViewDataDosen().setVisible(false);
        view.getPanelViewDataMahasiswa().setVisible(false);
        view.addListener(this);
        this.app = app;
        this.io = io;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();

        //GET MENU
        if (source.equals(view.getMenuBukaFile())) {
            io.readFileDosen();
            io.readFileMahasiswa();
        } else if (source.equals(view.getMenuSimpanFile())) {
            io.saveFileDosen();
            io.saveFileMahasiswa();
        } else if (source.equals(view.getMenuLoginDosen())) {
            view.getPanelLoginMahasiswa().setVisible(false);
            view.getPanelRegDosen().setVisible(false);
            view.getPanelRegMahasiswa().setVisible(false);
            view.getPanelViewDataDosen().setVisible(false);
            view.getPanelViewDataMahasiswa().setVisible(false);
            view.getPanelLoginDosen().setVisible(true);
        } else if (source.equals(view.getMenuLoginMahasiswa())) {
            view.getPanelLoginDosen().setVisible(false);
            view.getPanelRegDosen().setVisible(false);
            view.getPanelRegMahasiswa().setVisible(false);
            view.getPanelViewDataDosen().setVisible(false);
            view.getPanelViewDataMahasiswa().setVisible(false);
            view.getPanelLoginMahasiswa().setVisible(true);
        } else if (source.equals(view.getMenuRegDosen())) {
            view.getPanelLoginDosen().setVisible(false);
            view.getPanelLoginMahasiswa().setVisible(false);
            view.getPanelRegMahasiswa().setVisible(false);
            view.getPanelViewDataDosen().setVisible(false);
            view.getPanelViewDataMahasiswa().setVisible(false);
            view.getPanelRegDosen().setVisible(true);
        } else if (source.equals(view.getMenuRegMahasiswa())) {
            view.getPanelLoginDosen().setVisible(false);
            view.getPanelLoginMahasiswa().setVisible(false);
            view.getPanelRegDosen().setVisible(false);
            view.getPanelViewDataDosen().setVisible(false);
            view.getPanelViewDataMahasiswa().setVisible(false);
            view.getPanelRegMahasiswa().setVisible(true);
        } else if (source.equals(view.getMenuViewDataDosen())) {
            view.getPanelLoginDosen().setVisible(false);
            view.getPanelLoginMahasiswa().setVisible(false);
            view.getPanelRegDosen().setVisible(false);
            view.getPanelRegMahasiswa().setVisible(false);
            view.getPanelViewDataMahasiswa().setVisible(false);
            view.getPanelViewDataDosen().setVisible(true);
        } else if (source.equals(view.getMenuViewDataMahasiswa())) {
            view.getPanelLoginDosen().setVisible(false);
            view.getPanelLoginMahasiswa().setVisible(false);
            view.getPanelRegDosen().setVisible(false);
            view.getPanelRegMahasiswa().setVisible(false);
            view.getPanelViewDataDosen().setVisible(false);
            view.getPanelViewDataMahasiswa().setVisible(true);
        } //GET BUTTON
        else if (source.equals(view.getBtnLoginDosen())) {
            try {
                int id = view.getTxFieldIdDosen();
                String psw = view.getPswFieldDosen();
                dsn = app.getDosen(id);
                if (dsn != null) {
                    JOptionPane.showMessageDialog(null, "Selamat datang, " + dsn.nama, "Login berhasil", 0);
                    view.getPanelLoginDosen().setVisible(false);
                    view.setTxFieldSetNamaDosen(dsn.nama);
                    view.getFrameOlahDataDosen().setVisible(true);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "ID atau password salah", "Login gagal", 0);
            }
        } else if (source.equals(view.getBtnLoginMahasiswa())) {
            try {
                int id = view.getTxFieldIdMahasiswa();
                String psw = view.getPswFieldMahasiswa();
                mhs = app.getMahasiswa(id);
                if (mhs != null) {
                    JOptionPane.showMessageDialog(null, "Selamat datang, " + mhs.nama, "Login berhasil", 0);
                    view.getPanelLoginMahasiswa().setVisible(false);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "ID atau password salah", "Login gagal", 0);
            }
        } else if (source.equals(view.getBtnSubmitRegDosen())) {
            try {
                System.out.println(view.getCmBoxStatusPembimbing());
                view.getPanelRegDosen().setVisible(false);
                app.addDosen(view.getTxFieldNamaDosen(),
                        view.getTxFieldNIP(),
                        view.getCmBoxStatusPembimbing(),
                        view.getTxFieldJumlahKelompokTA());
                JOptionPane.showMessageDialog(null, "ID Anda : "
                        + app.listDosen.size(), "Registrasi berhasil", 0);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Registrasi gagal", "Peringatan", 0);
            }
        } else if (source.equals(view.getBtnSubmitRegMahasiswa())) {
            try {
                app.addMahasiswa(view.getTxFieldNamaMahasiswa(),
                        view.getTxFieldNIM(),
                        view.getTxFieldJumlahSKS(),
                        view.getCmBoxStatusKP());
                JOptionPane.showMessageDialog(null, "ID Anda : "
                        + app.listMahasiswa.size(), "Registrasi berhasil", 0);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Registrasi gagal", "Peringatan", 0);
            }
        } else if (source.equals(view.getBtnCancelRegDosen())) {
            view.getPanelRegDosen().setVisible(false);
        } else if (source.equals(view.getBtnCancelRegMahasiswa())) {
            view.getPanelRegMahasiswa().setVisible(false);
        } else if (source.equals(view.getBtnOKViewDataDosen())) {
            try {
                int id = view.getTxFieldGetIdDosen();
                view.setTxFieldShowNamaDosen(app.getDosen(id).nama);
                view.setTxFieldShowNIP(app.getDosen(id).getNip());
                view.setTxFieldShowNamaDosen(app.getDosen(id).nama);
                view.setTxFieldShowJumlahKelompokTA(app.getDosen(id).getMaxTopikTA());
                view.setTxFieldKelompokTATerdaftar(app.getDosen(id).getnTopikTA());
                view.setTxFieldShowStatusDosen(app.getDosen(id).getStatusPembimbing());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Data tidak ditemukan", "Peringatan", 0);
            }
        } else if (source.equals(view.getBtnOKViewDataMahasiswa())) {
            try {
                int id = view.getTxFieldGetIdMahasiswa();
                view.setTxFieldShowNamaMahasiswa(app.getMahasiswa(id).nama);
                view.setTxFieldShowNIM(app.getMahasiswa(id).getNim());
                view.setTxFieldShowJumlahSKS(app.getMahasiswa(id).getnSKS());
                view.setTxFieldShowStatusKP(app.getMahasiswa(id).getStatusKP());
                view.setTxFieldStatusTA(app.getMahasiswa(id).getTugasAkhir() != null);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Data tidak ditemukan", "Peringatan", 0);
            }
        } else if (source.equals(view.getBtnAddKelompokTA())) {
            try {
                String judul = JOptionPane.showInputDialog(null, "Judul Topik TA : ", "Add Kelompok TA", 0);
                int jumlah = Integer.parseInt(JOptionPane.showInputDialog(null, "Jumlah Anggota : ", "Add Kelompok TA", 0));
                dsn.createKelompokTA(judul, jumlah);
                JOptionPane.showMessageDialog(null, "no Kelompok : " + (dsn.getnTopikTA() - 1), "Berhasil", 0);
            } 
            catch (ArrayIndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(null, "Sudah melebihi batas", "Gagal", 0);
            } 
            catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Gagal");
            }
        } else if (source.equals(view.getBtnRmKelompokTA())) {
            try {
                int noKel = Integer.parseInt(JOptionPane.showInputDialog(null, "Nomor kelompok : ", "Remove Kelompok TA", 0));
                if(dsn.removeKelompokTA(noKel)) {
                   JOptionPane.showMessageDialog(null, "Berhasil"); 
                }
                else {
                    JOptionPane.showMessageDialog(null, "Kelompok masih kosong", "Gagal", 0);
                }
            } 
            catch (ArrayIndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(null, "Kelompok tidak terdaftar", "Gagal", 0);
            } 
            catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Gagal");
            }
        } else if (source.equals(view.getBtnAddAnggota())) {
            try {
                int noKel = Integer.parseInt(JOptionPane.showInputDialog(null, "Nomor kelompok :", "Add Anggota", 0));
                int id = Integer.parseInt(JOptionPane.showInputDialog(null, "ID Mahasiswa :", "Add Anggota", 0));
                if (dsn.getTopikTA(noKel).addAnggota(app.getMahasiswa(id))) {
                    JOptionPane.showMessageDialog(null, "Mahasiswa : " + app.getMahasiswa(id).nama, "Berhasil", 0);
                } else {
                    JOptionPane.showMessageDialog(null, "Belum punya TA", "Gagal", 0);
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                JOptionPane.showMessageDialog(null, "Sudah melebihi batas", "Gagal", 0);
            }
            catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Gagal");
            }
        } else if (source.equals(view.getBtnRmAnggota())) {
            try {
                int noKel = Integer.parseInt(JOptionPane.showInputDialog(null, "Nomor kelompok :", "Add Anggota", 0));
                int id = Integer.parseInt(JOptionPane.showInputDialog(null, "ID Mahasiswa :", "Add Anggota", 0));
                dsn.getTopikTA(noKel).removeAnggota(id);
            }
            catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Gagal");
            }
        }
    }
}