/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteseis;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 *
 * @author Lenovos
 */
public class EscrituraArchivoCasa {
    
    private String nombreArchivo;
    private ObjectOutputStream salida; 
    private Casa registroCasa;
    private ArrayList<Casa> listaCasas;

    public EscrituraArchivoCasa(String nombreArc) {
        nombreArchivo = nombreArc;
        establecerListaCasas(); // obtener los valores (objetos)
                                    // que tiene el archivo.
        try // abre el archivo
        {
            salida = new ObjectOutputStream(
                    new FileOutputStream(nombreArchivo));
            // proceso para ingresar nuevamente los valores del archivo
            if (obtenerListaCasas().size() > 0) {
                for (int i = 0; i < obtenerListaCasas().size(); i++) {
                    establecerRegistroCasa(obtenerListaCasas().get(i));
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

    public void establecerRegistroCasa(Casa p) {
        registroCasa = p;
    }

    public void establecerSalida() {
        try {
            salida.writeObject(registroCasa); // envía el registro como 
                                                  // objeto al archivo
        } catch (IOException ex) {
            System.err.println("Error al escribir en el archivo.");
        }
    }

    // en el atributo listaProfesores obtenemos los registros 
    // del archivo
    public void establecerListaCasas() {
        LecturaArchivoCasa l = new LecturaArchivoCasa(obtenerNombreArchivo());
        l.establecerCasas();
        listaCasas = l.obtenerCasas();
    }

    public String obtenerNombreArchivo(){
        return nombreArchivo;
    }
    
    public ArrayList<Casa> obtenerListaCasas() {
        return listaCasas;
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
