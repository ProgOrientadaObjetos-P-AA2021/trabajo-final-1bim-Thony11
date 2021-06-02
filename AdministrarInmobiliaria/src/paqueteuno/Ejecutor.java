/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteuno;
import paquetedos.Propietario;
import paquetedos.EscrituraArchivoPropietario;
import paquetedos.LecturaArchivoPropietario;
import paquetecinco.Constructora;
import paquetecinco.EscrituraArchivoConstructora;
import paquetecinco.LecturaArchivoConstructora;
import paquetetres.Ubicacion;
import paquetetres.LecturaArchivoUbicacion;
import paquetetres.EscribirArchivoUbicacion;
import java.util.Scanner;
import paquetecuatro.Ciudad;
import paquetecuatro.EscrituraArchivoCiudad;
import paquetecuatro.LecturaArchivoCiudad;
import paqueteseis.EscrituraArchivoCasa;
import paqueteseis.LecturaArchivoCasa;
import paqueteseis.Casa;
import paqueteseis.Departamento;
import paqueteseis.EscrituraArchivoDepartamento;
import paqueteseis.LecturaArchivoDepartamento;
/**
 *
 * @author Lenovo
 */
public class Ejecutor {
    
    public static void main(String[] args) {
        
        Scanner leer = new Scanner(System.in);
     
        Propietario [] propietario;
        Ciudad [] ciudad;
        Ubicacion[] ubi;
        Constructora [] cons;
        int opcion;
 
        String nombre,apellido,numCasa,iden,nomCiu,nomPo,nomBa,refe,nomCo,ideCon;
        int n,m; 
        
            System.out.println("Digite la opción: \n"
                    + "1. Ingresar datos\n"
                    + "2. Mostrar datos\n");
            opcion = leer.nextInt();
            if(opcion==1){ 
                System.out.println("Digite la opción: \n"
                    + "1. Ingresar datos casa\n"
                    + "2. Ingresar datos departamento\n");
                    int  op= leer.nextInt();
                    if(op==1){
                        System.out.println("Ingrese el número de casas a ingresar:");
                        n = leer.nextInt();
                        leer.nextLine();
                        System.out.println("**DATOS DE LAS CASAS**");

                        propietario = new Propietario[n];

                        String nombreArchivo = "propietarios.txt";

                        EscrituraArchivoPropietario archivo = new EscrituraArchivoPropietario 
                        (nombreArchivo);

                        for (int i = 0; i < n; i++) {
                            System.out.printf("Ingrese los nombres del propietario"
                                    + "%d\n",i+1);                       
                            nombre = leer.nextLine();
                            System.out.printf("Ingrese los apellidos del propietario"
                                    + "%d\n",i+1);
                            apellido = leer.nextLine();
                            System.out.printf("Ingrese la identificación del"
                                    + " propietario " + "%d\n",i+1);
                            iden = leer.nextLine();
                            leer.nextLine();

                            Propietario po = new Propietario(nombre,apellido,iden);

                            propietario[i] = po;

                            po = propietario[i];

                            archivo.establecerRegistroPropietario(po);
                            archivo.establecerSalida();

                            LecturaArchivoPropietario lectura = new LecturaArchivoPropietario
                            (nombreArchivo);
                            lectura.establecerPropietarios();
                       }


                        ciudad = new Ciudad[n];

                        String nombreArchivo1 = "ciudades.txt";

                        EscrituraArchivoCiudad archivo1 = new EscrituraArchivoCiudad
                        (nombreArchivo1);

                        for (int i = 0; i < n; i++) {
                            System.out.printf("Ingrese la ciudad %d\n", i+1);
                            nomCiu = leer.nextLine();
                            System.out.printf("Ingrese la provincia %d\n", i+1);
                            nomPo = leer.nextLine();
                            leer.nextLine();

                            Ciudad ci = new Ciudad(nomCiu,nomPo);

                            ciudad[i] = ci;

                            ci = ciudad[i];

                            archivo1.establecerRegistroCiudad(ci);
                            archivo1.establecerSalida();
                            
                            LecturaArchivoCiudad lectura1 = new LecturaArchivoCiudad
                            (nombreArchivo1);
                            lectura1.establecerCiudades();
                        }
                        //**********
                        ubi = new Ubicacion[n];

                        String nombreArchivo2 = "ubicaciones.txt";

                        EscribirArchivoUbicacion archivo2 = new 
                                EscribirArchivoUbicacion(nombreArchivo2);

                        for (int i = 0; i < n; i++) {
                            System.out.printf("Ingrese el número de casa %d\n", 
                                        i+1);
                                numCasa = leer.nextLine();
                            System.out.printf("Ingrese el nombre del barrio %d\n", 
                                    i+1);
                            nomBa = leer.nextLine();
                            System.out.printf("Ingrese la referencia %d\n", i+1);
                            refe = leer.nextLine();
                            leer.nextLine();

                            Ubicacion u = new Ubicacion(numCasa,nomBa,refe);

                            ubi[i] = u;

                            u = ubi[i];

                            archivo2.establecerRegistroUbicacion(u);
                            archivo2.establecerSalida();

                            LecturaArchivoUbicacion lectura2 = new 
                                LecturaArchivoUbicacion (nombreArchivo2);
                            lectura2.establecerUbicaciones();
                        }
                        //**********
                        cons = new Constructora[n];

                        String nombreArchivo3 = "constructoras.txt";

                        EscrituraArchivoConstructora archivo3 = new EscrituraArchivoConstructora
                        (nombreArchivo3);

                        for (int i = 0; i < n; i++) {
                            System.out.printf("Ingrese el nombre de la constructora"
                                    + "%d\n", i+1);
                            nomCo = leer.nextLine();
                            System.out.printf("Ingrese el ide de la constructora "
                                    + "%d\n",i+1);
                            ideCon = leer.nextLine();
                            leer.nextLine();

                            Constructora co = new Constructora(nomCo,ideCon);

                            cons[i] = co;

                            co = cons[i];

                            archivo3.establecerRegistroConstructora(co);
                            archivo3.establecerSalida();

                            LecturaArchivoConstructora lectura3 = new LecturaArchivoConstructora
                            (nombreArchivo3);
                            lectura3.establecerConstructoras();
                            
                            String nombreArchivo4 = "casas.txt";

                            EscrituraArchivoCasa archivo4 = new EscrituraArchivoCasa 
                            (nombreArchivo4);

                            Casa casa = new Casa(propietario,ubi,ciudad,cons);
                            
                            casa.establecerCostoFinal();
                            casa.obtenerCostoFinal();      

                            archivo4.establecerRegistroCasa(casa);
                            archivo4.establecerSalida();

                            LecturaArchivoCasa lectura4 = new LecturaArchivoCasa
                            (nombreArchivo4);
                            lectura4.establecerCasas();
                            System.out.println(casa);                           
                        }
                    }else{
                        if(op==2){
                            
                            System.out.println("Ingrese el número de departamentos a ingresar:");
                            m = leer.nextInt();
                            leer.nextLine();
                            System.out.println("DATOS DE LOS DEPARTAMENTOS");

                            propietario = new Propietario[m];

                            String nombreArchivo = "propietarios.txt";

                            EscrituraArchivoPropietario archivo = new EscrituraArchivoPropietario 
                            (nombreArchivo);

                            for (int i = 0; i < m; i++) {
                                System.out.printf("Ingrese los nombres del propietario"
                                        + "%d\n",i+1);                       
                                nombre = leer.nextLine();
                                System.out.printf("Ingrese los apellidos del propietario"
                                        + "%d\n",i+1);
                                apellido = leer.nextLine();
                                System.out.printf("Ingrese la identificación del"
                                        + " propietario " + "%d\n",i+1);
                                iden = leer.nextLine();
                                leer.nextLine();

                                Propietario po = new Propietario(nombre,apellido,iden);

                                propietario[i] = po;

                                po = propietario[i];

                                archivo.establecerRegistroPropietario(po);
                                archivo.establecerSalida();

                                LecturaArchivoPropietario lectura = new LecturaArchivoPropietario
                                (nombreArchivo);
                                lectura.establecerPropietarios();
                           }

                            //**********

                            ciudad = new Ciudad[m];

                            String nombreArchivo1 = "ciudades.txt";

                            EscrituraArchivoCiudad archivo1 = new EscrituraArchivoCiudad
                            (nombreArchivo1);

                            for (int i = 0; i < m; i++) {
                                System.out.printf("Ingrese la ciudad %d\n", i+1);
                                nomCiu = leer.nextLine();
                                System.out.printf("Ingrese la provincia %d\n", i+1);
                                nomPo = leer.nextLine();
                                leer.nextLine();

                                Ciudad ci = new Ciudad(nomCiu,nomPo);

                                ciudad[i] = ci;

                                ci = ciudad[i];

                                archivo1.establecerRegistroCiudad(ci);
                                archivo1.establecerSalida();
                                
                                LecturaArchivoCiudad lectura1 = new LecturaArchivoCiudad
                                (nombreArchivo1);
                                lectura1.establecerCiudades();
                            }


                            //**********
                            ubi = new Ubicacion[m];

                            String nombreArchivo2 = "ubicaciones.txt";

                            EscribirArchivoUbicacion archivo2 = new 
                                    EscribirArchivoUbicacion(nombreArchivo2);

                            for (int i = 0; i < m; i++) {//ojo
                                System.out.printf("Ingrese el número de casa %d\n", 
                                        i+1);
                                numCasa = leer.nextLine();
                                System.out.printf("Ingrese el nombre del barrio %d\n", 
                                        i+1);
                                nomBa = leer.nextLine();
                                System.out.printf("Ingrese la referencia %d\n", i+1);
                                refe = leer.nextLine();
                                leer.nextLine();

                                Ubicacion u = new Ubicacion(numCasa,nomBa,refe);

                                ubi[i] = u;

                                u = ubi[i];

                                archivo2.establecerRegistroUbicacion(u);
                                archivo2.establecerSalida();

                                LecturaArchivoUbicacion lectura2 = new 
                                    LecturaArchivoUbicacion (nombreArchivo2);
                                lectura2.establecerUbicaciones();
                            }
                            //**********
                            cons = new Constructora[m];

                            String nombreArchivo3 = "constructoras.txt";

                            EscrituraArchivoConstructora archivo3 = new EscrituraArchivoConstructora
                            (nombreArchivo3);

                            for (int i = 0; i < m; i++) {
                                System.out.printf("Ingrese el nombre de la constructora"
                                        + "%d\n", i+1);
                                nomCo = leer.nextLine();
                                System.out.printf("Ingrese el ide de la constructora "
                                        + "%d\n",i+1);
                                ideCon = leer.nextLine();
                                leer.nextLine();

                                Constructora co = new Constructora(nomCo,ideCon);

                                cons[i] = co;

                                co = cons[i];

                                archivo3.establecerRegistroConstructora(co);
                                archivo3.establecerSalida();

                                LecturaArchivoConstructora lectura3 = new LecturaArchivoConstructora
                            (nombreArchivo3);
                                lectura3.establecerConstructoras();

                            }
                            String [] nomEdificio = new String[m];
                            
                            for (int i = 0; i <m; i++) {
                                System.out.printf("Ingrese el nombre del edificio %d\n", i+1);
                                    nomEdificio[i] = leer.nextLine();
                            }   
                            String [] UbiDeparEdi = new String[m];
                            
                            for (int i = 0; i < m; i++) {
                                System.out.printf("Ingrese la ubicación del "
                                        + "departamento en el edificio %d\n", i+1);
                                UbiDeparEdi[i] = leer.nextLine();
                            }
                        
                            String nombreArchivo5 = "departamentos.txt";

                            EscrituraArchivoDepartamento archivo5 = new EscrituraArchivoDepartamento 
                            (nombreArchivo5);

                            Departamento depa = new Departamento(propietario,ubi,ciudad,cons,nomEdificio,UbiDeparEdi);
     
                            depa.establecerCosFinal();
                            depa.obtenerCosFinal();
  

                            archivo5.establecerRegistroDepartamento(depa);
                            archivo5.establecerSalida();

                            LecturaArchivoDepartamento lectura5 = new LecturaArchivoDepartamento
                            (nombreArchivo5);
                            lectura5.establecerDepartamentos();
                            System.out.println(depa);    
                        }
                    }
            }else{
                if(opcion==2){
                    int op = 0;
                    System.out.println("Digite la opción: \n"
                            + "1. Si usted quiere obtener información"
                            + "del propietario\n"
                            + "2. Si usted quiere obtener información"
                            + "de las ubicaciones\n"
                            + "3. Si usted quiere obtener información"
                            + "de las ciudades\n"
                            + "4. Si usted quiere obtener información"
                            + "de las constructoras\n"); 
                        op = leer.nextInt();
                    if (op == 1){
                        String nombreArchivo = "propietarios.txt";
                        LecturaArchivoPropietario lectura = new LecturaArchivoPropietario(nombreArchivo);
                        lectura.establecerPropietarios();
                        System.out.println(lectura);
                    }else{
                        if(op == 2){
                            String nombreArchivo2 = "ubicaciones.txt";
                            LecturaArchivoUbicacion lectura2 = new LecturaArchivoUbicacion(nombreArchivo2);
                            lectura2.establecerUbicaciones();
                            System.out.println(lectura2);
                        }else{
                            if(op == 3){
                               String nombreArchivo1 = "ciudades.txt";
                            LecturaArchivoCiudad lectura1 = new LecturaArchivoCiudad(nombreArchivo1);
                            lectura1.establecerCiudades();
                            System.out.println(lectura1); 
                            }else{
                                if(op==4){
                                  String nombreArchivo3 = "constructoras.txt";
                                  LecturaArchivoConstructora lectura3 = new LecturaArchivoConstructora(nombreArchivo3);
                                  lectura3.establecerConstructoras();
                                  System.out.println(lectura3); 
                                }
                            }
                            
                        }
                    }
                }
            }
    }
    
}
