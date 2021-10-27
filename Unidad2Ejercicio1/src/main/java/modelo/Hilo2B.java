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
public class Hilo2B implements Runnable {
    private String nombre;
    private int tiempo;
    Thread t;
    
    public Hilo2B (String nombre, int tiempo) {
        this.nombre = nombre;
        this.tiempo = tiempo;
    }
    
    public void start() {
        t = new Thread(this);
        t.start();
    }
    
    public void run() {
        try {
            System.out.println(nombre + " se va a dormir " + tiempo + " mseg...");
            t.sleep(tiempo);
        } catch (InterruptedException ex) {
            Logger.getLogger(Hilo2B.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(nombre + " se ha despertado");
    }
    
}
