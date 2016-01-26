/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DataAccessObject.DaoEstacion;
import Modelos.Excepciones;
import Tablas.Estacion;
import java.util.ArrayList;

/**
 *
 * @author jesusaro
 */
public class ControladorEstacion {
    
    private final DaoEstacion daoEstacion;
    
    public ControladorEstacion() {
          
        daoEstacion = new DaoEstacion();
        
    }
    
    public void guardarBus(String informacion[]) throws Excepciones {
        
        Estacion nuevaEstacion = new Estacion(
                                              informacion[0], 
                                              informacion[1], 
                                              informacion[2], 
                                              Integer.parseInt(informacion[3]), 
                                              informacion[4] 
                                             );
        
        daoEstacion.guardarEstacion(nuevaEstacion);
        
    }
    
    public Estacion buscarEstacion(String nombre) throws Excepciones {
        
        try{
            
            Object[] Estacion = daoEstacion.buscarEstacion(nombre).get(0);

            Estacion estacionBuscada = new Estacion(
                                     (String) Estacion[0],
                                     (String) Estacion[1],
                                     (String) Estacion[2],
                                     Integer.parseInt((String) Estacion[3]),
                                     (String) Estacion[4]                                     
                                    );

            return estacionBuscada;
            
        } catch (IndexOutOfBoundsException ex) {
            throw new Excepciones("La estación con el nombre " + nombre + " no existe..." + ex.getMessage());
        }
                
    }
    
    public void modificarEstacion(String informacion[]) throws Excepciones {
        
        Estacion nuevosDatosEstacion = new Estacion(
                                                    informacion[0], 
                                                    informacion[1], 
                                                    informacion[2], 
                                                    Integer.parseInt(informacion[3]), 
                                                    informacion[4] 
                                                   ); 
        
        daoEstacion.modificarEstacion(nuevosDatosEstacion);
        
    }
    
    public void eliminarEstacion(String nombre) throws Excepciones {
        
        daoEstacion.eliminarEstacion(nombre);
        
    }
    
    public Estacion[] listarEstacion() throws Excepciones {
        
        ArrayList<Object[]> listaEstaciones = daoEstacion.listarEstaciones();
        
        Estacion[] estaciones = new Estacion[listaEstaciones.size()];
        
        for (int i=0; i<listaEstaciones.size(); i++) {
            
            Object[] informacionEstacion = listaEstaciones.get(i);
            
            Estacion nuevaEstacion = new Estacion(
                                                  (String) informacionEstacion[0],
                                                  (String) informacionEstacion[1],
                                                  (String) informacionEstacion[2],
                                                  Integer.parseInt((String) informacionEstacion[3]),
                                                  (String) informacionEstacion[4]
                                                 );
            
            estaciones[i] = nuevaEstacion;
                    
        }
        
        return estaciones;
        
    }
    
}
