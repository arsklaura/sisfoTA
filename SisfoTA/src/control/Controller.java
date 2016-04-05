/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import view.View;
import model.Application;
import model.FileIO;
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
        if(source.equals(view.getMenuBukaFile())) {
            io.readFileDosen();
            io.readFileMahasiswa();
        }
        else if(source.equals(view.getMenuSimpanFile())) {
            io.saveFileDosen();
            io.saveFileMahasiswa();
        }
        else if(source.equals(view.getMenuLoginDosen())) {
            view.getPanelLoginMahasiswa().setVisible(false);
            view.getPanelRegDosen().setVisible(false);
            view.getPanelRegMahasiswa().setVisible(false);
            view.getPanelViewDataDosen().setVisible(false);
            view.getPanelViewDataMahasiswa().setVisible(false);
            view.getPanelLoginDosen().setVisible(true);
        }
        else if(source.equals(view.getMenuLoginMahasiswa())) {
            view.getPanelLoginDosen().setVisible(false);
            view.getPanelRegDosen().setVisible(false);
            view.getPanelRegMahasiswa().setVisible(false);
            view.getPanelViewDataDosen().setVisible(false);
            view.getPanelViewDataMahasiswa().setVisible(false);
            view.getPanelLoginMahasiswa().setVisible(true);
        }
        else if(source.equals(view.getMenuRegDosen())) {
            view.getPanelLoginDosen().setVisible(false);
            view.getPanelLoginMahasiswa().setVisible(false);
            view.getPanelRegMahasiswa().setVisible(false);
            view.getPanelViewDataDosen().setVisible(false);
            view.getPanelViewDataMahasiswa().setVisible(false);
            view.getPanelRegDosen().setVisible(true);
        }
        else if(source.equals(view.getMenuRegMahasiswa())) {
            view.getPanelLoginDosen().setVisible(false);
            view.getPanelLoginMahasiswa().setVisible(false);
            view.getPanelRegDosen().setVisible(false);
            view.getPanelViewDataDosen().setVisible(false);
            view.getPanelViewDataMahasiswa().setVisible(false);
            view.getPanelRegMahasiswa().setVisible(true);
        }
        else if(source.equals(view.getMenuViewDataDosen())) {
            view.getPanelLoginDosen().setVisible(false);
            view.getPanelLoginMahasiswa().setVisible(false);
            view.getPanelRegDosen().setVisible(false);
            view.getPanelRegMahasiswa().setVisible(false);
            view.getPanelViewDataMahasiswa().setVisible(false);
            view.getPanelViewDataDosen().setVisible(true);
        }
        else if(source.equals(view.getMenuViewDataMahasiswa())) {
            view.getPanelLoginDosen().setVisible(false);
            view.getPanelLoginMahasiswa().setVisible(false);
            view.getPanelRegDosen().setVisible(false);
            view.getPanelRegMahasiswa().setVisible(false);
            view.getPanelViewDataDosen().setVisible(false);
            view.getPanelViewDataMahasiswa().setVisible(true);
        }
        else if(source.equals(view.getMenuLogout())) {
            dsn = null;
            mhs = null;
        }
        
        //GET BUTTON
        else if(source.equals(view.getBtnLoginDosen())) {
            try {
                int id = view.getTxFieldIdDosen();
                String psw = view.getPswFieldDosen();
                dsn = app.getDosen(id);
                if(dsn != null) {
                    view.setTxFieldSelamatDatang(dsn.nama);
                    view.getPanelLoginDosen().setVisible(false);
                    view.getDialogSelamatDatang().setVisible(true);
                } 
            } catch (Exception e) {
                view.getDialogUserPswSalah().setVisible(true);
                view.getPanelLoginDosen().setVisible(false);
            } 
        }
        else if(source.equals(view.getBtnLoginMahasiswa())) {
            try {
                int id = view.getTxFieldIdMahasiswa();
                String psw = view.getPswFieldMahasiswa();
                mhs = app.getMahasiswa(id);
                if(mhs != null) {
                    view.setTxFieldSelamatDatang(mhs.nama);
                    view.getPanelLoginMahasiswa().setVisible(false);
                    view.getDialogSelamatDatang().setVisible(true);
                } 
            } catch (Exception e) {
                view.getDialogUserPswSalah().setVisible(true);
                view.getPanelLoginMahasiswa().setVisible(false);
            } 
        }
        else if(source.equals(view.getBtnOKBerhasil())) {
            view.getDialogBerhasil().setVisible(false);
        }
        else if(source.equals(view.getBtnOKSelamatDatang())) {
            view.getDialogSelamatDatang().setVisible(false);
        }
        else if(source.equals(view.getBtnSubmitRegDosen())) {
            try {
                System.out.println(view.getCmBoxStatusPembimbing());
                view.getPanelRegDosen().setVisible(false);
                app.addDosen(view.getTxFieldNamaDosen(),
                        view.getTxFieldNIP(),
                        view.getCmBoxStatusPembimbing(),
                        view.getTxFieldJumlahKelompokTA());
                view.setTxFieldBerhasil(Integer.toString(app.listDosen.size()));
                view.getPanelRegDosen().setVisible(false);
                view.getDialogBerhasil().setVisible(true);
            } catch (Exception e) {
            }
        }
        else if(source.equals(view.getBtnSubmitRegMahasiswa())) {
            try {
                app.addMahasiswa(view.getTxFieldNamaMahasiswa(),
                        view.getTxFieldNIM(),
                        view.getTxFieldJumlahSKS(),
                        view.getCmBoxStatusKP());
                view.setTxFieldBerhasil(Integer.toString(app.listMahasiswa.size()));
                view.getPanelRegMahasiswa().setVisible(false);
                view.getDialogBerhasil().setVisible(true);
            } catch (Exception e) {
            }
        }
        else if(source.equals(view.getBtnCancelRegDosen())) {
            view.getPanelRegDosen().setVisible(false);
        }
        else if(source.equals(view.getBtnCancelRegMahasiswa())) {
            view.getPanelRegMahasiswa().setVisible(false);
        }
        else if(source.equals(view.getBtnOKViewDataDosen())) {
            try {
                int id = view.getTxFieldGetIdDosen();
                view.setTxFieldShowNamaDosen(app.getDosen(id).nama);
                view.setTxFieldShowNIP(app.getDosen(id).getNip());
                view.setTxFieldShowNamaDosen(app.getDosen(id).nama);
                view.setTxFieldShowJumlahKelompokTA(app.getDosen(id).getnTopikTA());
                view.setTxFieldShowStatusDosen(app.getDosen(id).getStatusPembimbing());
            } catch (Exception e) {
            } 
        }
        else if(source.equals(view.getBtnOKViewDataMahasiswa())) {
            try {
                int id = view.getTxFieldGetIdMahasiswa();
                view.setTxFieldShowNamaMahasiswa(app.getMahasiswa(id).nama);
                view.setTxFieldShowNIM(app.getMahasiswa(id).getNim());
                view.setTxFieldShowJumlahSKS(app.getMahasiswa(id).getnSKS());
                view.setTxFieldShowStatusKP(app.getMahasiswa(id).getStatusKP());
            } catch (Exception e) {
            }  
        }
        else if(source.equals(view.getBtnOKUserPswSalah())) {
            view.getDialogUserPswSalah().setVisible(false);
        }
    }
}
