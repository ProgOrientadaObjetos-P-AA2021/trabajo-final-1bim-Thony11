/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteuno;

import java.util.ArrayList;
import java.util.Scanner;
import paquetecinco.Constructora;
import paquetecuatro.Ciudad;
import paquetedos.Propietario;
import paqueteseis.*;
import paquetesiete.*;
import paquetetres.Ubicacion;

/**
 *
 * @author  Lenovo
 */
public class Ejecutor {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int opcion;
        int opcion2;
        boolean bandera;
        boolean busqueda;
        String sn;
        String idProp;
        String numeroC;
        String ciudad;
        String idEmp;

        do {
            System.out.println("Digite la opción:\n"
                    + "1 Para ingresar un Propietario\n"
                    + "2 Para ingresar una Ubicación\n"
                    + "3 Para ingresar una Ciudad\n"
                    + "4 Para ingresar una Constructora\n"
                    + "5 Para ingresar una Casa\n"
                    + "6 Para ingresar un Departamento\n"
                    + "7 Para comprobar si está registrado un Propietario\n"
                    + "8 Para comprobar si está registrada una Ubicacion\n"
                    + "9 Para comprobar si está registrada una Ciudad\n"
                    + "10 Para comprobar si está registrada una Constructora\n"
                    + "11 Para mostrar la lista de todos los Propietarios\n"
                    + "12 Para mostrar la lista de todas las Ubicaciones\n"
                    + "13 Para mostrar la lista de todas las Ciudades\n"
                    + "14 Para mostrar la lista de todas las Constructoras\n"
                    + "15 Para mostrar la lista de todas las Casas\n"
                    + "16 Para mostrar la lista de todos los Departamentos: ");
            opcion = entrada.nextInt();
            entrada.nextLine();
            if ((opcion >= 1) && (opcion <= 16)) {
                switch (opcion) {
                    case 1:
                        System.out.println("Ingrese la identificación del Propietario: ");
                        idProp = entrada.nextLine();
                        ingresarPropietario(idProp);
                        break;

                    case 2:
                        System.out.println("Ingrese el número de Casa: ");
                        numeroC = entrada.nextLine();
                        ingresarUbicacion(numeroC);
                        break;

                    case 3:
                        System.out.println("Ingrese el nombre de la Ciudad: ");
                        ciudad = entrada.nextLine();
                        ingresarCiudad(ciudad);
                        break;

                    case 4:
                        System.out.println("Ingrese el ID de la empresa: ");
                        idEmp = entrada.nextLine();
                        ingresarConstructora(idEmp);
                        break;

                    case 5:
                        ingresarCasa();
                        break;

                    case 6:
                        ingresarDepartamento();
                        break;

                    case 7:
                        System.out.println("Ingresar identificación del "
                                + "propietario a buscar:");
                        sn = entrada.nextLine();
                        busqueda = buscarPropietario(sn);
                        if (busqueda) {
                            System.out.println("El Propietario SI está "
                                    + "registrado.");
                        } else {
                            System.out.println("El Propietario NO está "
                                    + "registrado.");
                        }
                        break;

                    case 8:
                        System.out.println("Ingresar el numero de casa:");
                        sn = entrada.nextLine();
                        busqueda = buscarUbicacion(sn);
                        if (busqueda) {
                            System.out.println("La Ubicación SI está "
                                    + "registrada.");
                        } else {
                            System.out.println("La Ubicación NO está "
                                    + "registrada.");
                        }
                        break;

                    case 9:
                        System.out.println("Ingresar el nombre de la ciudad:");
                        sn = entrada.nextLine();
                        sn = sn.toLowerCase();
                        busqueda = buscarCiudad(sn);
                        if (busqueda) {
                            System.out.println("La Ciudad SI está "
                                    + "registrado.");
                        } else {
                            System.out.println("La Ciudad NO está "
                                    + "registrado.");
                        }
                        break;

                    case 10:
                        System.out.println("Ingresar el ID de la empresa a "
                                + "buscar:");
                        sn = entrada.nextLine();
                        busqueda = buscarConstructora(sn);
                        if (busqueda) {
                            System.out.println("La Constructora SI está "
                                    + "registrado.");
                        } else {
                            System.out.println("La Constructora NO está "
                                    + "registrado.");
                        }
                        break;

                    case 11:
                        mostrarPropietarios();
                        break;

                    case 12:
                        mostrarUbicaciones();
                        break;

                    case 13:
                        mostrarCiudades();
                        break;

                    case 14:
                        mostrarConstructoras();
                        break;

                    case 15:
                        mostrarCasas();
                        break;

                    case 16:
                        mostrarDepartamentos();
                        break;
                }
                System.out.println("Digite -0- Si desea realizar una "
                        + "nueva acción.\nY si no necesita realizar otra "
                        + "acción digite cualquier número excepto el 0");
                opcion2 = entrada.nextInt();
                entrada.nextLine();
                if (opcion2 == 0) {
                    bandera = true;
                } else {
                    bandera = false;
                }
            } else {
                System.out.println("Opción incorrecta, ingrese de nuevo su"
                        + " opción.");
                bandera = true;
            }
        } while (bandera);//falso para salir

    }

    public static void ingresarPropietario(String idProp) {
        Scanner entrada = new Scanner(System.in);
        String nombreProp;
        String apellidoProp;
        String nombreArchivo = "propietarios.txt";
        boolean bandera = true;
        LeerPropietario lectura = new LeerPropietario(nombreArchivo);
        lectura.establecerListaPropietario();
        ArrayList<Propietario> lista = lectura.obtenerListaPropietario();
        for (int i = 0; i < lista.size(); i++) {
            Propietario p = lista.get(i);
            if (p.obtenerIdentificacion().equals(idProp)) {
                System.out.println("El propietario ya está registrado.\n" + p);
                bandera = false;
            }
        }
        if (bandera) {
            System.out.println("Ingrese el Nombre del Propietario: ");
            nombreProp = entrada.nextLine();
            System.out.println("Ingrese el Apellido del Propietario: ");
            apellidoProp = entrada.nextLine();
            Propietario propiet = new Propietario(nombreProp, apellidoProp, idProp);
            EscribirPropietario archivo = new EscribirPropietario(nombreArchivo);
            archivo.establecerRegistro(propiet);
            archivo.establecerSalida();
            archivo.cerrarArchivo();
        }
    }

    public static void ingresarUbicacion(String numeroC) {
        Scanner entrada = new Scanner(System.in);
        String nombreB;
        String referencia;
        String nombreArchivo = "ubicaciones.txt";
        boolean bandera = true;
        LeerUbicacion lectura = new LeerUbicacion(nombreArchivo);
        lectura.establecerListaUbicacion();
        ArrayList<Ubicacion> lista = lectura.obtenerListaUbicacion();
        for (int i = 0; i < lista.size(); i++) {
            Ubicacion u = lista.get(i);
            if (u.obtenerNumeroCasa().equals(numeroC)) {
                System.out.println("La Ubicación ya está registrada.\n" + u);
                bandera = false;
            }
        }
        if (bandera) {
            System.out.println("Ingrese el nombre del Barrio: ");
            nombreB = entrada.nextLine();
            System.out.println("Ingrese la referencia: ");
            referencia = entrada.nextLine();
            Ubicacion ubic = new Ubicacion(nombreB, referencia, numeroC);
            EscribirUbicacion archivo = new EscribirUbicacion(nombreArchivo);
            archivo.establecerRegistro(ubic);
            archivo.establecerSalida();
            archivo.cerrarArchivo();
        }
    }

    public static void ingresarCiudad(String ciudad) {
        Scanner entrada = new Scanner(System.in);
        String ci;
        String ci2;
        String provincia;
        String nombreArchivo = "ciudades.txt";
        boolean bandera = true;

        ci = ciudad.toLowerCase();
        LeerCiudad lectura = new LeerCiudad(nombreArchivo);
        lectura.establecerListaCiudad();
        ArrayList<Ciudad> lista = lectura.obtenerListaCiudad();
        for (int i = 0; i < lista.size(); i++) {
            Ciudad c = lista.get(i);
            ci2 = c.obtenerNombreCiudad().toLowerCase();
            if (ci2.equals(ci)) {
                System.out.println("La Ciudad ya está registrada.\n" + c);
                bandera = false;
            }
        }
        if (bandera) {
            System.out.println("Ingrese el nombre de Provincia: ");
            provincia = entrada.nextLine();
            Ciudad ciud = new Ciudad(ciudad, provincia);
            EscribirCiudad archivo = new EscribirCiudad(nombreArchivo);
            archivo.establecerRegistro(ciud);
            archivo.establecerSalida();
            archivo.cerrarArchivo();
        }
    }

    public static void ingresarConstructora(String idEmp) {
        Scanner entrada = new Scanner(System.in);
        String nombreCons;
        String nombreArchivo = "constructoras.txt";
        boolean bandera = true;
        LeerConstructora lectura = new LeerConstructora(nombreArchivo);
        lectura.establecerListaConstructora();
        ArrayList<Constructora> lista = lectura.obtenerListaConstructora();
        for (int i = 0; i < lista.size(); i++) {
            Constructora c = lista.get(i);
            if (c.obtenerIdEmpresa().equals(idEmp)) {
                System.out.println("La Ubicación ya está registrada.\n" + c);
                bandera = false;
            }
        }
        if (bandera) {
            System.out.println("Ingrese el nombre de la Constructora: ");
            nombreCons = entrada.nextLine();
            Constructora constr = new Constructora(nombreCons, idEmp);
            EscribirConstructora archivo = new EscribirConstructora(nombreArchivo);
            archivo.establecerRegistro(constr);
            archivo.establecerSalida();
            archivo.cerrarArchivo();
        }
    }

    public static void ingresarCasa() {
        Scanner entrada = new Scanner(System.in);
        String nombreArchivo = "casas.txt";
        String nombreArchivo1 = "propietarios.txt";
        String nombreArchivo2 = "ubicaciones.txt";
        String nombreArchivo3 = "ciudades.txt";
        String nombreArchivo4 = "constructoras.txt";
        String nombreProp = "";
        String apellidoProp = "";
        String idProp;
        double precioM2;
        int numeroM2;
        String nombreB = "";
        String referencia = "";
        String numeroCa;
        String ciudad;
        String provincia = "";
        int nCuartos;
        String nombreEmp = "";
        String idEmp;
        boolean buscar;
        System.out.println("Ingrese la identificación del Propietario: ");
        idProp = entrada.nextLine();
        // buscar propietario
        buscar = buscarPropietario(idProp);
        if (buscar) {
        } else {
            ingresarPropietario(idProp);
        }
        LeerPropietario lectura = new LeerPropietario(nombreArchivo1);
        lectura.establecerListaPropietario();
        ArrayList<Propietario> lista = lectura.obtenerListaPropietario();
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).obtenerIdentificacion().equals(idProp)) {
                nombreProp = lista.get(i).obtenerNombre();
                apellidoProp = lista.get(i).obtenerApellido();
            }
        }
        Propietario propDef = new Propietario(nombreProp, apellidoProp, idProp);
        System.out.println("Ingrese el precio por metro cuadrado: ");
        precioM2 = entrada.nextDouble();
        System.out.println("Ingrese el número de metros cuadrados: ");
        numeroM2 = entrada.nextInt();
        entrada.nextLine();
        // buscar ubicación
        System.out.println("Ingrese el número de Casa: ");
        numeroCa = entrada.nextLine();
        buscar = buscarUbicacion(numeroCa);
        if (buscar) {
        } else {
            ingresarUbicacion(numeroCa);
        }
        LeerUbicacion lectura2 = new LeerUbicacion(nombreArchivo2);
        lectura2.establecerListaUbicacion();
        ArrayList<Ubicacion> lista2 = lectura2.obtenerListaUbicacion();
        for (int i = 0; i < lista2.size(); i++) {
            if (lista2.get(i).obtenerNumeroCasa().equals(numeroCa)) {
                nombreB = lista2.get(i).obtenerNombreBarrio();
                referencia = lista2.get(i).obtenerReferencia();
            }
        }
        Ubicacion ubiDef = new Ubicacion(nombreB, referencia, numeroCa);
        //Buscar ciudad
        System.out.println("Ingrese el nombre de la ciudad: ");
        ciudad = entrada.nextLine();
        buscar = buscarCiudad(ciudad);
        if (buscar) {
        } else {
            ingresarCiudad(ciudad);
        }
        LeerCiudad lectura3 = new LeerCiudad(nombreArchivo3);
        lectura3.establecerListaCiudad();
        ArrayList<Ciudad> lista3 = lectura3.obtenerListaCiudad();
        for (int i = 0; i < lista3.size(); i++) {
            if (lista3.get(i).obtenerNombreCiudad().equals(ciudad)) {
                provincia = lista3.get(i).obtenerNombreProvincia();
            }
        }
        Ciudad ciuDef = new Ciudad(ciudad, provincia);
        System.out.println("Ingrese el número de cuartos: ");
        nCuartos = entrada.nextInt();
        entrada.nextLine();
        //Buscar Constructora
        System.out.println("Ingrese el ID de la constructora: ");
        idEmp = entrada.nextLine();
        buscar = buscarConstructora(idEmp);
        if (buscar) {
        } else {
            ingresarConstructora(idEmp);
        }
        LeerConstructora lectura4 = new LeerConstructora(nombreArchivo4);
        lectura4.establecerListaConstructora();
        ArrayList<Constructora> lista4 = lectura4.obtenerListaConstructora();
        for (int i = 0; i < lista4.size(); i++) {
            if (lista4.get(i).obtenerIdEmpresa().equals(idEmp)) {
                nombreEmp = lista4.get(i).obtenerNombreConstructora();
            }
        }
        Constructora constDef = new Constructora(nombreEmp, idEmp);
        Casa casa1 = new Casa(propDef, precioM2, numeroM2, ubiDef,
                ciuDef, nCuartos, constDef);
        casa1.establecerCostoFinal();
        EscribirCasa archivo = new EscribirCasa(nombreArchivo);
        archivo.establecerRegistro(casa1);
        archivo.establecerSalida();
        archivo.cerrarArchivo();
        
    }

    public static void ingresarDepartamento() {
        Scanner entrada = new Scanner(System.in);
        String nombreArchivo = "departamentos.txt";
        String nombreArchivo1 = "propietarios.txt";
        String nombreArchivo2 = "ubicaciones.txt";
        String nombreArchivo3 = "ciudades.txt";
        String nombreArchivo4 = "constructoras.txt";
        String nombreProp = "";
        String apellidoProp = "";
        String idProp;
        double precioM2;
        int numeroM2;
        String nombreB = "";
        String referencia = "";
        String numeroCa;
        String ciudad;
        String provincia = "";
        String nombreEmp = "";
        String idEmp;
        boolean buscar;
        double alicuotaMensual;
        String nomEdi;
        String ubiDepEdi;
        System.out.println("Ingrese la identificación del Propietario: ");
        idProp = entrada.nextLine();
        // buscar propietario
        buscar = buscarPropietario(idProp);
        if (buscar) {
        } else {
            ingresarPropietario(idProp);
        }
        LeerPropietario lectura = new LeerPropietario(nombreArchivo1);
        lectura.establecerListaPropietario();
        ArrayList<Propietario> lista = lectura.obtenerListaPropietario();
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).obtenerIdentificacion().equals(idProp)) {
                nombreProp = lista.get(i).obtenerNombre();
                apellidoProp = lista.get(i).obtenerApellido();
            }
        }
        Propietario propDef = new Propietario(nombreProp, apellidoProp, idProp);
        System.out.println("Ingrese el precio por metro cuadrado: ");
        precioM2 = entrada.nextDouble();
        System.out.println("Ingrese el número de metros cuadrados: ");
        numeroM2 = entrada.nextInt();
        System.out.println("Ingrese el valor de la alicuota mensual: ");
        alicuotaMensual = entrada.nextDouble();
        entrada.nextLine();
        // buscar ubicación
        System.out.println("Ingrese el número de Casa: ");
        numeroCa = entrada.nextLine();
        buscar = buscarUbicacion(numeroCa);
        if (buscar) {
        } else {
            ingresarUbicacion(numeroCa);
        }
        LeerUbicacion lectura2 = new LeerUbicacion(nombreArchivo2);
        lectura2.establecerListaUbicacion();
        ArrayList<Ubicacion> lista2 = lectura2.obtenerListaUbicacion();
        for (int i = 0; i < lista2.size(); i++) {
            if (lista2.get(i).obtenerNumeroCasa().equals(numeroCa)) {
                nombreB = lista2.get(i).obtenerNombreBarrio();
                referencia = lista2.get(i).obtenerReferencia();
            }
        }
        Ubicacion ubiDef = new Ubicacion(nombreB, referencia, numeroCa);
        
        //Buscar ciudad
        System.out.println("Ingrese el nombre de la ciudad: ");
        ciudad = entrada.nextLine();
        buscar = buscarCiudad(ciudad);
        if (buscar) {
        } else {
            ingresarCiudad(ciudad);
        }
        LeerCiudad lectura3 = new LeerCiudad(nombreArchivo3);
        lectura3.establecerListaCiudad();
        ArrayList<Ciudad> lista3 = lectura3.obtenerListaCiudad();
        for (int i = 0; i < lista3.size(); i++) {
            if (lista3.get(i).obtenerNombreCiudad().equals(ciudad)) {
                provincia = lista3.get(i).obtenerNombreProvincia();
            }
        }
        Ciudad ciuDef = new Ciudad(ciudad, provincia);
        System.out.println("Ingrese el nombre del edificio: ");
        nomEdi = entrada.nextLine();
        System.out.println("Ingrese la ubicacion del departamento en el "
                + "edificio: ");
        ubiDepEdi = entrada.nextLine();
        //Buscar Constructora
        System.out.println("Ingrese el ID de la constructora: ");
        idEmp = entrada.nextLine();
        buscar = buscarConstructora(idEmp);
        if (buscar) {
        } else {
            ingresarConstructora(idEmp);
        }
        LeerConstructora lectura4 = new LeerConstructora(nombreArchivo4);
        lectura4.establecerListaConstructora();
        ArrayList<Constructora> lista4 = lectura4.obtenerListaConstructora();
        for (int i = 0; i < lista4.size(); i++) {
            if (lista4.get(i).obtenerIdEmpresa().equals(idEmp)) {
                nombreEmp = lista4.get(i).obtenerNombreConstructora();
            }
        }
        Constructora constDef = new Constructora(nombreEmp, idEmp);
        Departamento dep1 = new Departamento(propDef, precioM2, numeroM2, 
                alicuotaMensual, ubiDef, ciuDef, nomEdi, ubiDepEdi, constDef);
        dep1.establecerCostoFinal();
        EscribirDepartamento archivo = new EscribirDepartamento(nombreArchivo);
        archivo.establecerRegistro(dep1);
        archivo.establecerSalida();
        archivo.cerrarArchivo();
    }

    public static boolean buscarPropietario(String n) {
        boolean buscar = false;
        String nombreArchivo = "propietarios.txt";
        LeerPropietario lectura = new LeerPropietario(nombreArchivo);
        lectura.establecerListaPropietario();
        ArrayList<Propietario> lista = lectura.obtenerListaPropietario();
        for (int i = 0; i < lista.size(); i++) {
            Propietario p = lista.get(i);
            if (p.obtenerIdentificacion().equals(n)) {
                buscar = true;
                // System.out.println(p);
            }
        }
        return buscar;
    }

    public static boolean buscarUbicacion(String n) {
        boolean buscar = false;
        String nombreArchivo = "ubicaciones.txt";
        LeerUbicacion lectura = new LeerUbicacion(nombreArchivo);
        lectura.establecerListaUbicacion();
        ArrayList<Ubicacion> lista = lectura.obtenerListaUbicacion();
        for (int i = 0; i < lista.size(); i++) {
            Ubicacion u = lista.get(i);
            if (u.obtenerNumeroCasa().equals(n)) {
                buscar = true;
                // System.out.println(p);
            }
        }
        return buscar;
    }

    public static boolean buscarCiudad(String n) {
        boolean buscar = false;
        n = n.toLowerCase();
        String m;
        String nombreArchivo = "ciudades.txt";
        LeerCiudad lectura = new LeerCiudad(nombreArchivo);
        lectura.establecerListaCiudad();
        ArrayList<Ciudad> lista = lectura.obtenerListaCiudad();
        for (int i = 0; i < lista.size(); i++) {
            Ciudad c = lista.get(i);
            m = c.obtenerNombreCiudad().toLowerCase();
            if (m.equals(n)) {
                buscar = true;
                // System.out.println(p);
            }
        }
        return buscar;
    }

    public static boolean buscarConstructora(String n) {
        boolean buscar = false;
        String nombreArchivo = "constructoras.txt";
        LeerConstructora lectura = new LeerConstructora(nombreArchivo);
        lectura.establecerListaConstructora();
        ArrayList<Constructora> lista = lectura.obtenerListaConstructora();
        for (int i = 0; i < lista.size(); i++) {
            Constructora c = lista.get(i);
            if (c.obtenerIdEmpresa().equals(n)) {
                buscar = true;
                // System.out.println(p);
            }
        }
        return buscar;
    }

    public static void mostrarPropietarios() {
        String nombreArchivo = "propietarios.txt";
        LeerPropietario lectura = new LeerPropietario(nombreArchivo);
        lectura.establecerListaPropietario();
        System.out.println(lectura);
    }

    public static void mostrarUbicaciones() {
        String nombreArchivo = "ubicaciones.txt";
        LeerUbicacion lectura = new LeerUbicacion(nombreArchivo);
        lectura.establecerListaUbicacion();
        System.out.println(lectura);
    }

    public static void mostrarCiudades() {
        String nombreArchivo = "ciudades.txt";
        LeerCiudad lectura = new LeerCiudad(nombreArchivo);
        lectura.establecerListaCiudad();
        System.out.println(lectura);
    }

    public static void mostrarConstructoras() {
        String nombreArchivo = "constructoras.txt";
        LeerConstructora lectura = new LeerConstructora(nombreArchivo);
        lectura.establecerListaConstructora();
        System.out.println(lectura);
    }

    public static void mostrarCasas() {
        String nombreArchivo = "casas.txt";
        LeerCasa lectura = new LeerCasa(nombreArchivo);
        lectura.establecerListaCasa();
        System.out.println(lectura);
    }

    public static void mostrarDepartamentos() {
        String nombreArchivo = "departamentos.txt";
        LeerDepartamento lectura = new LeerDepartamento(nombreArchivo);
        lectura.establecerListaDepartamento();
        System.out.println(lectura);
    }

}