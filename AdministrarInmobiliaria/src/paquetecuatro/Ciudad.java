/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetecuatro;

import java.io.Serializable;

/**
 *
 * @author Lenovo
 */
public class Ciudad implements Serializable{
    
    private String nomCiudad;
    private String nomProvincia;
    
    public Ciudad(String nomCiu,String nomPro){
        
        nomCiudad = nomCiu;
        nomProvincia = nomPro;
    }
    
    public void establecerNomCiudad(String tipo){
        nomCiudad = tipo;
    }
    public void establecerNomProvincia(String tipo){
        nomProvincia = tipo;
    }
    
    public String obtenerNomCiudad(){
        return nomCiudad;
    }
    public String obtenerNomProvincia(){
        return nomProvincia;
    }
}