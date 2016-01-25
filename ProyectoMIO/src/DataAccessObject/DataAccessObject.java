/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessObject;

import Modelos.Excepciones;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * jesusaro
 */
public class DataAccessObject {
    
    protected final Fachada fachada;
    protected Connection conexion;
    protected Statement declaracion;
    protected ResultSet resultados;
    
    public DataAccessObject() {
        
        fachada = new Fachada();
        
    }
    
    protected void executeUpdate(String sql) throws Excepciones {
        
        try {
            
            conexion = fachada.conectar();
            declaracion = conexion.createStatement();
            int filasActualizadas = declaracion.executeUpdate(sql);
            fachada.desconectar(conexion);
        
        } catch (SQLException ex) {
            throw new Excepciones(ex.getMessage());
        }
        
    }
    
    protected ArrayList<Object[]> executeQuery(String sql, int columnas) throws Excepciones {
        
        try {
            
            ArrayList<Object[]> resultado = new ArrayList();
            conexion = fachada.conectar();
            declaracion = conexion.createStatement();
            resultados = declaracion.executeQuery(sql);
            
            while(resultados.next()) {
                
                Object[] temporal = new Object[columnas];
                
                for(int i=0; i<columnas; i++) {
                    
                    temporal[i] = (String) resultados.getString(i+1);
                    
                }
                
                resultado.add(temporal);
                
            }
            
            fachada.desconectar(conexion);
            
            return resultado;
            
        } catch (SQLException ex) {
            throw new Excepciones(ex.getMessage());   
        }
        
    }
    
}
