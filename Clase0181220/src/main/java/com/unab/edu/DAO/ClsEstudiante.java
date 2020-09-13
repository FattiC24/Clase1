/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.DAO;
import com.unab.edu.conexiónmysql.ConexionBd;
import com.unab.edu.entidades.Estudiante;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author CruzCalles
 */
public class ClsEstudiante {
    ConexionBd classConectar = new ConexionBd();
    Connection conectar = classConectar.retornarConexion();
    
    

    public boolean LoguinEstudiante(String usuario, String Pass) {
        ArrayList<Estudiante> ListaUsuarios = new ArrayList<>();
        ArrayList<Estudiante> ListarContra = new ArrayList<>();
        try {
            CallableStatement st = conectar.prepareCall("call SP_S_LoguinEstudiante(?,?)");
            
            st.setString("PUsu", usuario);
            st.setString("PPass", Pass);
            ResultSet rs = st.executeQuery();
            while (rs.next()) {
                Estudiante es = new Estudiante();
                es.setUsu(rs.getString("USU"));
                es.setPass(rs.getString("PASS"));
                ListaUsuarios.add(es);
            }
            String usuariodebasedatos = null;
            String passdebasededatos = null;
            for (var iterador : ListaUsuarios) {
                usuariodebasedatos = iterador.getUsu();
                passdebasededatos = iterador.getPass();

            }

            CallableStatement st2 = conectar.prepareCall("call SP_S_CRIP(?)");
            st2.setString("ScripPass", Pass);
            ResultSet rs2 = st2.executeQuery();
            while (rs2.next()) {
                Estudiante escrip = new Estudiante();

                escrip.setPass(rs2.getNString("crip"));
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
    public ArrayList<Estudiante> MostrarEstudiante() {
        ArrayList<Estudiante> estudiantes = new ArrayList<>();

        try {
            CallableStatement Statement = conectar.prepareCall("call SP_S_ESTUDIANTE");
            ResultSet resultadoConsulta = Statement.executeQuery();
            while (resultadoConsulta.next()) {
                Estudiante estudiante = new Estudiante();
                estudiante.setIdEstudiante(resultadoConsulta.getInt("idEstudiante"));
                estudiante.setMatricula(resultadoConsulta.getInt("matricula"));
                estudiante.setIdPersona(resultadoConsulta.getInt("idPersona"));
                estudiante.setNombre(resultadoConsulta.getString("Nombre"));
                estudiante.setUsu(resultadoConsulta.getString("USU"));
                estudiante.setPass(resultadoConsulta.getString("PASS"));
                estudiante.setNie(resultadoConsulta.getInt("NIE"));
                
                
                estudiantes.add(estudiante);
            }
             conectar.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        return estudiantes;
    }
    public void AgregarEstudiante(Estudiante est) {

        try {
            CallableStatement Statement = conectar.prepareCall("call SP_I_ESTUDIANTE (?,?,?,?,?)");
            
            Statement.setInt("PMatricula", est.getMatricula());
            Statement.setInt("PIdPersona", est.getIdPersona());
            Statement.setString("PUsu", est.getUsu());
            Statement.setString("PPass", est.getPass());
            Statement.setInt("PNie", est.getNie());
            Statement.execute();
            JOptionPane.showMessageDialog(null, "¡Ingresado con Exito!");
            conectar.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }
    
    public void BorrarEstudiante(Estudiante est) {

        try {
            CallableStatement Statement = conectar.prepareCall("call SP_D_ESTUDIANTE(?)");
            Statement.setInt("PIdEstudiante", est.getIdEstudiante());
            Statement.execute();
            JOptionPane.showMessageDialog(null, "¡Datos Eliminados!");
            conectar.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    public void ActualizarEstudiante(Estudiante est) {

        try {
            CallableStatement Statement = conectar.prepareCall("call SP_U_ESTUDIANTE(?,?,?,?,?,?)");
            Statement.setInt("PIdEstudiante", est.getIdEstudiante());
            Statement.setInt("PMatricula", est.getMatricula());
            Statement.setInt("PIdPersona", est.getIdPersona());
            Statement.setString("PUsu", est.getUsu());
            Statement.setString("PPass", est.getPass());
            Statement.setInt("PNie", est.getNie());
            
            Statement.execute();
            JOptionPane.showMessageDialog(null, "Actualización de datos");
            conectar.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
}
