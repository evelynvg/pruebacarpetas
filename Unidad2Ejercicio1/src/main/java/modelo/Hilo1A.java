/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Evelyn
 */
public class Hilo1A extends Thread {
    private String nombre;
    private int tiempo;
    
    public Hilo1A (String nombre, int tiempo) {
        this.nombre = nombre;
        this.tiempo = tiempo;
    }
    
    public void run() {
        System.out.println(nombre + " se va a dormir " + tiempo + " mseg");
        try {
            Thread.sleep(tiempo);
        } catch (InterruptedException ex) {
            Logger.getLogger(Hilo1A.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(nombre + " se ha despertado");
    }
}
