/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete01;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import paquete02.Propietario;
/**
 *
 * @author Lenovo
 */
public class EscrituraArchivoSecuencialPropietario {
    private String nombreArchivo;
    private ObjectOutputStream salida; // envía los datos a un archivo
    private Propietario registroPropietario;
    private ArrayList<Propietario> listaPropietarios;
    
    public  EscrituraArchivoSecuencialPropietario(String nombreArc) {
        nombreArchivo = nombreArc;
        establecerListaPropietarios();
        try // abre el archivo
        {
            salida = new ObjectOutputStream(
                    new FileOutputStream(nombreArchivo));
            // proceso para ingresar nuevamente los valores del archivo
            if (obtenerListaPropietarios().size() > 0) {
                for (int i = 0; i < obtenerListaPropietarios().size(); i++) {
                    establecerRegistroPropietario(obtenerListaPropietarios().get(i));
                    establecerSalidaPropietario();
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
    public void establecerRegistroPropietario(Propietario p) {
        registroPropietario = p;
    }
    public void establecerSalidaPropietario() {
        try {
            salida.writeObject(registroPropietario); // envía el registro como salida
        } catch (IOException ex) {
            System.err.println("Error al escribir en el archivo.");
        }
    }
    public void establecerListaPropietarios() {
        LecturaArchivoSecuencial l = new LecturaArchivoSecuencial(obtenerNombreArchivo());
        l.establecerListaPropietarios();
        listaPropietarios = l.obtenerListaPropietarios();
    }
    public String obtenerNombreArchivo(){
        return nombreArchivo;
    }
    public ArrayList<Propietario> obtenerListaPropietarios() {
        return listaPropietarios;
    }
    
    public ObjectOutputStream obtenerSalidaPropietario(){
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