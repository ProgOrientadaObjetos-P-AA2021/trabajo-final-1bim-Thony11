/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteseis;
import java.io.Serializable;
import paquetedos.Propietario;
import paquetetres.Ubicacion;
import paquetecuatro.Ciudad;
import paquetecinco.Constructora;
/**
 *
 * @author Lenovo
 */
public class Casa implements Serializable {
   
    private Propietario[] po;
    private double precimCua;
    private double numMetros;
    private double costoFinal;
    private Ubicacion[] ubi;
    private Ciudad[] ciu;
    private int numCuartos;
    private Constructora[] cons;
    
    public Casa (Propietario[] p,Ubicacion[] u,Ciudad[] ci
            ,Constructora[] c){
        po = p;
        precimCua = 8.50;
        numMetros = 110;
        ubi = u;
        ciu = ci;
        numCuartos = 5;
        cons = c;
    }
    
    public void establecerPo(Propietario[] tipo){
        po = tipo;
    }
    public void establecerPreciomCua(double tipo){
        precimCua = tipo;
    }
    public void establecerNumMetros(double tipo){
        numMetros = tipo;
    }
    public void establecerCostoFinal(){
        
        costoFinal = numMetros * precimCua; 
    }
    public void establecerUbi(Ubicacion[] tipo){
        ubi = tipo;
    }
    public void establecerCiu(Ciudad[] tipo){
        ciu = tipo;
    }
    public void establecerNumCuartos(int tipo){
        numCuartos = tipo;
    }
    public void establecerCons(Constructora[] tipo){
        cons = tipo;
    }
    
    
    public Propietario[] obtenerPo(){
        return po;
    }
    public double obtenerPreciomCua(){
        return precimCua;
    }
    public double obtenerNumMetros(){
        return numMetros;
    }
    public double obtenerCostoFinal(){
        return costoFinal;
    }
    public Ubicacion[] obtenerUbi(){
        return ubi;
    }
    public Ciudad[] obtenerCiu(){
        return ciu ;
    }
    public int obtenerNumCuartos(){
        return numCuartos;
    }
    public Constructora[] obtenerCons(){
        return cons;
    } 
    @Override
    public String toString(){
        String cadena = "Datos de Casas\n";
        
        for (int i = 0; i < obtenerPo().length; i++) {
            cadena = String.format("%sNombre: %s\nApellido: %s\n"
                    + "Identificacion: %s\n", cadena, 
                  obtenerPo()[i].obtenerNombre(),
                  obtenerPo()[i].obtenerApellido(),
                  obtenerPo()[i].obtenerIdentificacion());
        }
        cadena = String.format("%sEl precio por el metro cuadrado es:%.2f\n", cadena, 
                obtenerPreciomCua());
        cadena = String.format("%sEl número de metros cuadrados es:%.2f\n", cadena, 
                obtenerNumMetros());
        cadena = String.format("%sEl número de cuartos es: %d\n", cadena, 
                obtenerNumCuartos());
        for (int i = 0; i < obtenerUbi().length; i++) {
            cadena = String.format("%sEl nombre del barrio es:%s\n"
                    + "La referencia es: %s\n", cadena, 
                obtenerUbi()[i].obtenerNomBarrio(),
                obtenerUbi()[i].obtenerReferencia());
        }
        for (int i = 0; i < obtenerCiu().length; i++) {
            cadena = String.format("%sEl nombre de la ciudad es: %s\n"
                    + "El nombre de la provincia es: %s\n", cadena, 
                obtenerCiu()[i].obtenerNomCiudad(),
                obtenerCiu()[i].obtenerNomProvincia());
        }
        for (int i = 0; i < obtenerCons().length; i++) {
            cadena = String.format("%sEl nombre de la constructora es: %s\n"
                    + "El ide es: %s\n", cadena, 
                obtenerCons()[i].obtenerNomConstructora(),
                obtenerCons()[i].obtenerIdeEmpresa());
        }
        cadena = String.format("%sEl costo final de la casa es:%.2f\n", cadena, 
                obtenerCostoFinal());
        return cadena;
    } 
}