/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessObject;

import Modelos.Excepciones;
import java.sql.Connection;
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
    
    public Connection conexion() throws Excepciones {
        
        Class.forName("org.postgresql.Driver");
        conexion = DriverManager
        
    }
    
    
}
