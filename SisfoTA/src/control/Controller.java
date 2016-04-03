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
        view.addListener(this);
        this.app = app;
        this.io = io;
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        Object source = ae.getSource();
        
        if(source.equals(view.getMenuBukaFile())) {
            io.readFileDosen();
            io.readFileMahasiswa();
        }
        else if(source.equals(view.getMenuSimpanFile())) {
            io.saveFileDosen();
            io.saveFileMahasiswa();
        }
        else if(source.equals(view.getMenuLoginDosen())) {
            view.getPanelLoginDosen().setVisible(true);
        }
        else if(source.equals(view.getBtnLoginDosen())) {
            try {
                int id = view.getTxFieldIdDosen();
                String psw = view.getPswFieldDosen();
                dsn = app.getDosen(id);
                if(dsn != null) {
                    view.setTxFieldNama(dsn.nama);
                    view.getPanelLoginDosen().setVisible(false);
                    view.getDialogSelamatDatang().setVisible(true);
                } 
            } catch (Exception e) {
                System.out.println("Error");
            } 
        }
        else if(source.equals(view.getBtnOK())) {
            view.getDialogSelamatDatang().setVisible(false);
        }
        else if(source.equals(view.getMenuLoginMahasiswa())) {
            view.getPanelLoginMahasiswa().setVisible(true);
        }
        else if(source.equals(view.getBtnLoginMahasiswa())) {
            try {
                int id = view.getTxFieldIdMahasiswa();
                String psw = view.getPswFieldMahasiswa();
                mhs = app.getMahasiswa(id);
                if(mhs != null) {
                    view.setTxFieldNama(mhs.nama);
                    view.getPanelLoginMahasiswa().setVisible(false);
                    view.getDialogSelamatDatang().setVisible(true);
                } 
            } catch (Exception e) {
                System.out.println("Error");
            } 
        }
        else if(source.equals(view.getMenuRegDosen())) {
            view.getPanelRegDosen().setVisible(true);
        }
        else if(source.equals(view.getBtnSubmitRegDosen())) {
            try {
                System.out.println("hello");
                view.getPanelRegDosen().setVisible(false);
                app.addDosen(view.getTxFieldNamaDosen(),
                        view.getTxFieldNIP(),
                        view.getTxFieldStatusPembimbing(),
                        view.getTxFieldJumlahKelompokTA());
            } catch (Exception e) {
                System.out.println("Error");
            }
        }
    }
}
