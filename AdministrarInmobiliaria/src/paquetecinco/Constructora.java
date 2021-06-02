/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetecinco;

import java.io.Serializable;

/**
 *
 * @author Lenovo
 */
public class Constructora implements Serializable {
    
    private String nomConstructora;
    private String ideEmpresa;
    
    public Constructora(String nomCons,String ide){
        nomConstructora = nomCons;
        ideEmpresa = ide;
    }
    
    public void establecerNomConstructora(String tipo){
        nomConstructora = tipo;
    }
    public void establecerIdeEmpresa(String tipo){
        ideEmpresa = tipo;
    }
    
    public String obtenerNomConstructora(){
        return nomConstructora;
    }
    public String obtenerIdeEmpresa(){
        return ideEmpresa;
    }
}