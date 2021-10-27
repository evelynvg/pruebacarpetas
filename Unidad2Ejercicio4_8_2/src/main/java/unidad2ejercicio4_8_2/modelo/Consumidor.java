/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package unidad2ejercicio4_8_2.modelo;

/**
 *
 * @author Evelyn
 */
public class Consumidor extends Thread {

    private DatosCompartidos almacen;
    private String nombre;

    public Consumidor(DatosCompartidos almacen, String nombre) {
        this.almacen = almacen;
        this.nombre = nombre;
    }

    @Override
    public void run() {
        String cadena;
        int totalDatosConsumidos = 0;
        
        synchronized (almacen) {
            while (!almacen.stop()) {
                cadena = almacen.getDato();
                if (almacen.getTotalDatos() >= 0 && cadena != null) {
                    System.out.println(nombre + " "+ cadena);
                    totalDatosConsumidos++;
                    this.yield();
                }
            }

        }
        System.out.println("Cierro Hilo: " + this.nombre + "Total datos consumidos: " + totalDatosConsumidos);
    }
}
