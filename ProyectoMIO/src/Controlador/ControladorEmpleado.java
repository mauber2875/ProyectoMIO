/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DataAccessObject.DaoEmpleado;
import Modelos.Excepciones;
import Tablas.Empleado;
import java.util.ArrayList;

/**
 *
 * @author jesusaro
 */
public class ControladorEmpleado {
    
    private final DaoEmpleado daoEmpleado;
    
    public ControladorEmpleado() {
    
        daoEmpleado = new DaoEmpleado();
        
    }
    
    public void guardarEmpleado(String informacion[]) throws Excepciones {
        
        Empleado nuevoEmpleado = new Empleado(
                                              informacion[0],
                                              Double.parseDouble(informacion[1]),
                                              informacion[2],
                                              informacion[3],
                                              informacion[4],
                                              informacion[5],
                                              informacion[6]
                                             );
        
        daoEmpleado.guardarEmpleado(nuevoEmpleado);
        
    }
    
    public Empleado buscarEmpleado(String cedula) throws Excepciones {
        
        try{
            
            Object[] empleado = daoEmpleado.buscarEmpleado(cedula).get(0);

            Empleado empleadoBuscado = new Empleado(
                                     (String) empleado[0],
                                     Double.parseDouble((String) empleado[1]),
                                     (String) empleado[2],
                                     (String) empleado[3],
                                     (String) empleado[4],
                                     (String) empleado[5],
                                     (String) empleado[6]
                                    );

            return empleadoBuscado;
            
        } catch (IndexOutOfBoundsException ex) {
            throw new Excepciones("El empleado con la cédula " + cedula + " no existe..." + ex.getMessage());
        }           
                
    }
    
    public void modificarEmpleado(String informacion[]) throws Excepciones {
        
            Empleado nuevosDatosEmpleado = new Empleado(
                                         informacion[0], 
                                         Double.parseDouble(informacion[1]), 
                                         informacion[2], 
                                         informacion[3], 
                                         informacion[4], 
                                         informacion[5], 
                                         informacion[6]
                                        ); 

            daoEmpleado.modificarEmpleado(nuevosDatosEmpleado);
        
    }
    
    public void eliminarEmpleado(String cedula) throws Excepciones {
        
        daoEmpleado.eliminarEmpleado(cedula);
        
    }
    
    public Empleado[] listarEmpleados() throws Excepciones {
        
        ArrayList<Object[]> listaEmpleados = daoEmpleado.listarEmpleados();
        
        Empleado[] empleados = new Empleado[listaEmpleados.size()];
        
        for (int i=0; i<listaEmpleados.size(); i++) {
            
            Object[] informacionEmpleado = listaEmpleados.get(i);
            
            Empleado nuevoEmpleado = new Empleado(
                                   (String) informacionEmpleado[0],
                                   Double.parseDouble((String) informacionEmpleado[1]),
                                   (String) informacionEmpleado[2],
                                   (String) informacionEmpleado[3],
                                   (String) informacionEmpleado[4],
                                   (String) informacionEmpleado[5],
                                   (String) informacionEmpleado[6]
                                  );
            
            empleados[i] = nuevoEmpleado;
                    
        }
        
        return empleados;
        
    }
    
    
    
}
