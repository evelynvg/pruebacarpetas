/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package controlador;

import java.util.Scanner;
import modelo.Hilo1A;
import modelo.Hilo2B;

/**
 *
 * @author Evelyn
 */
public class Principal {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Versión A, se inicializa a 20 hilos
        //crearHilo1AB(20);
        
       //Versión 1 y 2B, se inicializa con el scanner
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduzca el número de hilos que quieres crear: ");
        int numeroHilos = sc.nextInt();
        //crearHilo1AB(numeroHilos);
        crearHilo2B(numeroHilos);
    }

    private static void crearHilo1AB(int numeroHilos) {
        int tiempoDurmiendo;
        
        for (int i = 1; i <= numeroHilos; i++) {
            tiempoDurmiendo = (int) ((Math.random()*5000)+1000);
            Hilo1A hilo = new Hilo1A("Hilo " + i, tiempoDurmiendo);
            hilo.start();
        }
    }
    
    private static void crearHilo2B(int numeroHilos) {
        int tiempoDurmiendo;
        
        for (int i = 1; i <= numeroHilos; i++) {
            tiempoDurmiendo = (int) ((Math.random()*5000)+1000);
            Hilo2B hilo = new Hilo2B("Hilo " + i, tiempoDurmiendo);
            hilo.start();
        }
    }
    
    
    
}
