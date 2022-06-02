/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete01;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import paquete05.Constructora;
/**
 *
 * @author Lenovo
 */
public class EscrituraArchivoSecuencialConstructora {
    private String nombreArchivo;
    private ObjectOutputStream salida; // envía los datos a un archivo
    private Constructora registroConstructora;
    private ArrayList<Constructora> listaConstructoras;
    
    public  EscrituraArchivoSecuencialConstructora(String nombreArc) {
        nombreArchivo = nombreArc;
        establecerListaConstructoras();
        try // abre el archivo
        {
            salida = new ObjectOutputStream(
                    new FileOutputStream(nombreArchivo));
            // proceso para ingresar nuevamente los valores del archivo
            if (obtenerListaConstructoras().size() > 0) {
                for (int i = 0; i < obtenerListaConstructoras().size(); i++) {
                    establecerRegistroConstructora(obtenerListaConstructoras().get(i));
                    establecerSalidaConstructora();
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
    public void establecerRegistroConstructora(Constructora c) {
        registroConstructora = c;
    }
    public void establecerSalidaConstructora() {
        try {
            salida.writeObject(registroConstructora); // envía el registro como salida
        } catch (IOException ex) {
            System.err.println("Error al escribir en el archivo.");
        }
    }
    public void establecerListaConstructoras() {
        LecturaArchivoSecuencial l = new LecturaArchivoSecuencial(obtenerNombreArchivo());
        l.establecerListaConstructoras();
        listaConstructoras = l.obtenerListaConstructoras();
    }
    public String obtenerNombreArchivo(){
        return nombreArchivo;
    }
    public ArrayList<Constructora> obtenerListaConstructoras() {
        return listaConstructoras;
    }
    
    public ObjectOutputStream obtenerSalidaConstructora(){
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