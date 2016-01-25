/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DataAccessObject.DaoBus;
import Modelos.Excepciones;
import Tablas.Bus;
import java.util.ArrayList;

/**
 *
 * @author jesusaro
 */
public class ControladorBus {
    
    private final DaoBus daoBus;
    
    public ControladorBus() {
          
        daoBus = new DaoBus();
        
    }
    
    public void guardarBus(String informacion[]) throws Excepciones {
        
        Bus nuevoBus = new Bus(informacion[0], informacion[1], informacion[2], Integer.parseInt(informacion[3]), informacion[4], Integer.parseInt(informacion[5]), informacion[6]); 
        daoBus.guardarBus(nuevoBus);
        
    }
    
    public void modificarBus(String informacion[]) throws Excepciones {
        
        Bus nuevosDatosBus = new Bus(informacion[0], informacion[1], informacion[2], Integer.parseInt(informacion[3]), informacion[4], Integer.parseInt(informacion[5]), informacion[6]); 
        daoBus.modificarBus(nuevosDatosBus);
        
    }
    
    public void eliminarBus(String placa) throws Excepciones {
        
        daoBus.eliminarBus(placa);
        
    }
    
    public Bus[] listarBuses() throws Excepciones {
        
        ArrayList<Object[]> listaBuses = daoBus.listarBuses();
        
        Bus[] buses = new Bus[listaBuses.size()];
        
        for (int i=0; i<listaBuses.size(); i++) {
            
            Object[] informacionBus = listaBuses.get(i);
            
            Bus nuevoBus = new Bus(
                                   (String) informacionBus[0],
                                   (String) informacionBus[1],
                                   (String) informacionBus[2],
                                   Integer.parseInt((String) informacionBus[3]),
                                   (String) informacionBus[4],
                                   Integer.parseInt((String) informacionBus[5]),
                                   (String) informacionBus[6]
                                   );
            
            buses[i] = nuevoBus;
                    
        }
        
        return buses;
        
    }
    
}
