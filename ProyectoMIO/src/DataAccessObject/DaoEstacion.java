/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessObject;

import Modelos.Excepciones;
import Tablas.Estacion;
import java.util.ArrayList;

/**
 *
 * @author jesusaro
 */
public class DaoEstacion extends DataAccessObject {
    
    private String sql;
    
    public DaoEstacion() {
        
        super();
        
    }
    
    public void guardarEstacion(Estacion estacion) throws Excepciones {
        
        sql = "INSERT INTO estacion VALUES ('"
                + estacion.getNombre() + "', '"
                + estacion.getDireccion() + "', '"
                + estacion.getCedulaDirector() + "', '"
                + estacion.getParadaRuta() + "', '"
                + estacion.getNombreRuta() + "');";
        
        executeUpdate(sql);
        
    }
    
    public ArrayList<Object[]> buscarEstacion(String nombre) throws Excepciones {
        
        sql = "SELECT * FROM estacion WHERE nombre_estacion = '" + nombre + "' AND eliminada <> '1';";
        
        return executeQuery(sql, 6);
        
    }
    
    public void modificarEstacion(Estacion estacion) throws Excepciones {
        
        sql = "UPDATE estacion SET "
                + "direccion = '" + estacion.getDireccion() + "', "
                + "cedula_empleado = '" + estacion.getCedulaDirector() + "', "
                + "parada_ruta = '" + estacion.getParadaRuta() + "', "
                + "nombre_ruta = '" + estacion.getNombreRuta() + "' "
                + "WHERE nombre_estacion = '" + estacion.getNombre() + "';";
        
        executeUpdate(sql);
        
    }   
        
    public void eliminarEstacion(String nombre) throws Excepciones {
        
        sql = "UPDATE estacion SET eliminado = '1' WHERE nombre_estacion = '" + nombre + "';";
        
        executeUpdate(sql);
        
    }  
        
    public ArrayList<Object[]> listarEstaciones() throws Excepciones {
        
        sql = "SELECT * FROM estacion WHERE eliminado <> '1'";
        
        return executeQuery(sql, 6);
                
    }
    
}
