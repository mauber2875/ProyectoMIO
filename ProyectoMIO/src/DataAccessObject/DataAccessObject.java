/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessObject;

import Modelos.Excepciones;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author jesusaro
 */
public class DataAccessObject {
    
    protected final Fachada fachada;
    protected Connection conexion;
    protected Statement consulta;
    protected ResultSet resultado;
    
    public DataAccessObject() {
        
        fachada = new Fachada();
        
    }
    
    protected void executeUpdate() throws Excepciones {
        
        conexion = fachada.;
        
        
    }
    
}
