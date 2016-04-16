/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import model.Application;
import model.Dosen;
import model.Mahasiswa;
import view.LihatDataDosen;
import view.LihatDataMahasiswa;
import view.LoginDosen;
import view.LoginMahasiswa;
import view.MenuUtama;
import view.OlahDataDosen;
import view.OlahDataMahasiswa;
import view.RegistrasiDosen;
import view.RegistrasiMahasiswa;
import view.View;

/**
 *
 * @author agungrb
 */
public class NewController implements ActionListener {

    private Application app;
    private View view;
    private FileIO file;

    private Mahasiswa mhs;
    private Dosen dsn;
    private String nama;
    private int idDosen;

    public NewController(Application app, FileIO file) {
        this.app = app;
        this.file = file;
        gotoMenuUtama();
    }

    public void gotoMenuUtama() {
        MenuUtama x = new MenuUtama();
        x.setVisible(true);
        x.addListener(this);
        view = x;
    }

    public void gotoLoginDosen() {
        LoginDosen x = new LoginDosen();
        x.setVisible(true);
        x.addListener(this);
        view = x;
    }

    public void gotoLoginMahasiswa() {
        LoginMahasiswa x = new LoginMahasiswa();
        x.setVisible(true);
        x.addListener(this);
        view = x;
    }

    public void gotoLihatDataDosen() {
        LihatDataDosen x = new LihatDataDosen();
        x.setVisible(true);
        x.addListener(this);
        view = x;
    }

    public void gotoLihatDataMahasiswa() {
        LihatDataMahasiswa x = new LihatDataMahasiswa();
        x.setVisible(true);
        x.addListener(this);
        view = x;
    }

    public void gotoRegistrasiDosen() {
        RegistrasiDosen x = new RegistrasiDosen();
        x.setVisible(true);
        x.addListener(this);
        view = x;
    }

    public void gotoRegistrasiMahasiswa() {
        RegistrasiMahasiswa x = new RegistrasiMahasiswa();
        x.setVisible(true);
        x.addListener(this);
        view = x;
    }

    public void gotoOlahDataMahasiswa() {
        OlahDataMahasiswa x = new OlahDataMahasiswa();
        x.setTxFieldNama(nama);
        x.setVisible(true);
        x.addListener(this);
        view = x;
    }

