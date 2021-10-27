/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unidad2ejercicio4_8_2.modelo;

/**
 *
 * @author Evelyn
 */
public class Productor extends Thread {
    private DatosCompartidos almacen;
    private String nombre;
    private int totalAProducir;

    public Productor(DatosCompartidos almacen, String nombre, int totalAProducir) {
        this.almacen = almacen;
        this.nombre = nombre;
        this.totalAProducir = totalAProducir;
        almacen.setTotalDatos(totalAProducir);
    }
    
    public void run() {
        for (int i = 1; i <=totalAProducir; i++) {
            synchronized(almacen){
                almacen.almacenarDato(nombre + " " + i);
                this.yield();
            }
            
        }
        System.out.println("El productor " + nombre + " ha finalizado de generar datos, cerrando hilo");
    }
}
