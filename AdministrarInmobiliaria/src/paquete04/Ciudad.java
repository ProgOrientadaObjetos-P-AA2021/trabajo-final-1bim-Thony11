/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete04;

import java.io.Serializable;

public class Ciudad implements Serializable{
    private String nombreCiudad;
    private String nombreProvincia;
    
    public Ciudad (String n,String c){
        nombreCiudad = n;
        nombreProvincia = c;
    }
    
    public void establecerNombreCuidad(String n){
        nombreCiudad = n;        
    }
    
    public void establecerNombreProvincia(String c){
        nombreProvincia = c;
    }
    
    public String obtenerNombreCuidad(){
        return nombreCiudad;
    }
    
    public String obtenerNombreProvincia(){
        return nombreProvincia;
    }
    
     @Override
    public String toString() {
        String ciudad = String.format("Nombre Ciudad: %s Nombre Provincia: %s\n",
                nombreCiudad, nombreProvincia);
        return ciudad;
    }   
}