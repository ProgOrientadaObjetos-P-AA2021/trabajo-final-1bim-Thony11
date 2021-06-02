/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetelectura;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import paqueteseis.Casa;

/**
 *
 * @author Lenovo
 */
public class LeerCasa {

    private ObjectInputStream entrada;
    private ArrayList<Casa> listaCasa;
    private String nombreArchivo;

    public LeerCasa(String n) {
        nombreArchivo = n;
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {
            try // abre el archivo
            {
                entrada = new ObjectInputStream(
                        new FileInputStream(n));
            } // fin de try
            catch (IOException ioException) {
                System.err.println("Error al abrir el archivo.");

            } // fin de catch
        }
    }

    public void establecerNombreArchivo(String n) {
        nombreArchivo = n;
    }

    public void establecerListaCasa() {
        // 
        listaCasa = new ArrayList<>();
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {

            while (true) {
                try {
                    Casa registro = (Casa) entrada.readObject();
                    listaCasa.add(registro);
                } catch (EOFException endOfFileException) {
                    return; // se llegó al fin del archivo

                } catch (IOException ex) {
                    System.err.println("Error al leer el archivo: " + ex);
                } catch (ClassNotFoundException ex) {
                    System.err.println("No se pudo crear el objeto: " + ex);
                } catch (Exception ex) {
                    // System.err.println("No hay datos en el archivo: " + ex);
                    break;
                }
            }
        }

    }

    public ArrayList<Casa> obtenerListaCasa() {
        return listaCasa;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    @Override
    public String toString() {
        String cadena = "LISTA DE CASAS\n\n";
        for (int i = 0; i < obtenerListaCasa().size(); i++) {
            Casa c = obtenerListaCasa().get(i);
            cadena = String.format("%sCasa %d:\nPropietario: %s %s\n"
                    + "Identificación: %s\nPrecio por metro2: %.2f\n"
                    + "Número de metros2: %d\nCosto final: %.2f\n"
                    + "Ubicacion:\n - Barrio: %s\n - Referencia: %s\n"
                    + " - Numero de casa: %s\nCiudad: %s\nProvincia: %s\n"
                    + "Número de cuartos: %d\nInformación de la constructora:"
                    + "\n - Nombre: %s\n - Id de la empresa: %s\n\n",
                    cadena, i + 1,
                    c.obtenerPersonaPropietaria().obtenerNombre(),
                    c.obtenerPersonaPropietaria().obtenerApellido(),
                    c.obtenerPersonaPropietaria().obtenerIdentificacion(),
                    c.obtenerPrecioMetro2(), c.obtenerNumeroMetro2(),
                    c.obtenerCostoFinal(),
                    c.obtenerUbicacionCasa().obtenerNombreBarrio(),
                    c.obtenerUbicacionCasa().obtenerReferencia(),
                    c.obtenerUbicacionCasa().obtenerNumeroCasa(),
                    c.obtenerCiudadCasa().obtenerNombreCiudad(),
                    c.obtenerCiudadCasa().obtenerNombreProvincia(),
                    c.obtenerNumeroCuartos(),
                    c.obtenerEmpresaConstructora().obtenerNombreConstructora(),
                    c.obtenerEmpresaConstructora().obtenerIdEmpresa());
        }
        return cadena;
    }

    // cierra el archivo y termina la aplicación
    public void cerrarArchivo() {
        try // cierra el archivo y sale
        {
            if (entrada != null) {
                entrada.close();
            }
            System.exit(0);
        } // fin de try
        catch (IOException ioException) {
            System.err.println("Error al cerrar el archivo.");
            System.exit(1);
        } // fin de catch
    } // fin del método cerrarArchivo

}