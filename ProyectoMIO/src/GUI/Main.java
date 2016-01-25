/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Controlador.ControladorBus;
import Modelos.Excepciones;
import Tablas.Bus;
import java.util.ArrayList;

/**
 *
 * @author jesusaro
 */
public class Main {
    
    public static void main(String[] args) throws Excepciones {
        
        ControladorBus bus = new ControladorBus();
        
        /*String[] informacionBus = new String[7];
        
        informacionBus[0] = "4321BUS";
        informacionBus[1] = "2010";
        informacionBus[2] = "Mazda";
        informacionBus[3] = "120";
        informacionBus[4] = "Alimentador"; 
        informacionBus[5] = "1";
        informacionBus[6] = "A01";
                
        
        bus.guardarBus(informacionBus);*/
        
        String[] modificarBus = new String[7];
        
        modificarBus[0] = "12345BUS";
        modificarBus[1] = "2016";
        modificarBus[2] = "Maz";
        modificarBus[3] = "12";
        modificarBus[4] = "Ali"; 
        modificarBus[5] = "1";
        modificarBus[6] = "A01";
        
        bus.modificarBus(modificarBus);
        
        bus.eliminarBus("12345BUS");
        
        Bus[] buses = bus.listarBuses();
        
        String mensaje = ""; 
        
        for (int i=0; i<buses.length; i++) {           
                        
            mensaje += "Bus " + i + " : \n\n"
                    + buses[i].getPlaca() + "\n"
                    + buses[i].getModelo() + "\n"
                    + buses[i].getMarca() + "\n"
                    + buses[i].getCapacidad() + "\n"
                    + buses[i].getTipo() + "\n"
                    + buses[i].getParadaRuta() + "\n"
                    + buses[i].getNombreRuta() + "\n\n";
            
        }
        
        System.out.println(mensaje);
        
    }
    
}
