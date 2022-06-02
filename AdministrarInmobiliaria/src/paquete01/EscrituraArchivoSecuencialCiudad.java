/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete01;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import paquete04.Ciudad;
import paquete06.Departamento;
/**
 *
 * @author Lenovo
 */
public class EscrituraArchivoSecuencialCiudad {
    private String nombreArchivo;
    private ObjectOutputStream salida; // envía los datos a un archivo
    private Ciudad registroCiudad;
    private ArrayList<Ciudad> listaCiudades;
    
    public  EscrituraArchivoSecuencialCiudad(String nombreArc) {
        nombreArchivo = nombreArc;
        establecerListaCiudades();
        try // abre el archivo
        {
            salida = new ObjectOutputStream(
                    new FileOutputStream(nombreArchivo));
            // proceso para ingresar nuevamente los valores del archivo
            if (obtenerListaCiudades().size() > 0) {
                for (int i = 0; i < obtenerListaCiudades().size(); i++) {
                    establecerRegistroCiudad(obtenerListaCiudades().get(i));
                    establecerSalidaCiudad();
                }
            }
        } // fin de try
        catch (IOException ioException) {
            System.err.println("Error al abrir el archivo.");
        } // fin de catch
    }
    public void establecerNombreArchivo(String n){
        nombreArchivo = n;
    }
    // agrega registros al archivo
    public void establecerRegistroCiudad(Ciudad c) {
        registroCiudad = c;
    }
    public void establecerSalidaCiudad() {
        try {
            salida.writeObject(registroCiudad); // envía el registro como salida
        } catch (IOException ex) {
            System.err.println("Error al escribir en el archivo.");
        }
    }
    public void establecerListaCiudades() {
        LecturaArchivoSecuencial l = new LecturaArchivoSecuencial(obtenerNombreArchivo());
        l.establecerListaCiudades();
        listaCiudades = l.obtenerListaCiudades();
    }
    public String obtenerNombreArchivo(){
        return nombreArchivo;
    }
    public ArrayList<Ciudad> obtenerListaCiudades() {
        return listaCiudades;
    }
    
    public ObjectOutputStream obtenerSalida(){
        return salida;
    }
    public void cerrarArchivo() {
        try // cierra el archivo
        {
            if (salida != null) {
                salida.close();
            }
        } // fin de try
        catch (IOException ioException) {
            System.err.println("Error al cerrar el archivo.");
            
        } // fin de catch
    } 
}