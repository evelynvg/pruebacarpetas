/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unidad2ejercicio4_8_2.modelo;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Evelyn
 */
public class DatosCompartidos {
    private String almacenCadena;
    private int totalDatos;
    private boolean datoDisponible;
    private boolean ultimoDatoLeido;

    public DatosCompartidos() {
    }
    
    public void setTotalDatos(int totalDatos) { //El total de datos que llamaremos desde la clase Productor
        this.totalDatos = totalDatos;
        System.out.println("Total de datos a almacenar " + this.totalDatos);
    }

    public int getTotalDatos() {
        return totalDatos;
    }
    
    public boolean stop() { //Si se ha leído el dato, se llama a stop para parar la ejecución del hilo
        return ultimoDatoLeido == true;
    }
    
    public void almacenarDato(String cadena) {
        while(datoDisponible) { //Mientras datoDisponible es verdad pasa el testigo a otro y espera
            try {
                //Thread.yield(); 
                wait();
                
            } catch (InterruptedException ex) {
                Logger.getLogger(DatosCompartidos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        this.almacenCadena = cadena; //Cadena almacenada y el dato disponible será verdad
        datoDisponible = true; 
        System.out.println("Almacenando el valor: " + almacenCadena); //Imprimo el valor de la cadena y notifico que el dato ya se puede usar
        notifyAll();
        
    }
    
    public String getDato() {           //Si el total de datos es mayor que 0, mientras datoDisponible sea falso
        if (totalDatos > 0) {           //pasa el testigo y espera
            while (!datoDisponible) {
                try {
                    //Thread.yield();
                    wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(DatosCompartidos.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            totalDatos--;               //Cuando el dato está disponible, disminuyo en uno el total de datos a consumir
            datoDisponible = false;     //el dato disponible pasará a falso, porque ya lo he cogido y notifica al productor
            notifyAll();                //que ya está preparado para poner otro
            
        } else {
            almacenCadena = null;       //Si el total de datos es menor, avisamos que ya no hay nada que consumir
            datoDisponible = true;     //Hemos leído el último dato y lo notificamos a los productores
            ultimoDatoLeido = true;
            notifyAll();
        }

        return almacenCadena;
    }
    
}
