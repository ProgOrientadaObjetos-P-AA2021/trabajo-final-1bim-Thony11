/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetetres;

import java.io.Serializable;
/**
 *
 * @author Lenovo
 */
public class Ubicacion implements Serializable {
    
    private String nomBarrio;
    private String referencia;
    private String casa;
    
    public Ubicacion(String numCasa,String nom, String refe){
        casa = numCasa;
        nomBarrio = nom;
        referencia = refe;
    }
    
    public void establecerNomBarrio(String tipo){
        nomBarrio = tipo;
    }
    public void establecerReferencia(String tipo){
        referencia = tipo;
    }
    public void establecerCasa(String tipo){
        casa = tipo;
    }
    
    public String obtenerNomBarrio(){
        return nomBarrio;
    }
    public String obtenerReferencia(){
        return referencia;
    }
    public String obtenerCasa(){
        return casa;
    }
}