///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package control;
//
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import javax.swing.JOptionPane;
//import view.MenuUtama;
//import model.Application;
//import model.Mahasiswa;
//import model.Dosen;
//
///**
// *
// * @author agungrb
// */
//public class Controller implements ActionListener {
//
//    private MenuUtama view;
//    private Application app;
//    private FileIO io;
//    private Dosen dsn;
//    private Mahasiswa mhs;
//
//    public Controller(Application app, FileIO io) {
//        view = new MenuUtama();
//        view.setVisible(true);
//        view.getPanelLoginDosen().setVisible(false);
//        view.getPanelLoginMahasiswa().setVisible(false);
//        view.getPanelRegDosen().setVisible(false);
//        view.getPanelRegMahasiswa().setVisible(false);
//        view.getPanelViewDataDosen().setVisible(false);
//        view.getPanelViewDataMahasiswa().setVisible(false);
//        view.addListener(this);
//        this.app = app;
//        this.io = io;
//    }
//
//    @Override
//    public void actionPerformed(ActionEvent ae) {
//        Object source = ae.getSource();
//
//        GET MENU
//        if (source.equals(view.getMenuBukaFile())) {
//            
//        } else if (source.equals(view.getMenuSimpanFile())) {
//            
//        } else if (source.equals(view.getMenuLoginDosen())) {
//            view.getPanelLoginMahasiswa().setVisible(false);
//            view.getPanelRegDosen().setVisible(false);
//            view.getPanelRegMahasiswa().setVisible(false);
//            view.getPanelViewDataDosen().setVisible(false);
//            view.getPanelViewDataMahasiswa().setVisible(false);
//            view.getPanelLoginDosen().setVisible(true);
//        } else if (source.equals(view.getMenuLoginMahasiswa())) {
//            view.getPanelLoginDosen().setVisible(false);
//            view.getPanelRegDosen().setVisible(false);
//            view.getPanelRegMahasiswa().setVisible(false);
//            view.getPanelViewDataDosen().setVisible(false);
//            view.getPanelViewDataMahasiswa().setVisible(false);
//            view.getPanelLoginMahasiswa().setVisible(true);
//        } else if (source.equals(view.getMenuRegDosen())) {
//            view.getPanelLoginDosen().setVisible(false);
//            view.getPanelLoginMahasiswa().setVisible(false);
//            view.getPanelRegMahasiswa().setVisible(false);
//            view.getPanelViewDataDosen().setVisible(false);
//            view.getPanelViewDataMahasiswa().setVisible(false);
//            view.getPanelRegDosen().setVisible(true);
//        } else if (source.equals(view.getMenuRegMahasiswa())) {
//            view.getPanelLoginDosen().setVisible(false);
//            view.getPanelLoginMahasiswa().setVisible(false);
//            view.getPanelRegDosen().setVisible(false);
//            view.getPanelViewDataDosen().setVisible(false);
//            view.getPanelViewDataMahasiswa().setVisible(false);
//            view.getPanelRegMahasiswa().setVisible(true);
//        } else if (source.equals(view.getMenuViewDataDosen())) {
//            view.getPanelLoginDosen().setVisible(false);
//            view.getPanelLoginMahasiswa().setVisible(false);
//            view.getPanelRegDosen().setVisible(false);
//            view.getPanelRegMahasiswa().setVisible(false);
//            view.getPanelViewDataMahasiswa().setVisible(false);
//            view.getPanelViewDataDosen().setVisible(true);
//        } else if (source.equals(view.getMenuViewDataMahasiswa())) {
//            view.getPanelLoginDosen().setVisible(false);
//            view.getPanelLoginMahasiswa().setVisible(false);
//            view.getPanelRegDosen().setVisible(false);
//            view.getPanelRegMahasiswa().setVisible(false);
//            view.getPanelViewDataDosen().setVisible(false);
//            view.getPanelViewDataMahasiswa().setVisible(true);
//        } //GET BUTTON
//        else if (source.equals(view.getBtnLoginDosen())) {
//            
//        } else if (source.equals(view.getBtnLoginMahasiswa())) {
//            
//        } else if (source.equals(view.getBtnSubmitRegDosen())) {
//            
//        } else if (source.equals(view.getBtnSubmitRegMahasiswa())) {
//            
//        } else if (source.equals(view.getBtnCancelRegDosen())) {
//            view.getPanelRegDosen().setVisible(false);
//        } else if (source.equals(view.getBtnCancelRegMahasiswa())) {
//            view.getPanelRegMahasiswa().setVisible(false);
//        } else if (source.equals(view.getBtnOKViewDataDosen())) {
//            
//        } else if (source.equals(view.getBtnOKViewDataMahasiswa())) {
//            
//        } else if (source.equals(view.getBtnAddKelompokTA())) {
//            
//        } else if (source.equals(view.getBtnRmKelompokTA())) {
//            
//        } else if (source.equals(view.getBtnAddAnggota())) {
//            
//        } else if (source.equals(view.getBtnRmAnggota())) {
//            
//        } else if (source.equals(view.getBtnReplacePembimbing())) {
//            try {
//
//            } catch (Exception e) {
//            }
//        } else if (source.equals(view.getBtnLogoutDosen())) {
//            
//        }
//        else if (source.equals(view.getBtnCreateTA())) {
//            
//        }
//        else if (source.equals(view.getBtnRegTA())) {
//            
//        }
//        else if (source.equals(view.getBtnRevisiTA())) {
//            
//        }
//        else if(source.equals(view.getBtnLogoutMahasiswa())) {
//            
//        }
//
//    }
//}
