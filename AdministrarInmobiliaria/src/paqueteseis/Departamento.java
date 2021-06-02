/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteseis;

import java.io.Serializable;
import java.util.Scanner;
import paquetedos.Propietario;
import paquetetres.Ubicacion;
import paquetecuatro.Ciudad;
import paquetecinco.Constructora;
/**
 *
 * @author Lenovo
 */
public class Departamento implements Serializable {
    
    private Propietario[] poDepar;
    private double precioMetroCua;
    private double numMetrosCua;
    private double valorMensual;
    private double cosFinal;
    private double precioDepa;
    private Ubicacion[] ubiDepar;
    private Ciudad[] ciuDepa;
    private String[] nomEdificio;
    private String[] UbiDeparEdi;
    private Constructora[] consDepa;

    
    Scanner leer = new Scanner(System.in);
    
    public Departamento (Propietario[] pD,
            Ubicacion[] uD,Ciudad[] ciuD,
            Constructora[] cD, String[] nom,String[] ubiD){
        
        poDepar = pD;
        precioMetroCua = 10.15;
        numMetrosCua = 75;
        valorMensual = 500;
        precioDepa = 1200;
        ubiDepar = uD;
        ciuDepa = ciuD;
        consDepa = cD;
        nomEdificio = nom;
        UbiDeparEdi = ubiD;
    }
    
    public void establecerPoDepar(Propietario[] tipo){
        poDepar = tipo;
    }
    public void establecerPrecioMetroCua(double tipo){
        precioDepa = tipo;
    }
    public void establecerNumMetrosCua(double tipo){
        numMetrosCua = tipo;
    }
    public void establecerValorMensual(double tipo){
        valorMensual = tipo;
    }
    public void establecerCosFinal(){
        cosFinal = (numMetrosCua * precioMetroCua)+(valorMensual*12);
    }
    public void establecerPrecioDepa(double tipo){
        precioDepa = tipo;
    }
    public void establecerUbiDepar(Ubicacion[] tipo){
        ubiDepar = tipo;
    }
    public void establecerCiuDepa(Ciudad[] tipo){
        ciuDepa = tipo;
    }
    public void establecerNomEdificio(String[] tipo){
        nomEdificio = tipo;
    }
    public void establecerUbiDeparEdi(String[] tipo){
        UbiDeparEdi = tipo;
    }   
    public void establecerConsDepa(Constructora[] tipo){
        consDepa = tipo;
    }
    
    
    public Propietario[] obtenerPoDepar(){
        return poDepar;
    }
    public double obtenerPrecioMetroCua(){
        return precioMetroCua;
    }
    public double obtenerNumMetrosCua(){
        return numMetrosCua;
    }
    public  double obtenerValorMensual(){
        return valorMensual;
    }
    public double obtenerCosFinal(){
        return cosFinal;
    }
    public double obtenerPrecioDepa(){
        return precioDepa;
    }
    public Ubicacion[] obtenerUbiDepar(){
        return ubiDepar;
    }
    public Ciudad[] obtenerCiuDepa(){
        return ciuDepa ;
    }
    public String[] obtenerNomEdificio(){
        return nomEdificio;
    }
    public String[] obtenerUbiDeparEdi(){
        return UbiDeparEdi;
    }
    public Constructora[] obtenerCons(){
        return consDepa;
    }
    
    @Override
    public String toString(){
        String cadena = "Datos de los Departamentos\n";
        
        for (int i = 0; i < obtenerPoDepar().length; i++) {
            cadena = String.format("%sNombre: %s\nApellido: %s\nIdentificación: %s\n", cadena, 
                  obtenerPoDepar()[i].obtenerNombre(),
                  obtenerPoDepar()[i].obtenerApellido(),
                  obtenerPoDepar()[i].obtenerIdentificacion());
        }
        cadena = String.format("%sEl precio por el metro cuadrado es:%.2f\n", cadena, 
                obtenerPrecioMetroCua());
        cadena = String.format("%sEl número de metros cuadrados es:%.2f\n", cadena, 
                obtenerNumMetrosCua());
        cadena = String.format("%sEl valor alícuota mensual es: %.2f\n", cadena, 
                obtenerValorMensual());
        cadena = String.format("%sEl precio es:%.2f\n", cadena, 
                obtenerPrecioDepa());
        
        for (int i = 0; i < obtenerNomEdificio().length; i++) {
            cadena = String.format("%sNombre del edificio es: %s\n", cadena, 
                  obtenerNomEdificio()[i]);
        }
        for (int i = 0; i < obtenerUbiDeparEdi().length; i++) {
            cadena = String.format("%sUbicación del departamento es: %s\n", cadena, 
                  obtenerUbiDeparEdi()[i]);
        }
        
        for (int i = 0; i < obtenerUbiDepar().length; i++) {
            cadena = String.format("%sEl número de casa es: %s\n"
                    + "El nombre del barrio es: %s\n"
                    + "La referencia es: %s\n", cadena,
                obtenerUbiDepar()[i].obtenerCasa(),
                obtenerUbiDepar()[i].obtenerNomBarrio(),
                obtenerUbiDepar()[i].obtenerReferencia());
        }
        for (int i = 0; i < obtenerCiuDepa().length; i++) {
            cadena = String.format("%sEl nombre de la ciudad es: %s\n"
                    + "El nombre de la provincia es: %s\n", cadena, 
                obtenerCiuDepa()[i].obtenerNomCiudad(),
                obtenerCiuDepa()[i].obtenerNomProvincia());
        }
        for (int i = 0; i < obtenerCons().length; i++) {
            cadena = String.format("%sEl nombre de la constructora es: %s\n"
                    + "El ide es: %s\n", cadena, 
                obtenerCons()[i].obtenerNomConstructora(),
                obtenerCons()[i].obtenerIdeEmpresa());
        }
        cadena = String.format("%sEl costo final del departamento es:%.2f\n", cadena, 
                obtenerCosFinal());
        return cadena;
    } 
}
