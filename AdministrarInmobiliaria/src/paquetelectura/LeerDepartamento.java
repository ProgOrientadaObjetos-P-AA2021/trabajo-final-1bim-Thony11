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
import paqueteseis.Departamento;

/**
 *
 * @author Lenovo
 */
public class LeerDepartamento {

    private ObjectInputStream entrada;
    private ArrayList<Departamento> listaDepartamento;
    private String nombreArchivo;

    public LeerDepartamento(String n) {
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

    public void establecerListaDepartamento() {
        // 
        listaDepartamento = new ArrayList<>();
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {

            while (true) {
                try {
                    Departamento registro = (Departamento) entrada.readObject();
                    listaDepartamento.add(registro);
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

    public ArrayList<Departamento> obtenerListaDepartamento() {
        return listaDepartamento;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    @Override
    public String toString() {
        String cadena = "LISTA DE DEPARTAMENTOS\n\n";
        for (int i = 0; i < obtenerListaDepartamento().size(); i++) {
            Departamento d = obtenerListaDepartamento().get(i);
            cadena = String.format("%sDepartamento %d:\nPropietario: %s %s\n"
                    + "Identificación: %s\nPrecio por metro2: %.2f\n"
                    + "Número de metros2: %d\n"
                    + "Valor de la alicuóta mensual: %.2f\nCosto final: %.2f\n"
                    + "Ubicacion:\n - Barrio: %s\n - Referencia: %s\n"
                    + " - Numero de casa: %s\nCiudad: %s\nProvincia: %s\n"
                    + "Nombre del edificio: %s\n"
                    + "Ubicación del edificio: %s\n"
                    + "Información de la constructora:"
                    + "\n - Nombre: %s\n - Id de la empresa: %s\n\n",
                    cadena, i + 1,
                    d.obtenerPersonaPropietaria().obtenerNombre(),
                    d.obtenerPersonaPropietaria().obtenerApellido(),
                    d.obtenerPersonaPropietaria().obtenerIdentificacion(),
                    d.obtenerPrecioMetro2(), d.obtenerNumeroMetro2(),
                    d.obtenerAlicuotaMensual(), d.obtenerCostoFinal(),
                    d.obtenerUbicacionDepartamento().obtenerNombreBarrio(),
                    d.obtenerUbicacionDepartamento().obtenerReferencia(),
                    d.obtenerUbicacionDepartamento().obtenerNumeroCasa(),
                    d.obtenerCiudadDepartamento().obtenerNombreCiudad(),
                    d.obtenerCiudadDepartamento().obtenerNombreProvincia(),
                    d.obtenerNombreEdificio(),
                    d.obtenerUbicacionDepartamentoEdificio(),
                    d.obtenerEmpresaConstructora().obtenerNombreConstructora(),
                    d.obtenerEmpresaConstructora().obtenerIdEmpresa());
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
