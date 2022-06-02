/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package paquete01;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import java.util.ArrayList;
import paquete02.Propietario;
import paquete03.Barrio;
import paquete04.Ciudad;
import paquete05.Constructora;
import paquete06.Casa;
import paquete06.Departamento;

/**
 *
 * @author Lenovo
 */
public class LecturaArchivoSecuencial {

    private ObjectInputStream entrada;
    private ArrayList<Casa> casas;
    private ArrayList<Departamento> departamentos;
    private ArrayList<Propietario> propietarios;
    private ArrayList<Barrio> barrios;
    private ArrayList<Ciudad> ciudades;
    private ArrayList<Constructora> constructoras;
    private String nombreArchivo;
    private String identificador;
    private Propietario propietarioBuscado;
    private Ciudad ciudadBuscado;
    private Barrio barrioBuscado;
    private Constructora constructoraBuscado;

    public LecturaArchivoSecuencial(String n) {
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

    public void establecerListaCasas() {
        // 
        casas = new ArrayList<>();
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {

            while (true) {
                try {
                    Casa registro = (Casa) entrada.readObject();
                    casas.add(registro);
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

    public void establecerListaDepartamentos() {
        // 
        departamentos = new ArrayList<>();
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {

            while (true) {
                try {
                    Departamento registro = (Departamento) entrada.readObject();
                    departamentos.add(registro);
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

    public void establecerListaPropietarios() {
        // 
        propietarios = new ArrayList<>();
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {

            while (true) {
                try {
                    Propietario registro = (Propietario) entrada.readObject();
                    propietarios.add(registro);
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

    public void establecerListaBarrios() {
        // 
        System.out.println("lsita de marrios");
        barrios = new ArrayList<>();
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {
            System.out.println("el archivo existe");
            while (true) {
                try {
                    Barrio registro = (Barrio) entrada.readObject();
                    barrios.add(registro);
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

    public void establecerListaCiudades() {
        // 
        ciudades = new ArrayList<>();
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {

            while (true) {
                try {
                    Ciudad registro = (Ciudad) entrada.readObject();
                    ciudades.add(registro);
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

    public void establecerListaConstructoras() {
        // 
        constructoras = new ArrayList<>();
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {

            while (true) {
                try {
                    Constructora registro = (Constructora) entrada.readObject();
                    constructoras.add(registro);
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

    public ArrayList<Casa> obtenerListaCasas() {
        return casas;
    }

    public ArrayList<Departamento> obtenerListaDepartamento() {
        return departamentos;
    }

    public ArrayList<Propietario> obtenerListaPropietarios() {
        return propietarios;
    }

    public ArrayList<Barrio> obtenerListaBarrios() {
        return barrios;
    }

    public ArrayList<Ciudad> obtenerListaCiudades() {
        return ciudades;
    }

    public ArrayList<Constructora> obtenerListaConstructoras() {
        return constructoras;
    }

    public String obtenerNombreArchivo() {
        return nombreArchivo;
    }

    public void cerrarArchivo() {
        try // cierra el archivo y sale
        {
            if (entrada != null) {
                entrada.close();
            }
        } // fin de try
        catch (IOException ioException) {
            System.err.println("Error al cerrar el archivo.");
            System.exit(1);
        } // fin de catch
    } // 

    public void establecerIdentificador(String n) {
        identificador = n;
    }

    public void establecerPropietarioBuscado() {
        // 
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {

            while (true) {
                try {
                    Propietario registro = (Propietario) entrada.readObject();
                    if (registro.obtenerIdentificacion().equals(identificador)) {
                        propietarioBuscado = registro;
                        break;
                    }

                } catch (EOFException endOfFileException) {
                    return; // se llegó al fin del archivo
                    // se puede usar el break;
                    // System.err.println("Fin de archivo: " + endOfFileException);

                } catch (IOException ex) {
                    System.err.println("Error al leer el archivo: " + ex);
                } catch (ClassNotFoundException ex) {
                    System.err.println("No se pudo crear el objeto: " + ex);
                } catch (Exception ex) {
                    System.err.println("No hay datos en el archivo: " + ex);

                }
            }
        }
    }

    public void establecerBarrioBuscado() {
        // 
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {

            while (true) {
                try {
                    Barrio registro = (Barrio) entrada.readObject();
                    if (registro.obtenerNombreBarrio().equals(identificador)) {
                        barrioBuscado = registro;
                        break;
                    }

                } catch (EOFException endOfFileException) {
                    return; // se llegó al fin del archivo
                    // se puede usar el break;
                    // System.err.println("Fin de archivo: " + endOfFileException);

                } catch (IOException ex) {
                    System.err.println("Error al leer el archivo: " + ex);
                } catch (ClassNotFoundException ex) {
                    System.err.println("No se pudo crear el objeto: " + ex);
                } catch (Exception ex) {
                    System.err.println("No hay datos en el archivo: " + ex);

                }
            }
        }
    }

    public void establecerCiudadBuscado() {
        // 
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {

            while (true) {
                try {
                    Ciudad registro = (Ciudad) entrada.readObject();
                    if (registro.obtenerNombreCuidad().equals(identificador)) {
                        ciudadBuscado = registro;
                        break;
                    }

                } catch (EOFException endOfFileException) {
                    return; // se llegó al fin del archivo
                    // se puede usar el break;
                    // System.err.println("Fin de archivo: " + endOfFileException);

                } catch (IOException ex) {
                    System.err.println("Error al leer el archivo: " + ex);
                } catch (ClassNotFoundException ex) {
                    System.err.println("No se pudo crear el objeto: " + ex);
                } catch (Exception ex) {
                    System.err.println("No hay datos en el archivo: " + ex);

                }
            }
        }
    }

    public void establecerConstructoraBuscado() {
        // 
        File f = new File(obtenerNombreArchivo());
        if (f.exists()) {

            while (true) {
                try {
                    Constructora registro = (Constructora) entrada.readObject();
                    if (registro.obtenerIdEmpresa().equals(identificador)) {
                        constructoraBuscado = registro;
                        break;
                    }

                } catch (EOFException endOfFileException) {
                    return; // se llegó al fin del archivo
                    // se puede usar el break;
                    // System.err.println("Fin de archivo: " + endOfFileException);

                } catch (IOException ex) {
                    System.err.println("Error al leer el archivo: " + ex);
                } catch (ClassNotFoundException ex) {
                    System.err.println("No se pudo crear el objeto: " + ex);
                } catch (Exception ex) {
                    System.err.println("No hay datos en el archivo: " + ex);

                }
            }
        }
    }

    public String obtenerIdentificador() {
        return identificador;
    }

    public Propietario obtenerPropietarioBuscado() {
        return propietarioBuscado;
    }

    public Barrio obtenerBarrioBuscado() {
        return barrioBuscado;
    }

    public Ciudad obtenerCiudadBuscado() {
        return ciudadBuscado;
    }

    public Constructora obtenerConstructoraBuscado() {
        return constructoraBuscado;
    }

    public String imprimirListaCasas() {
        String cadena = "Casas:\n";
        for (int i = 0; i < casas.size(); i++) {
            Casa c = casas.get(i);
            cadena = String.format("%s(%d) Informacion casa:\n"
                    + "PROPIETARIO\n"
                    + "\tNombres: %s Apellidos: %s Identificacion: %s\n"
                    + "ESPECIFICACIONES\n"
                    + "\tPrecio metro cuadrado: %.2f Numero metros Cuadrados: %.2f Numero Cuartos: %d Costo final: %.2f\n"
                    + "BARRIO\n"
                    + "\tNombre barrio: %s Referencia: %s\n"
                    + "CIUDAD\n"
                    + "\tNombre Ciudad: %s Nombre Provincia: %s \n"
                    + "CONSTRUCTORA\n"
                    + "\tNombre Constructora: %s Id Empresa: %s\n", cadena,(i + 1),
                    c.obtenerPropietario().obtenerNombres(),c.obtenerPropietario().obtenerApellidos(), c.obtenerPropietario().obtenerIdentificacion(),
                    c.obtenerPrecioMetroCuadrado(), c.obtenerNumeroMetrosCuadrados(),c.obtenerNumeroCuartos(),c.obtenerCostoFinal(),
                    c.obtenerBarrio().obtenerNombreBarrio(), c.obtenerBarrio().obtenerReferencia(),
                    c.obtenerCiudad().obtenerNombreCuidad(), c.obtenerCiudad().obtenerNombreProvincia(),
                    c.obtenerConstructora().obtenerNombreConstructora(), c.obtenerConstructora().obtenerIdEmpresa());
        }
        return cadena;
    }

    public String imprimirListaDepartamentos() {
        String cadena = "Departamentos:\n";
        for (int i = 0; i < departamentos.size(); i++) {
            cadena = String.format("%s(%d) Informacion del Departamento\n"
                    + "PROPIETARIO\n"
                    + "\tNombres: %s Apellidos: %s Identificacion: %s\n"
                    + "ESPECIFICACIONES\n"
                    + "\tNombre Edificio: %s Ubicación Edificio: %s\n"
                    + "\tPrecio por metro cuadrado: %.2f Numero de metros cuadrados: %.2f\n"
                    + "\tValor Alícuota Mensual: %.2f Costo final: %.2f\n"
                    + "BARRIO\n"
                    + "\tNombre Barrio: %s Referencia%s\n"
                    + "CIUDAD\n"
                    + "\tNombre Ciudad: %s Nombre Provincia: %s\n"
                    + "CONSTRUCTORA\n"
                    + "\tNombre Constructora: %s ID Empresa: %s\n", cadena, i + 1,
                    departamentos.get(i).obtenerPropietario().obtenerNombres(), departamentos.get(i).obtenerPropietario().obtenerApellidos(), departamentos.get(i).obtenerPropietario().obtenerIdentificacion(),
                    departamentos.get(i).obtenerNombreEdificio(), departamentos.get(i).obtenerUbicacionEdificio(),
                    departamentos.get(i).obtenerPrecioMetroCuadrado(), departamentos.get(i).obtenerNumeroMetrosCuadrados(),
                    departamentos.get(i).obtenerAlicuotaMensual(), departamentos.get(i).obtenerValorFinal(),
                    departamentos.get(i).obtenerBarrio().obtenerNombreBarrio(), departamentos.get(i).obtenerBarrio().obtenerReferencia(),
                    departamentos.get(i).obtenerCiudad().obtenerNombreCuidad(), departamentos.get(i).obtenerCiudad().obtenerNombreProvincia(),
                    departamentos.get(i).obtenerConstructora().obtenerNombreConstructora(), departamentos.get(i).obtenerConstructora().obtenerIdEmpresa());
        }
        return cadena;
    }

    public String imprimirListaPropietarios() {
        String cadena = "Propietarios:\n";
        for (int i = 0; i < propietarios.size(); i++) {
            cadena = String.format("%s(%d) Nombres: %s Apellidos: %s Identificacion: %s\n", cadena, i + 1,
                    propietarios.get(i).obtenerNombres(), propietarios.get(i).obtenerApellidos(), propietarios.get(i).obtenerIdentificacion());
        }
        return cadena;
    }

    public String imprimirListaBarrios() {
        String cadena = "Barrios:\n";
        for (int i = 0; i < barrios.size(); i++) {
            cadena = String.format("%s(%d) Nombre barrio: %s Referencia: %s\n", cadena, i + 1, barrios.get(i).obtenerNombreBarrio(), barrios.get(i).obtenerReferencia());
        }
        return cadena;
    }

    public String imprimirListaCiudades() {
        String cadena = "Ciudades:\n";
        for (int i = 0; i < ciudades.size(); i++) {
            cadena = String.format("%s(%d) Nombre Ciudad: %s Nombre Provincia: %s\n", cadena, i + 1,
                    ciudades.get(i).obtenerNombreCuidad(), ciudades.get(i).obtenerNombreProvincia());
        }
        return cadena;
    }

    public String imprimirListaConstructoras() {
        String cadena = "Constructoras:\n";
        for (int i = 0; i < constructoras.size(); i++) {
            cadena = String.format("%s(%d) Nombre Constructora: %s Id Empresa: %s\n", cadena, i + 1,
                    constructoras.get(i).obtenerNombreConstructora(), constructoras.get(i).obtenerIdEmpresa());
        }
        return cadena;
    }

}