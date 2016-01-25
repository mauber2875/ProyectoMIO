/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessObject;

import Modelos.Excepciones;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author jesusaro
 */
public class Fachada {
    
    private final String url;
    private final String usuario;
    private final String contraseña; 
    private Connection conexion;
    
    public Fachada() {
        
        //Conexión a la base de datos JESUSARO de la Universidad 
        url = "jdbc:postgresql://pgsql:5432/jesusaro";
        usuario = "jesusaro";
        contraseña = "jesusaro";
        
    }
    
    public Connection conectar() throws Excepciones {
        
        try {
            
            Class.forName("org.postgresql.Driver");
            conexion = DriverManager.getConnection(url, usuario, contraseña);

            return conexion;
        
        } catch (SQLException ex) {
            System.out.println("No se pudo conectar a la BD: " + ex.getMessage());
            throw new Excepciones("No se pudo conectar a la BD: " + ex.getMessage());
        } catch (ClassNotFoundException ex) {
            throw new Excepciones("No se pudo conectar a la BD: " + ex.getMessage());
        }
        
    }
    
    public void desconectar(Connection conexion) throws SQLException {
        
        try {
            
            conexion.close();
            
        } catch (SQLException ex) {
            System.out.println("No se pudo desconectar de la BD: " + ex.getMessage());
        }
        
    }    
    
}
