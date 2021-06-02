/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetedos;

import java.io.Serializable;

/**
 *
 * @author Lenovo
 */
public class Propietario implements Serializable{
    
    private String nombre;
    private String apellido;
    private String identificacion;
    
    public Propietario(String n,String a,String i){
        nombre = n;
        apellido = a;
        identificacion = i;
    }
    
    public void establecerNombre(String tipo){
        nombre = tipo;
    }
    public void establecerApellido(String tipo){
        apellido = tipo;
    }
    public void establecerIdentificacion(String tipo){
        identificacion = tipo;
    }
    
    public String obtenerNombre(){
        return nombre;
    }
    public String obtenerApellido(){
        return apellido;
    }
    public String obtenerIdentificacion(){
        return identificacion;
    }
}