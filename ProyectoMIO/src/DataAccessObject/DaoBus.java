/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DataAccessObject;

import Modelos.Excepciones;
import Tablas.Bus;

/**
 *
 * @author jesusaro
 */
public class DaoBus extends DataAccessObject {
    
    private String sql;
    
    public DaoBus() {
        
        super();
        
    }
    
    public void guardarBus(Bus bus) throws Excepciones {
        
        sql = "INSERT INTO bus VALUES ('"
                + bus.getPlaca() + "', '"
                + bus.getModelo() + "', '"
                + bus.getMarca() + "', '"
                + bus.getCapacidad() + "', '"
                + bus.getTipo() + "', '"
                + bus.getParadaRuta() + "', '"
                + bus.getNombreRuta() + "');";
        
        executeUpdate(sql);
        
    }
    
    public void modificarBus(Bus bus) throws Excepciones {
        
        sql = "UPDATE bus SET "
                + "modelo = '" + bus.getModelo() + "', "
                + "marca = '" + bus.getMarca() + "', "
                + "capacidad = '" + bus.getCapacidad() + "', "
                + "tipo = '" + bus.getTipo() + "', "
                + "parada_ruta = '" + bus.getParadaRuta() + "', '"
                + "nombre_ruta = '" + bus.getNombreRuta() + "' "
                + "WHERE placa_bus = '" + bus.getPlaca() + "';";
        
        executeUpdate(sql);
        
    }
    
}
