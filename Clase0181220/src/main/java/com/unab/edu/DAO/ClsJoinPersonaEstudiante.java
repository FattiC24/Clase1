/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.DAO;

import com.unab.edu.conexiónmysql.ConexionBd;
import com.unab.edu.entidades.Estudiante;
import java.sql.*;
import java.sql.Connection;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author CruzCalles
 */
public class ClsJoinPersonaEstudiante {
    
    ConexionBd cn = new ConexionBd();
    Connection con = cn.retornarConexion();
    
    public ArrayList<Estudiante> MostrarJoinEstudiantePersona(){
        
    ArrayList <Estudiante> lista =  new ArrayList();
        try {
            CallableStatement st = con.prepareCall("Call SP_S_JoinPersonaEstudiante");
            
            ResultSet rs = st.executeQuery();
            while (rs.next ()){
                Estudiante es = new Estudiante();
                es.setNombre(rs.getString("Nombre"));
                es.setApellido(rs.getString("Apellido"));
                es.setMatricula(rs.getInt("Matricula"));
                
                lista.add(es);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, lista);
        } 
        return lista;
    }
}
