/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;
import java.awt.event.ActionListener;

/**
 *
 * @author agungrb
 */
public class MenuUtama extends javax.swing.JFrame implements View {

    /**
     * Creates new form View
     */
    public MenuUtama() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        menuBar = new javax.swing.JMenuBar();
        menuFile = new javax.swing.JMenu();
        menuBukaFile = new javax.swing.JMenuItem();
        menuSimpanFile = new javax.swing.JMenuItem();
        menuLogin = new javax.swing.JMenu();
        menuLoginDosen = new javax.swing.JMenuItem();
        menuLoginMahasiswa = new javax.swing.JMenuItem();
        menuRegistrasi = new javax.swing.JMenu();
        menuRegDosen = new javax.swing.JMenuItem();
        menuRegMahasiswa = new javax.swing.JMenuItem();
        menuView = new javax.swing.JMenu();
        menuViewDataDosen = new javax.swing.JMenuItem();
        menuViewDataMahasiswa = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Sistem Informasi TA");
        setResizable(false);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("SISTEM INFORMASI TA");

        menuFile.setText("File");

        menuBukaFile.setText("Buka file");
        menuFile.add(menuBukaFile);

        menuSimpanFile.setText("Simpan file");
        menuFile.add(menuSimpanFile);

        menuBar.add(menuFile);

        menuLogin.setText("Login");

        menuLoginDosen.setText("Login Dosen");
        menuLogin.add(menuLoginDosen);

        menuLoginMahasiswa.setText("Login Mahasiswa");
        menuLogin.add(menuLoginMahasiswa);

        menuBar.add(menuLogin);

        menuRegistrasi.setText("Registrasi");

        menuRegDosen.setText("Reg. Dosen");
        menuRegistrasi.add(menuRegDosen);

        menuRegMahasiswa.setText("Reg. Mahasiswa");
        menuRegistrasi.add(menuRegMahasiswa);

        menuBar.add(menuRegistrasi);

        menuView.setText("View");

        menuViewDataDosen.setText("Data Dosen");
        menuView.add(menuViewDataDosen);

        menuViewDataMahasiswa.setText("Data Mahasiswa");
        menuView.add(menuViewDataMahasiswa);

        menuBar.add(menuView);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addContainerGap(200, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(246, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    
    //GETTER TEXT FIELD, COMBO BOX, etc
    
    
    
    
    
    
   
    
    
    
    
    //GETTER MENU, BUTTON, etc
    
    
    public Object getMenuLoginDosen() {
        return menuLoginDosen;
    }
    public Object getMenuLoginMahasiswa() {
        return menuLoginMahasiswa;
    }
    public Object getMenuBukaFile() {
        return menuBukaFile;
    }
    public Object getMenuSimpanFile() {
        return menuSimpanFile;
    }
    public Object getMenuRegDosen() {
        return menuRegDosen;
    }
    public Object getMenuRegMahasiswa() {
        return menuRegMahasiswa;
    }
    public Object getMenuViewDataDosen() {
        return menuViewDataDosen;
    }
    public Object getMenuViewDataMahasiswa() {
        return menuViewDataMahasiswa;
    }
       
    @Override
    public void addListener(ActionListener e) {
        menuViewDataDosen.addActionListener(e);
        menuViewDataMahasiswa.addActionListener(e);
        menuBukaFile.addActionListener(e);
        menuSimpanFile.addActionListener(e);
        menuLoginMahasiswa.addActionListener(e);
        menuLoginDosen.addActionListener(e);
        menuRegDosen.addActionListener(e);
        menuRegMahasiswa.addActionListener(e);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenuItem menuBukaFile;
    private javax.swing.JMenu menuFile;
    private javax.swing.JMenu menuLogin;
    private javax.swing.JMenuItem menuLoginDosen;
    private javax.swing.JMenuItem menuLoginMahasiswa;
    private javax.swing.JMenuItem menuRegDosen;
    private javax.swing.JMenuItem menuRegMahasiswa;
    private javax.swing.JMenu menuRegistrasi;
    private javax.swing.JMenuItem menuSimpanFile;
    private javax.swing.JMenu menuView;
    private javax.swing.JMenuItem menuViewDataDosen;
    private javax.swing.JMenuItem menuViewDataMahasiswa;
    // End of variables declaration//GEN-END:variables
}