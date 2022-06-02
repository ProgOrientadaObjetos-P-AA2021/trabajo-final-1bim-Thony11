/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete06;

import java.io.Serializable;
import paquete02.Propietario;
import paquete03.Barrio;
import paquete04.Ciudad;
import paquete05.Constructora;

/**
 *
 * @author Lenovo
 */
public class Casa implements Serializable{
    private Propietario propietario;
    private double precioMetroCuadrado;
    private double numeroMetrosCuadrados;
    private double costoFinal;
    private Barrio barrio;
    private Ciudad ciudad;
    private int numeroCuartos;
    private Constructora constructora;
    
    public Casa(double preMeCuadrado, double numMeCuadrado,int numCuartos,Propietario p,Barrio b,Ciudad c,Constructora cons){
        precioMetroCuadrado = preMeCuadrado;
        numeroMetrosCuadrados = numMeCuadrado;
        numeroCuartos = numCuartos;
        propietario = p;
        barrio = b;
        ciudad = c;
        constructora = cons;
    }
    
    public void establecerPropietario(Propietario pro){
        propietario = pro;
    }
    
    public Propietario obtenerPropietario(){
        return propietario;
    }
    
    public void establecerPrecioMetroCuadrado(double preMeCuadrado){
        precioMetroCuadrado = preMeCuadrado;
    }
    public double obtenerPrecioMetroCuadrado(){
        return precioMetroCuadrado;
    }
    
    public void establecerNumeroMetrosCuadrados(double numMeCuadrados){
        numeroMetrosCuadrados = numMeCuadrados;
    }
    public double obtenerNumeroMetrosCuadrados(){
        return numeroMetrosCuadrados;
    }
    
    public void establecerCostoFinal(){
        costoFinal = precioMetroCuadrado * numeroMetrosCuadrados;
    }
    
    public double obtenerCostoFinal(){
        return costoFinal;
    }
    
    public void establecerBarrio(Barrio bar){
        barrio = bar;
    }
    public Barrio obtenerBarrio(){
        return barrio;
    }
    
    public void establecerCiudad(Ciudad ciu){
        ciudad = ciu;
    }
    public Ciudad obtenerCiudad(){
        return ciudad;
    }
    
    public void establecerNumeroCuartos(int numCua){
        numeroCuartos = numCua;
    }
    public int obtenerNumeroCuartos(){
        return numeroCuartos;
    }
    
    public void establecerConstructora(Constructora constru){
        constructora = constru;
    }
    public Constructora obtenerConstructora(){
        return constructora;
    }
    
    public String toString() {
        
        String cadena = String.format("Informacion casa:\n"
                + "PROPIETARIO\n"
                + "Nombres: %s Apellidos: %s Identificacion: %s\n"
                + "Precio metro cuadrado: %.2f Numero metros Cuadrados: %.2f Numero Cuartos: %d Costo final: %.2f\n"
                + "BARRIO\n"
                + "Nombre barrio: %s Referencia: %s\n"
                + "CIUDAD\n"
                + "Nombre Ciudad: %s Nombre Provincia: %s \n"
                + "CONSTRUCTORA\n"
                + "Nombre Constructora: %s Id Empresa: %s\n"
                ,propietario.obtenerNombres(),propietario.obtenerApellidos(),propietario.obtenerIdentificacion(),
                precioMetroCuadrado,numeroCuartos,numeroMetrosCuadrados,costoFinal,
                barrio.obtenerNombreBarrio(),barrio.obtenerReferencia(),
                ciudad.obtenerNombreCuidad(),ciudad.obtenerNombreProvincia(),
                constructora.obtenerNombreConstructora(),constructora.obtenerIdEmpresa());
        return cadena;
    }
}