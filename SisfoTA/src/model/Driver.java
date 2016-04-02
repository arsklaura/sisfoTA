/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import application.FileIO;
import view.ConsoleUI;
import application.Application;

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
        ConsoleUI ui = new ConsoleUI(app, io);
        ui.showMenu();
    }
}
