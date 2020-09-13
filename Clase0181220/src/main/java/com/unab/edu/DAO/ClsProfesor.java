/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.DAO;

import com.unab.edu.conexiónmysql.ConexionBd;
import com.unab.edu.entidades.Profesor;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author CruzCalles
 */
public class ClsProfesor {
    ConexionBd classConectar = new ConexionBd();
    Connection conectar = classConectar.retornarConexion();
    
        public boolean LoguinProfesor(String usuario, String Pass) {
        ArrayList<Profesor> ListaUsuarios = new ArrayList<>();
        ArrayList<Profesor> ListarContra = new ArrayList<>();
        try {
            CallableStatement st = conectar.prepareCall("call SP_S_LoguinProfesor(?,?)");
            
            st.setString("PUsu", usuario);
            st.setString("PPass", Pass);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Profesor prof = new Profesor();
                prof.setUsuario(rs.getString("USU"));
                prof.setPass(rs.getString("PASS"));
                ListaUsuarios.add(prof);
            }
            String usuariodebasedatos = null;
            String passdebasededatos = null;
            for (var iterador : ListaUsuarios) {
                usuariodebasedatos = iterador.getUsuario();
                passdebasededatos = iterador.getPass();

            }

            CallableStatement st2 = conectar.prepareCall("call SP_S_CRIPsha2(?)");
            st2.setString("ScripPass2", Pass);
            ResultSet rs2 = st2.executeQuery();
            while (rs2.next()) {
                Profesor escrip = new Profesor();

                escrip.setPass(rs2.getNString("crip2"));
                ListarContra.add(escrip);
            }

            String passcrip = null;
            for (var iterador : ListarContra) {

                passcrip = iterador.getPass();

                Pass = passcrip;

            }
           
            
            if(usuariodebasedatos!=null &&passdebasededatos!=null ){
            if (usuariodebasedatos.equals(usuario) && passdebasededatos.equals(Pass)) {
                return true;
            }
            }
            conectar.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error" + e);
        }
        return false;
    }
        
  
    
}
