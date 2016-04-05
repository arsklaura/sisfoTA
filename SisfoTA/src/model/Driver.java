/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import model.FileIO;
import view.ConsoleUI;
import model.Application;
import control.Controller;

/**
 *
 * @author agungrb
 */
public class Driver {
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Application app = new Application();
        FileIO io = new FileIO(app);
        Controller control = new Controller(app, io);
        
        app.addDosen("alim", 1234, 2, 5);
        app.addDosen("zul", 4321, 1, 4);
        app.addMahasiswa("agung", 1301144142, 100, true);
        app.addMahasiswa("budi", 1441231, 90, false);
               
//        ConsoleUI ui = new ConsoleUI(app, io);
//        ui.showMenu();
    }
}
