package paquete01;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import paquete06.Casa;

public final class EscrituraArchivoSecuencialCasa {
    private String nombreArchivo;
    private ObjectOutputStream salida; // envía los datos a un archivo
    private Casa registroCasa;
    private ArrayList<Casa> listaCasas;
    
    public  EscrituraArchivoSecuencialCasa(String nombreArc) {
        nombreArchivo = nombreArc;
        establecerListaCasas();
        try // abre el archivo
        {
            salida = new ObjectOutputStream(
                    new FileOutputStream(nombreArchivo));
            // proceso para ingresar nuevamente los valores del archivo
            if (obtenerListaCasas().size() > 0) {
                for (int i = 0; i < obtenerListaCasas().size(); i++) {
                    establecerRegistroCasa(obtenerListaCasas().get(i));
                    establecerSalidaCasa();
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
    
    public void establecerRegistroCasa(Casa c) {
        registroCasa = c;
    }
    
    public void establecerSalidaCasa() {
        try {
            salida.writeObject(registroCasa); // envía el registro como salida
        } catch (IOException ex) {
            System.err.println("Error al escribir en el archivo.");
        }
    }
    
    public void establecerListaCasas() {
        LecturaArchivoSecuencial l = new LecturaArchivoSecuencial(obtenerNombreArchivo());
        l.establecerListaCasas();
        listaCasas = l.obtenerListaCasas();
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