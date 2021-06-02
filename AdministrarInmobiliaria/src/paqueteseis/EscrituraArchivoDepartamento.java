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
 * @author Lenovo
 */
public class EscrituraArchivoDepartamento {
    
    private String nombreArchivo;
    private ObjectOutputStream salida; 
    private Departamento registroDepartamento;
    private ArrayList<Departamento> listaDepartamentos;

    public EscrituraArchivoDepartamento(String nombreArc) {
        nombreArchivo = nombreArc;
        establecerListaDepartamentos(); // obtener los valores (objetos)
                                    // que tiene el archivo.
        try // abre el archivo
        {
            salida = new ObjectOutputStream(
                    new FileOutputStream(nombreArchivo));
            // proceso para ingresar nuevamente los valores del archivo
            if (obtenerListaDepartamentos().size() > 0) {
                for (int i = 0; i < obtenerListaDepartamentos().size(); i++) {
                    establecerRegistroDepartamento(obtenerListaDepartamentos().get(i));
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

    public void establecerRegistroDepartamento(Departamento p) {
        registroDepartamento = p;
    }

    public void establecerSalida() {
        try {
            salida.writeObject(registroDepartamento); // envía el registro como 
                                                  // objeto al archivo
        } catch (IOException ex) {
            System.err.println("Error al escribir en el archivo.");
        }
    }

    // en el atributo listaProfesores obtenemos los registros 
    // del archivo
    public void establecerListaDepartamentos() {
        LecturaArchivoDepartamento l = new LecturaArchivoDepartamento(obtenerNombreArchivo());
        l.establecerDepartamentos();
        listaDepartamentos = l.obtenerDepartamentos();
    }

    public String obtenerNombreArchivo(){
        return nombreArchivo;
    }
    
    public ArrayList<Departamento> obtenerListaDepartamentos() {
        return listaDepartamentos;
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
