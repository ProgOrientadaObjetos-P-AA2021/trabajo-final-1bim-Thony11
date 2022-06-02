/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete01;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import paquete03.Barrio;
/**
 *
 * @author Lenovo
 */
public class EscrituraArchivoSecuencialBarrio {
    private String nombreArchivo;
    private ObjectOutputStream salida; // envía los datos a un archivo
    private Barrio registroBarrio;
    private ArrayList<Barrio> listaBarrios;
    
    public  EscrituraArchivoSecuencialBarrio(String nombreArc) {
        nombreArchivo = nombreArc;
        establecerListaBarrios();
        try // abre el archivo
        {
            salida = new ObjectOutputStream(
                    new FileOutputStream(nombreArchivo));
            // proceso para ingresar nuevamente los valores del archivo
            if (obtenerListaBarrios().size() > 0) {
                for (int i = 0; i < obtenerListaBarrios().size(); i++) {
                    establecerRegistroBarrio(obtenerListaBarrios().get(i));
                    establecerSalidaBarrio();
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
    public void establecerRegistroBarrio(Barrio p) {
        registroBarrio = p;
    }
    public void establecerSalidaBarrio() {
        try {
            salida.writeObject(registroBarrio); // envía el registro como salida
        } catch (IOException ex) {
            System.err.println("Error al escribir en el archivo.");
        }
    }
    public void establecerListaBarrios() {
        LecturaArchivoSecuencial l = new LecturaArchivoSecuencial(obtenerNombreArchivo());
        l.establecerListaBarrios();
        listaBarrios = l.obtenerListaBarrios();
    }
    public String obtenerNombreArchivo(){
        return nombreArchivo;
    }
    public ArrayList<Barrio> obtenerListaBarrios() {
        return listaBarrios;
    }
    
    public ObjectOutputStream obtenerSalidaBarrio(){
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