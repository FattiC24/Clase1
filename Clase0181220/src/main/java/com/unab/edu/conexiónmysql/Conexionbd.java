/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.conexiónmysql;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author CruzCalles
 */
public class Conexionbd {
    
    private Connection conexion;
    
    public Conexionbd(){
        try {
            conexion = DriverManager.getConnection("jdbc:mysql://localhost","root","root");
            
            System.out.println("Conectado a la BD");
        } catch (Exception e) {
            System.out.println("Error de coneccion"+e);
        }
    }
    public Connection RetornarConexion(){
        return conexion;
        
    }
}
