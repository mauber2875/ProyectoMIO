/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessObject;

import Modelos.Excepciones;
import Tablas.Empleado;
import java.util.ArrayList;

/**
 *
 * @author jesusaro
 */
public class DaoEmpleado extends DataAccessObject {
    
    private String sql;
    
    public DaoEmpleado() {
        
        super();
        
    }
    
    public void guardarEmpleado(Empleado empleado) throws Excepciones {
        
        sql = "INSERT INTO empleado VALUES ('"
                + empleado.getCedula() + "', '"
                + empleado.getSalario() + "', '"
                + empleado.getNombre() + "', '"
                + empleado.getTelefono() + "', '"
                + empleado.getFechaNacimiento() + "', '"
                + empleado.getEstadoCivil() + "', '"
                + empleado.getCargo() + "');";
        
        executeUpdate(sql);
        
    }
    
    public ArrayList<Object[]> buscarEmpleado(String cedula) throws Excepciones {
        
        sql = "SELECT * FROM empleado WHERE cedula_empleado = '" + cedula + "' AND eliminado <> '1';";
        
        return executeQuery(sql, 8);
        
    }
    
    public void modificarEmpleado(Empleado empleado) throws Excepciones {
        
        sql = "UPDATE empleado SET "
                + "salario = '" + empleado.getSalario() + "', "
                + "nombre = '" + empleado.getNombre() + "', "
                + "telefono= '" + empleado.getTelefono() + "', "
                + "fecha_nacimiento = '" + empleado.getFechaNacimiento() + "', "
                + "estado_civil = '" + empleado.getEstadoCivil() + "', "
                + "cargo = '" + empleado.getCargo() + "' "
                + "WHERE cedula_empleado = '" + empleado.getCedula() + "';";
        
        executeUpdate(sql);
        
    }   
    
    public void eliminarEmpleado(String cedula) throws Excepciones {
        
        sql = "UPDATE empleado SET eliminado = '1' WHERE cedula_empleado = '" + cedula + "';";
        
        executeUpdate(sql);
        
    } 
    
    public ArrayList<Object[]> listarEmpleados() throws Excepciones {
        
        sql = "SELECT * FROM empleado WHERE eliminado <> '1'";
        
        return executeQuery(sql, 8);
                
    }
    
}
