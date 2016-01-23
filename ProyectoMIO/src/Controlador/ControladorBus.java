/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DataAccessObject.DaoBus;
import Modelos.Excepciones;
import Tablas.Bus;

/**
 *
 * @author jesusaro
 */
public class ControladorBus {
    
    private final DaoBus daoBus;
    
    public ControladorBus() {
          
        daoBus = new DaoBus();
        
    }
    
    public void crearBus(String informacion[]) throws Excepciones {
        
        Bus nuevoBus = new Bus(informacion[0], informacion[1], informacion[2], Integer.parseInt(informacion[3]), informacion[4], Integer.parseInt(informacion[5]), informacion[6]); 
        
    }
    
}
