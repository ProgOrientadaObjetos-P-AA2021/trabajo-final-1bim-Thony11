/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete05;

import java.io.Serializable;

/**
 *
 * @author lenovo
 */
public class Constructora implements Serializable{
    private String nombreConstructora;
    private String idEmpresa;
    
    public Constructora(String n,String m){
        nombreConstructora = n;
        idEmpresa = m;
    }
    
    public void establecerNombreConstructora(String n){
        nombreConstructora = n;
    }
    
    public void establecerIdEmpresa(String m){
        idEmpresa = m;
    }
    
    public String obtenerNombreConstructora(){
        return nombreConstructora;
    }
    
    public String obtenerIdEmpresa(){
        return idEmpresa;
    }
    
    @Override
    public String toString() {
        String constructora = String.format("Nombre Constructora: %s Id Empresa: %s\n",
                nombreConstructora, idEmpresa);
        return constructora;
    }   
}