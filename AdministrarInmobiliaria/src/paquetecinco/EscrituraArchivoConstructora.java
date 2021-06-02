/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetecinco;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Lenovo
 */
public class EscrituraArchivoConstructora {
    
    private String nombreArchivo;
    private ObjectOutputStream salida; 
    private Constructora registroConstructora;
    private ArrayList<Constructora> listaConstructoras;

    public EscrituraArchivoConstructora(String nombreArc) {
        nombreArchivo = nombreArc;
        establecerListaConstructoras(); // obtener los valores (objetos)
                                    // que tiene el archivo.
        try // abre el archivo
        {
            salida = new ObjectOutputStream(
                    new FileOutputStream(nombreArchivo));
            // proceso para ingresar nuevamente los valores del archivo
            if (obtenerListaConstructoras().size() > 0) {
                for (int i = 0; i < obtenerListaConstructoras().size(); i++) {
                    establecerRegistroConstructora(obtenerListaConstructoras().get(i));
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

    public void establecerRegistroConstructora(Constructora c) {
        registroConstructora = c;
    }

    public void establecerSalida() {
        try {
            salida.writeObject(registroConstructora); // envía el registro como 
                                                  // objeto al archivo
        } catch (IOException ex) {
            System.err.println("Error al escribir en el archivo.");
        }
    }

    // en el atributo listaProfesores obtenemos los registros 
    // del archivo
    public void establecerListaConstructoras() {
        LecturaArchivoConstructora l = new LecturaArchivoConstructora(obtenerNombreArchivo());
        l.establecerConstructoras();
        listaConstructoras= l.obtenerConstructoras();
    }

    public String obtenerNombreArchivo(){
        return nombreArchivo;
    }
    
    public ArrayList<Constructora> obtenerListaConstructoras() {
        return listaConstructoras;
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