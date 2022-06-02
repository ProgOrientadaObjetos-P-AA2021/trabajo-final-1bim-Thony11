/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquete01;

import java.util.Scanner;
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
public class Ejecutor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String nombreEdificio, ubicacionEdificio;
        Propietario p;
        Barrio b;
        Ciudad c;
        Constructora con;
        double precioMetroCuadrado, numeroMetrosCuadrados;
        int op, numeroCuartos;
        System.out.println("ADMINISTRADOR INMOBILIARIA");
        do {
            op = menu();
            switch (op) {
                case 1:
                    p = buscarPro();
                    b = buscarBarr();
                    c = buscarCiu();
                    con = buscarCons();
                    System.out.println("-------------------------------------");
                    System.out.println("Ingrese el precio por metro cuadrado: ");
                    precioMetroCuadrado = sc.nextDouble();
                    System.out.println("Ingrese el numero de metros cuadrados: ");
                    numeroMetrosCuadrados = sc.nextDouble();
                    System.out.println("Ingrese el numero de cuartos: ");
                    numeroCuartos = sc.nextInt();
                    Casa casa = new Casa(precioMetroCuadrado, numeroMetrosCuadrados, numeroCuartos, p, b, c, con);
                    casa.establecerCostoFinal();
                    EscrituraArchivoSecuencialCasa archivo = new EscrituraArchivoSecuencialCasa("datos/casas.dat");
                    archivo.establecerRegistroCasa(casa);
                    archivo.establecerSalidaCasa();
                    break;
                case 2:
                    p = buscarPro();
                    b = buscarBarr();
                    c = buscarCiu();
                    con = buscarCons();
                    System.out.println("-------------------------------------");
                    System.out.println("Ingrese el precio por metro cuadrado: ");
                    precioMetroCuadrado = sc.nextDouble();
                    System.out.println("Ingrese el numero de metros cuadrados: ");
                    numeroMetrosCuadrados = sc.nextDouble();
                    System.out.println("Ingrese valor alicuota mensual: ");
                    Double valorAlicuota = sc.nextDouble();
                    sc.nextLine();
                    System.out.println("Ingrese el nombre del edificio: ");
                    nombreEdificio = sc.nextLine();
                    System.out.println("Ingrese la ubicacion del edificio: ");
                    ubicacionEdificio = sc.nextLine();
                    Departamento departamento = new Departamento(p,precioMetroCuadrado,numeroMetrosCuadrados,valorAlicuota,b,c,nombreEdificio,ubicacionEdificio,con);
                    departamento.establecerValorFinal();
                    EscrituraArchivoSecuencialDepartamento archivo2 = new EscrituraArchivoSecuencialDepartamento("datos/departamentos.dat");
                    archivo2.establecerRegistroDepartamento(departamento);
                    archivo2.establecerSalidaDepartamento();
                    break;
                case 3:
                    System.out.println("-------------------------------------");
                    System.out.println("Ingrese nombres del propietario: ");
                    String nombresP = sc.nextLine();
                    System.out.println("Ingrese apellidos del propietario: ");
                    String apellidosP = sc.nextLine();
                    System.out.println("Ingrese identificacion del propietario: ");
                    String identificacionP = sc.nextLine();
                    p = new Propietario(nombresP, apellidosP, identificacionP);
                    EscrituraArchivoSecuencialPropietario archivo3 = new EscrituraArchivoSecuencialPropietario("datos/propietarios.dat");
                    System.out.println(p);
                    archivo3.establecerRegistroPropietario(p);
                    archivo3.establecerSalidaPropietario();
                    break;
                case 4:
                    System.out.println("-------------------------------------");
                    System.out.println("Ingrese nombre del barrio: ");
                    String nombre = sc.nextLine();
                    System.out.println("Ingrese referencia del barrio: ");
                    String referencia = sc.nextLine();
                    b = new Barrio(nombre, referencia);
                    EscrituraArchivoSecuencialBarrio archivo4 = new EscrituraArchivoSecuencialBarrio("datos/barrios.dat");
                    System.out.println(archivo4.toString());
                    archivo4.establecerRegistroBarrio(b);
                    archivo4.establecerSalidaBarrio();
                    break;
                case 5:
                    System.out.println("-------------------------------------");
                    System.out.println("Ingrese nombre de la ciudad: ");
                    String nombreCiudad = sc.nextLine();
                    System.out.println("Ingrese nombre de la provincia: ");
                    String provincia = sc.nextLine();
                    c = new Ciudad(nombreCiudad, provincia);
                    EscrituraArchivoSecuencialCiudad archivo5 = new EscrituraArchivoSecuencialCiudad("datos/ciudades.dat");
                    archivo5.establecerRegistroCiudad(c);
                    archivo5.establecerSalidaCiudad();
                    break;
                case 6:
                    System.out.println("-------------------------------------");
                    System.out.println("Ingrese nombre de la constructora: ");
                    String nombreConstructora = sc.nextLine();
                    System.out.println("Ingrese id de la constructora:");
                    String idConstructora = sc.nextLine();
                    con = new Constructora(nombreConstructora, idConstructora);
                    EscrituraArchivoSecuencialConstructora archivo6 = new EscrituraArchivoSecuencialConstructora("datos/constructoras.dat");
                    archivo6.establecerRegistroConstructora(con);
                    archivo6.establecerSalidaConstructora();
                    break;
                case 7:
                    do {                        
                        op = menu2();
                        mostrarListas(op);
                    } while (op!=0);
                    op = 7;
                    break;
                case 0:
                    System.out.println("¡GRACIAS VUELVA PRONTO! :)");
            }
        } while (op != 0);
    }

    public static int menu() {
        Scanner sc = new Scanner(System.in);
        int op;
        System.out.println("--------------------------------------");
        System.out.println("Ingresar nueva Casa              (1): ");
        System.out.println("Ingresar nuevo Departamento      (2): ");
        System.out.println("Ingresar nuevo Propietario       (3): ");
        System.out.println("Ingresar nuevo Barrio            (4): ");
        System.out.println("Ingresar nueva Ciudad            (5): ");
        System.out.println("Ingresar nueva Constructora      (6): ");
        System.out.println("Observar Listas                  (7): ");
        System.out.println("Salir del Programa               (0): ");
        System.out.println("--------------------------------------");
        op = sc.nextInt();
        return op;
    }

    public static int menu2() {
        Scanner sc = new Scanner(System.in);
        int op;
        System.out.println("---------------------------------------");
        System.out.println("Obervar Lista casas              (1): ");
        System.out.println("Obervar Lista departamentos      (2): ");
        System.out.println("Obervar Lista propietarios       (3): ");
        System.out.println("Obervar Lista barrios            (4): ");
        System.out.println("Obervar Lista ciudades           (5): ");
        System.out.println("Obervar Lista constructoras      (6): ");
        System.out.println("Regresar menu anterior:          (0): ");
        System.out.println("---------------------------------------");
        op = sc.nextInt();
        return op;
    }

    public static Propietario buscarPro() {
        Scanner sc = new Scanner(System.in);
        String identificacion;
        String nombres;
        String apellidos;
        String nombreArchivo = "datos/propietarios.dat";
        System.out.println("Ingrese identifiacion del propietario: ");
        identificacion = sc.nextLine();
        Propietario propietarioBuscar;
        LecturaArchivoSecuencial lectura = new LecturaArchivoSecuencial(nombreArchivo);
        lectura.establecerIdentificador(identificacion);
        lectura.establecerPropietarioBuscado();
        propietarioBuscar = lectura.obtenerPropietarioBuscado();
        if (propietarioBuscar != null) {
            System.out.printf("Propietario encontrado %s\n", propietarioBuscar);
            return propietarioBuscar;
        } else {
            System.out.println("Propietario no encontrado,ingrese los datos como NUEVO PROPIETARIO!!");
            System.out.println("Ingrese nombres del propietario: ");
            nombres = sc.nextLine();
            System.out.println("Ingrese apellidos del propietario: ");
            apellidos = sc.nextLine();
            System.out.println("Ingrese identificacion del propietario: ");
            identificacion = sc.nextLine();
            Propietario p = new Propietario(nombres, apellidos, identificacion);
            EscrituraArchivoSecuencialPropietario archivo = new EscrituraArchivoSecuencialPropietario(nombreArchivo);
            archivo.establecerRegistroPropietario(p);
            archivo.establecerSalidaPropietario();
            return p;
        }
    }

    public static Barrio buscarBarr() {
        Scanner sc = new Scanner(System.in);
        String nombreBarrio;
        String referencia;
        String nombreArchivo = "datos/barrios.dat";
        System.out.println("Ingrese nombre del barrio: ");
        nombreBarrio = sc.nextLine();
        Barrio barrioBuscar;
        LecturaArchivoSecuencial lectura = new LecturaArchivoSecuencial(nombreArchivo);
        lectura.establecerIdentificador(nombreBarrio);
        lectura.establecerBarrioBuscado();
        barrioBuscar = lectura.obtenerBarrioBuscado();
        if (barrioBuscar != null) {
            System.out.printf("Barrio encontrado %s\n", barrioBuscar);
            return barrioBuscar;
        } else {
            System.out.println("Barrio no encontrado, ingrese los datos como NUEVO BARRIO!!");
            System.out.println("Ingrese nombre del barrio: ");
            nombreBarrio = sc.nextLine();
            System.out.println("Ingrese referencia: ");
            referencia = sc.nextLine();
            Barrio b = new Barrio(nombreBarrio, referencia);
            EscrituraArchivoSecuencialBarrio archivo2 = new EscrituraArchivoSecuencialBarrio(nombreArchivo);
            archivo2.establecerRegistroBarrio(b);
            archivo2.establecerSalidaBarrio();
            return b;
        }
    }

    public static Ciudad buscarCiu() {
        Scanner sc = new Scanner(System.in);
        String nombreCiudad;
        String nombreProvincia;
        String nombreArchivo = "datos/ciudades.dat";
        System.out.println("Ingrese nombre ciudad: ");
        nombreCiudad = sc.nextLine();
        Ciudad ciudadBuscar;
        LecturaArchivoSecuencial lectura = new LecturaArchivoSecuencial(nombreArchivo);
        lectura.establecerIdentificador(nombreCiudad);
        lectura.establecerCiudadBuscado();
        ciudadBuscar = lectura.obtenerCiudadBuscado();
        if (ciudadBuscar != null) {
            System.out.printf("Ciudad encontrada %s\n", ciudadBuscar);
            return ciudadBuscar;
        } else {
            System.out.println("Ciudad no encontrada, ingrese los datos como NUEVA CIUDAD!!");
            System.out.println("Ingrese nombre de la ciudad: ");
            nombreCiudad = sc.nextLine();
            System.out.println("Ingrese nombre de la provincia: ");
            nombreProvincia = sc.nextLine();
            Ciudad c = new Ciudad(nombreCiudad, nombreProvincia);
            EscrituraArchivoSecuencialCiudad archivo = new EscrituraArchivoSecuencialCiudad(nombreArchivo);
            archivo.establecerRegistroCiudad(c);
            archivo.establecerSalidaCiudad();
            return c;
        }
    }

    public static Constructora buscarCons() {
        Scanner sc = new Scanner(System.in);
        String nombreConstructora;
        String idConstructora;
        String nombreArchivo = "datos/constructoras.dat";
        System.out.println("Ingrese id de la constructora: ");
        idConstructora = sc.nextLine();
        Constructora constructoraBuscar;
        LecturaArchivoSecuencial lectura = new LecturaArchivoSecuencial(nombreArchivo);
        lectura.establecerIdentificador(idConstructora);
        lectura.establecerConstructoraBuscado();
        constructoraBuscar = lectura.obtenerConstructoraBuscado();
        if (constructoraBuscar != null) {
            System.out.printf("Constructora encontrada %s\n", constructoraBuscar);
            return constructoraBuscar;
        } else {
            System.out.println("Constructora no encontrada, ingrese los datos como NUEVA CONSTRUCTORA!!");
            System.out.println("Ingrese nombre constructora: ");
            nombreConstructora = sc.nextLine();
            System.out.println("Ingrese id constructora: ");
            idConstructora = sc.nextLine();
            Constructora cons = new Constructora(nombreConstructora, idConstructora);
            EscrituraArchivoSecuencialConstructora archivo = new EscrituraArchivoSecuencialConstructora(nombreArchivo);
            archivo.establecerRegistroConstructora(cons);
            archivo.establecerSalidaConstructora();
            return cons;
        }
    }

    public static void mostrarListas(int op2) {
        switch (op2) {
            case 1:
                LecturaArchivoSecuencial lectura = new LecturaArchivoSecuencial("datos/casas.dat");
                lectura.establecerListaCasas();
                System.out.printf("%s", lectura.imprimirListaCasas());
                lectura.cerrarArchivo();
                break;
            case 2:
                LecturaArchivoSecuencial lectura2 = new LecturaArchivoSecuencial("datos/departamentos.dat");
                lectura2.establecerListaDepartamentos();
                System.out.printf("%s", lectura2.imprimirListaDepartamentos());
                lectura2.cerrarArchivo();
                break;
            case 3:
                LecturaArchivoSecuencial lectura3 = new LecturaArchivoSecuencial("datos/propietarios.dat");
                lectura3.establecerListaPropietarios();
                System.out.printf("%s", lectura3.imprimirListaPropietarios());
                lectura3.cerrarArchivo();
                break;
            case 4:
                LecturaArchivoSecuencial lectura4 = new LecturaArchivoSecuencial("datos/barrios.dat");
                lectura4.establecerListaBarrios();
                System.out.printf("%s", lectura4.imprimirListaBarrios());
                lectura4.cerrarArchivo();
                break;
            case 5:
                LecturaArchivoSecuencial lectura5 = new LecturaArchivoSecuencial("datos/ciudades.dat");
                lectura5.establecerListaCiudades();
                System.out.printf("%s", lectura5.imprimirListaCiudades());
                lectura5.cerrarArchivo();
                break;
            case 6:
                LecturaArchivoSecuencial lectura6 = new LecturaArchivoSecuencial("datos/constructoras.dat");
                lectura6.establecerListaConstructoras();
                System.out.printf("%s", lectura6.imprimirListaConstructoras());
                lectura6.cerrarArchivo();
                break;
        }
    }

}