    public void gotoOlahDataDosen() {
        OlahDataDosen x = new OlahDataDosen();
        x.setTxFieldNama(nama);
        x.setVisible(true);
        x.addListener(this);
        view = x;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        if (view instanceof MenuUtama) {
            MenuUtama x = (MenuUtama) view;
            if (source.equals(x.getMenuBukaFile())) {
                file.readFileDosen();
                file.readFileMahasiswa();
                JOptionPane.showMessageDialog(null, "Berhasil dibuka");
            } else if (source.equals(x.getMenuSimpanFile())) {
                file.saveFileDosen();
                file.saveFileMahasiswa();
                JOptionPane.showMessageDialog(null, "Berhasil disimpan");
            } else if (source.equals(x.getMenuLoginDosen())) {
                gotoLoginDosen();
                x.dispose();
            } else if (source.equals(x.getMenuLoginMahasiswa())) {
                gotoLoginMahasiswa();
                x.dispose();
            } else if (source.equals(x.getMenuRegDosen())) {
                gotoRegistrasiDosen();
                x.dispose();
            } else if (source.equals(x.getMenuRegMahasiswa())) {
                gotoRegistrasiMahasiswa();
                x.dispose();

            } else if (source.equals(x.getMenuViewDataDosen())) {
                gotoLihatDataDosen();
                x.dispose();
            } else if (source.equals(x.getMenuViewDataMahasiswa())) {
                gotoLihatDataMahasiswa();
                x.dispose();
            }

        } else if (view instanceof LoginDosen) {
            LoginDosen x = (LoginDosen) view;
            if (source.equals(x.getBtnLogin())) {
                try {
                    idDosen = x.getTxFieldId();
                    String psw = x.getPswFieldPassword();
                    dsn = app.getDosen(idDosen);
                    if (dsn != null) {
                        nama = dsn.nama;
                        if (dsn.password.equals(psw)) {
                            JOptionPane.showMessageDialog(null, "Selamat datang, " + dsn.nama, "Login berhasil", 0);
                            gotoOlahDataDosen();
                            x.dispose();
                        } else {
                            JOptionPane.showMessageDialog(null, "ID atau password salah", "Login gagal", 0);
                        }
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "ID atau password salah", "Login gagal", 0);
                }
            } else if (source.equals(x.getBtnCancel())) {
                gotoMenuUtama();
                x.dispose();
            }

        } else if (view instanceof LoginMahasiswa) {
            LoginMahasiswa x = (LoginMahasiswa) view;
            if (source.equals(x.getBtnLogin())) {
                try {
                    int id = x.getTxFieldId();
                    String psw = x.getPswFieldPassword();
                    mhs = app.getMahasiswa(id);
                    if (mhs != null) {
                        nama = mhs.nama;
                        if (mhs.password.equals(psw)) {
                            JOptionPane.showMessageDialog(null, "Selamat datang, " + mhs.nama, "Login berhasil", 0);
                            gotoOlahDataMahasiswa();
                            x.dispose();
                        } else {
                            JOptionPane.showMessageDialog(null, "ID atau password salah", "Login gagal", 0);
                        }
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "ID atau password salah", "Login gagal", 0);
                }
            } else if (source.equals(x.getBtnCancel())) {
                gotoMenuUtama();
                x.dispose();
            }

        } else if (view instanceof RegistrasiDosen) {
            RegistrasiDosen x = (RegistrasiDosen) view;
            if (source.equals(x.getBtnSubmit())) {
                try {
                    System.out.println(x.getCmBoxStatus());
                    app.addDosen(x.getTxFieldPassword(),
                            x.getTxFieldNama(),
                            x.getTxFieldNIP(),
                            x.getCmBoxStatus(),
                            x.getTxFieldNKelompok());
                    JOptionPane.showMessageDialog(null, "ID Anda : "
                            + app.listDosen.size(), "Registrasi berhasil", 0);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Registrasi gagal", "Peringatan", 0);
                }
            } else if (source.equals(x.getBtnBack())) {
                gotoMenuUtama();
                x.dispose();
            }

        } else if (view instanceof RegistrasiMahasiswa) {
            RegistrasiMahasiswa x = (RegistrasiMahasiswa) view;
            if (source.equals(x.getBtnSubmit())) {
                try {
                    app.addMahasiswa(x.getTxFieldPassword(),
                            x.getTxFieldNama(),
                            x.getTxFieldNIM(),
                            x.getTxFieldNSKS(),
                            x.getCmBoxStatus());
                    JOptionPane.showMessageDialog(null, "ID Anda : "
                            + app.listMahasiswa.size(), "Registrasi berhasil", 0);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Registrasi gagal", "Peringatan", 0);
                }
            } else if (source.equals(x.getBtnBack())) {
                gotoMenuUtama();
                x.dispose();
            }

        } else if (view instanceof OlahDataDosen) {
            OlahDataDosen x = (OlahDataDosen) view;
            x.setTxFieldNama(dsn.nama);
            if (source.equals(x.getBtnAddAnggota())) {
                try {
                    int noKel = Integer.parseInt(JOptionPane.showInputDialog(null, "Nomor kelompok :", "Add Anggota", 0));
                    if (dsn.getTopikTA(noKel) != null) {
                        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "ID Mahasiswa :", "Add Anggota", 0));
                        if (app.getMahasiswa(id) != null) {
                            if (dsn.getTopikTA(noKel).addAnggota(app.getMahasiswa(id))) {
                                JOptionPane.showMessageDialog(null, "Nama : " + app.getMahasiswa(id).nama, "Berhasil", 0);
                            } else {
                                JOptionPane.showMessageDialog(null, "Mahasiswa belum punya TA", "Gagal", 0);
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Mahasiswa tidak terdaftar", "Gagal", 0);
                        }

                    } else {
                        JOptionPane.showMessageDialog(null, "Kelompok tidak terdaftar", "Gagal", 0);
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    JOptionPane.showMessageDialog(null, "Sudah melebihi batas", "Gagal", 0);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Gagal");
                }
            } else if (source.equals(x.getBtnRmAnggota())) {
                try {
                    int noKel = Integer.parseInt(JOptionPane.showInputDialog(null, "Nomor kelompok :"));
                    if (dsn.getTopikTA(noKel) != null) {
                        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "Nomor anggota :"));
                        if (dsn.getTopikTA(noKel).removeAnggota(id)) {
                            JOptionPane.showMessageDialog(null, "Nama : " + app.getMahasiswa(id).nama, "Berhasil", 0);
                        }
                        else {
                            JOptionPane.showMessageDialog(null, "Mahasiswa tidak terdaftar", "Gagal", 0);
                        }
                    }
                    else {
                        JOptionPane.showMessageDialog(null, "Kelompok tidak terdaftar", "Gagal", 0);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Gagal");
                }
            } else if (source.equals(x.getBtnAddKelompokTA())) {
                try {
                    String judul = JOptionPane.showInputDialog(null, "Judul Topik TA : ", "Add Kelompok TA", 0);
                    if (!judul.equals("")) {
                        int jumlah = Integer.parseInt(JOptionPane.showInputDialog(null, "Jumlah Anggota : ", "Add Kelompok TA", 0));
                        dsn.createKelompokTA(judul, jumlah);
                        JOptionPane.showMessageDialog(null, "no Kelompok : " + (dsn.getnTopikTA() - 1), "Berhasil", 0);
                    } else {
                        JOptionPane.showMessageDialog(null, "Judul tidak boleh kosong", "Gagal", 0);
                    }
                } catch (ArrayIndexOutOfBoundsException e) {
                    JOptionPane.showMessageDialog(null, "Sudah melebihi batas", "Gagal", 0);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Gagal");
                }
            } else if (source.equals(x.getBtnRmKelompokTA())) {
                try {
                    int noKel = Integer.parseInt(JOptionPane.showInputDialog(null, "Nomor kelompok : ", "Remove Kelompok TA", 0));
                    if (dsn.removeKelompokTA(noKel)) {
                        JOptionPane.showMessageDialog(null, "Berhasil");
                    } else {
                        JOptionPane.showMessageDialog(null, "Kelompok tidak terdaftar", "Gagal", 0);
                    }

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Gagal");
                }
            } else if (source.equals(x.getBtnReplacePembimbing())) {
                try {
                    int id = Integer.parseInt(JOptionPane.showInputDialog(null, "ID Dosen baru : "));
                    if (id != idDosen) {
                        int nokel = Integer.parseInt(JOptionPane.showInputDialog(null, "No kelompok : "));
                        if (dsn.replacePembimbing(app.getDosen(id), nokel)) {
                            JOptionPane.showMessageDialog(null, "Berhasil");
                        } else {
                            JOptionPane.showMessageDialog(null, "Kelompok tidak terdaftar", "Gagal", 0);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Masukkan ID dosen lain!!", "Gagal", 0);
                    }

                } catch (ArrayIndexOutOfBoundsException e) {
                    JOptionPane.showMessageDialog(null, "Dosen atau kelompok\ntidak terdaftar", "Gagal", 0);
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Gagal");
                }

            } else if (source.equals(x.getBtnLogout())) {
                dsn = null;
                gotoMenuUtama();
                x.dispose();
            }

        } else if (view instanceof OlahDataMahasiswa) {
            OlahDataMahasiswa x = (OlahDataMahasiswa) view;
            x.setTxFieldNama(mhs.nama);
            if (source.equals(x.getBtnCreateTA())) {
                try {
                    String judul = JOptionPane.showInputDialog(null, "Judul TA : ", "Buat tugas akhir", 0);
                    if (!judul.equals("")) {
                        if (mhs.createTA(judul)) {
                            JOptionPane.showMessageDialog(null, "Berhasil");
                        } else {
                            JOptionPane.showMessageDialog(null, "Tidak memenuhi syarat", "Gagal", 0);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Judul tidak boleh kosong", "Gagal", 0);
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Gagal");
                }
            } else if (source.equals(x.getBtnRegTA())) {
                try {
                    if (mhs.getTugasAkhir() != null) {
                        int no = Integer.parseInt(JOptionPane.showInputDialog(null, "No pembimbing (1/2) :"));
                        int id = Integer.parseInt(JOptionPane.showInputDialog(null, "ID dosen :"));

                        if (mhs.getTugasAkhir().setPembimbing(app.getDosen(id), no)) {
                            JOptionPane.showMessageDialog(null, "Dosen : " + app.getDosen(id).nama, "Berhasil", 0);
                        } else {
                            JOptionPane.showMessageDialog(null, "Dosen tidak terdaftar");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Belum punya TA", "Gagal", 0);
                    }

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Gagal");
                }
            } else if (source.equals(x.getBtnRevisiTA())) {
                try {
                    if (mhs.getTugasAkhir() != null) {
                        String judul = JOptionPane.showInputDialog(null, "Judul TA baru: ");
                        if (!judul.equals("")) {
                            mhs.getTugasAkhir().setJudulTA(judul);
                            JOptionPane.showMessageDialog(null, "Judul TA berhasil direvisi");
                        } else {
                            JOptionPane.showMessageDialog(null, "Judul tidak boleh kosong", "Gagal", 0);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Belum punya TA", "Gagal", 0);
                    }

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Gagal");
                }
            } else if (source.equals(x.getBtnLogout())) {
                mhs = null;
                gotoMenuUtama();
                x.dispose();
            }

        } else if (view instanceof LihatDataDosen) {
            LihatDataDosen x = (LihatDataDosen) view;
            if (source.equals(x.getBtnOK())) {
                try {
                    int id = x.getTxFieldId();
                    x.setTxFieldNama(app.getDosen(id).nama);
                    x.setTxFieldNIP(app.getDosen(id).getNip());
                    x.setTxFieldNKelompok(app.getDosen(id).getMaxTopikTA());
                    x.setTxFieldTerdaftar(app.getDosen(id).getnTopikTA2());
                    x.setTxFieldStatus(app.getDosen(id).getStatusPembimbing());
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Data tidak ditemukan", "Peringatan", 0);
                }
            } else if (source.equals(x.getBtnBack())) {
                gotoMenuUtama();
                x.dispose();
            }

        } else if (view instanceof LihatDataMahasiswa) {
            LihatDataMahasiswa x = (LihatDataMahasiswa) view;
            if (source.equals(x.getBtnOK())) {
                try {
                    int id = x.getTxFieldId();
                    x.setTxFieldNama(app.getMahasiswa(id).nama);
                    x.setTxFieldNIM(app.getMahasiswa(id).getNim());
                    x.setTxFieldNSKS(app.getMahasiswa(id).getnSKS());
                    x.setTxFieldStatus(app.getMahasiswa(id).getStatusKP());
                    if (app.getMahasiswa(id).getTugasAkhir() != null) {
                        x.setTxFieldJudulTA(app.getMahasiswa(id).getTugasAkhir().getJudulTA());
                        if (app.getMahasiswa(id).getTugasAkhir().getPembimbing(0) != null) {
                            x.setTxFieldPemb1(app.getMahasiswa(id).getTugasAkhir().getPembimbing(0).nama);
                        }
                        if (app.getMahasiswa(id).getTugasAkhir().getPembimbing(1) != null) {
                            x.setTxFieldPemb2(app.getMahasiswa(id).getTugasAkhir().getPembimbing(1).nama);
                        }
                    } else {
                        x.setTxFieldJudulTA("Belum ada TA");
                        x.setTxFieldPemb1("");
                        x.setTxFieldPemb2("");
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Data tidak ditemukan", "Peringatan", 0);
                }
            } else if (source.equals(x.getBtnBack())) {
                gotoMenuUtama();
                x.dispose();
            }
        }
    }

}
