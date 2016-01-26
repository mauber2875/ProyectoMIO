/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DataAccessObject.DaoConduce;
import Modelos.Excepciones;
import Tablas.Conduce;
import java.util.ArrayList;

/**
 *
 * @author jesusaro
 */
public class ControladorConduce {
    
    private final DaoConduce daoConduce;
    
    public ControladorConduce() {
          
        daoConduce = new DaoConduce();
        
    }
    
    public void guardarTurno(String informacion[]) throws Excepciones {
        
        Conduce nuevoTurno = new Conduce(
                                         informacion[0], 
                                         informacion[1], 
                                         informacion[2], 
                                         informacion[3], 
                                         informacion[4] 
                                        );
        
        daoConduce.guardarTurno(nuevoTurno);
        
    }
    
    public Conduce buscarTurno(String cedula) throws Excepciones {
        
        try{
            
            Object[] turno = daoConduce.buscarTurno(cedula).get(0);

            Conduce turnoBuscado = new Conduce(
                                               (String) turno[0],
                                               (String) turno[1],
                                               (String) turno[2],
                                               (String) turno[3],
                                               (String) turno[4]
                                              );

            return turnoBuscado;
            
        } catch (IndexOutOfBoundsException ex) {
            throw new Excepciones("El conductor con la cedula N° " + cedula + " no tiene ningun turno asignado..." + ex.getMessage());
        }
                
    }
    
    public void modificarTurno(String informacion[]) throws Excepciones {
        
        Conduce nuevosDatosTurno = new Conduce(
                                                informacion[0], 
                                                informacion[1], 
                                                informacion[2], 
                                                informacion[3], 
                                                informacion[4] 
                                               ); 
        
        daoConduce.modificarTurno(nuevosDatosTurno);
        
    }
    
    public void eliminarTurno(String cedula) throws Excepciones {
        
        daoConduce.eliminarTurno(cedula);
        
    }
    
    public Conduce[] listarTurnos() throws Excepciones {
        
        ArrayList<Object[]> listaTurnos = daoConduce.listarTurnos();
        
        Conduce[] turnos = new Conduce[listaTurnos.size()];
        
        for (int i=0; i<listaTurnos.size(); i++) {
            
            Object[] informacionTurno = listaTurnos.get(i);
            
            Conduce nuevoTurno = new Conduce(
                                             (String) informacionTurno[0],
                                             (String) informacionTurno[1],
                                             (String) informacionTurno[2],
                                             (String) informacionTurno[3],
                                             (String) informacionTurno[4]
                                            );
            
            turnos[i] = nuevoTurno;
                    
        }
        
        return turnos;
        
    }
    
}
