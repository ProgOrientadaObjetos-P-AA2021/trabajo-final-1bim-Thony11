/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetetres;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class EscribirArchivoUbicacion {
    
    private String nombreArchivo;
    private ObjectOutputStream salida; 
    private Ubicacion registroUbicacion;
    private ArrayList<Ubicacion> listaUbicaciones;

    public EscribirArchivoUbicacion(String nombreArc) {
        nombreArchivo = nombreArc;
        establecerListaUbicaciones(); // obtener los valores (objetos)
                                    // que tiene el archivo.
        try // abre el archivo
        {
            salida = new ObjectOutputStream(
                    new FileOutputStream(nombreArchivo));
            // proceso para ingresar nuevamente los valores del archivo
            if (obtenerListaUbicaciones().size() > 0) {
                for (int i = 0; i < obtenerListaUbicaciones().size(); i++) {
                    establecerRegistroUbicacion(obtenerListaUbicaciones().get(i));
                    establecerSalida();
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

    public void establecerRegistroUbicacion(Ubicacion u) {
        registroUbicacion = u;
    }

    public void establecerSalida() {
        try {
            salida.writeObject(registroUbicacion); // envía el registro como 
                                                  // objeto al archivo
        } catch (IOException ex) {
            System.err.println("Error al escribir en el archivo.");
        }
    }

    // en el atributo listaProfesores obtenemos los registros 
    // del archivo
    public void establecerListaUbicaciones() {
        LecturaArchivoUbicacion l = new LecturaArchivoUbicacion(obtenerNombreArchivo());
        l.establecerUbicaciones();
        listaUbicaciones= l.obtenerUbicaciones();
    }

    public String obtenerNombreArchivo(){
        return nombreArchivo;
    }
    
    public ArrayList<Ubicacion> obtenerListaUbicaciones() {
        return listaUbicaciones;
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
