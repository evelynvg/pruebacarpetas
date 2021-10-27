/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package unidad2ejercicio4_8_2.controlador;

import unidad2ejercicio4_8_2.modelo.Consumidor;
import unidad2ejercicio4_8_2.modelo.DatosCompartidos;
import unidad2ejercicio4_8_2.modelo.Productor;

/**
 *
 * @author Evelyn
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DatosCompartidos datos = new DatosCompartidos();
        
        Productor productor = new Productor(datos, "Prod1", 100);
        Consumidor consumidor1 = new Consumidor(datos, "Consumidor1");
        Consumidor consumidor2 = new Consumidor(datos, "Consumidor2");
        //Consumidor consumidor3 = new Consumidor(datos, "Consumidor3");
        
        productor.start();
        //consumidor3.start();
        consumidor2.start();
        consumidor1.start();
    }
    
}
