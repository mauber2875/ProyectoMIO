/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessObject;

import Modelos.Excepciones;
import Tablas.Conduce;
import java.util.ArrayList;

/**
 *
 * @author jesusaro
 */
public class DaoConduce extends DataAccessObject {
    
    private String sql;
    
    public DaoConduce() {
        
        super();
        
    }
    
    public void guardarTurno(Conduce conduce) throws Excepciones {
        
        sql = "INSERT INTO conduce VALUES ('"
                + conduce.getCedulaEmpleado() + "', '"
                + conduce.getPlacaBus() + "', '"
                + conduce.getFecha() + "', '"
                + conduce.getHoraEntrada() + "', '"
                + conduce.getHoraSalida() + "', '0');";
        
        executeUpdate(sql);
        
    }
    
    public ArrayList<Object[]> buscarTurno(String cedula) throws Excepciones {
        
        sql = "SELECT * FROM conduce WHERE cedula_empleado = '" + cedula + "' AND eliminado <> '1';";
        
        return executeQuery(sql, 5);
        
    }
    
    public void modificarTurno(Conduce conduce) throws Excepciones {
        
        sql = "UPDATE conduce SET "
                + "fecha = '" + conduce.getFecha() + "', "
                + "horaEntrada = '" + conduce.getHoraEntrada() + "', "
                + "horaSalida = '" + conduce.getHoraSalida() + "';";
        
        executeUpdate(sql);
        
    }   
        
    public void eliminarTurno(String cedula) throws Excepciones {
        
        sql = "UPDATE conduce SET eliminado = '1' WHERE cedula_empleado = '" + cedula + "';";
        
        executeUpdate(sql);
        
    }  
        
    public ArrayList<Object[]> listarTurnos() throws Excepciones {
        
        sql = "SELECT * FROM conduce WHERE eliminado <> '1'";
        
        return executeQuery(sql, 5);
                
    }
    
}
