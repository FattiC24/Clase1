/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.unab.edu.entidades;
import lombok.Data;
import lombok.EqualsAndHashCode;
/**
 *
 * @author CruzCalles
 */
@Data 
@EqualsAndHashCode(callSuper=false)
public class Profesor extends Persona{
    
    private int  idProfesor;
    private String Dui;
    private String Usuario;
    private String Pass;
}
