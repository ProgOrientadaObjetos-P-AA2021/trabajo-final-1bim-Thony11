/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paqueteseis;

import java.io.Serializable;
import paquetecinco.Constructora;
import paquetecuatro.Ciudad;
import paquetedos.Propietario;
import paquetetres.Ubicacion;

/**
 *
 * @author reroes
 */
public class Casa implements Serializable {

    private Propietario personaPropietaria;
    private double precioMetro2;
    private int numeroMetro2;
    private double costoFinal;
    private Ubicacion ubicacionCasa;
    private Ciudad ciudadCasa;
    private int numeroCuartos;
    private Constructora empresaConstructora;

    public Casa(Propietario persona, double precioM2, int numM2,
            Ubicacion ubiCasa, Ciudad ciud, int cuartos,
            Constructora empresa) {
        personaPropietaria = persona;
        precioMetro2 = precioM2;
        numeroMetro2 = numM2;
        ubicacionCasa = ubiCasa;
        ciudadCasa = ciud;
        numeroCuartos = cuartos;
        empresaConstructora = empresa;
    }

    public void establecerPersonaPropietaria(Propietario p) {
        personaPropietaria = p;
    }

    public void establecerPrecioMetro2(double precio) {
        precioMetro2 = precio;
    }

    public void establecerNumeroMetro2(int metro) {
        numeroMetro2 = metro;
    }

    public void establecerCostoFinal() {
        costoFinal = numeroMetro2 * precioMetro2;
    }

    public void establecerUbicacionCasa(Ubicacion ubi) {
        ubicacionCasa = ubi;
    }

    public void establecerCiudadCasa(Ciudad ciu) {
        ciudadCasa = ciu;
    }

    public void establecerNumeroCuartos(int cuartos) {
        numeroCuartos = cuartos;
    }

    public void establecerEmpresaConstructora(Constructora emp) {
        empresaConstructora = emp;
    }

    public Propietario obtenerPersonaPropietaria() {
        return personaPropietaria;
    }

    public double obtenerPrecioMetro2() {
        return precioMetro2;
    }

    public int obtenerNumeroMetro2() {
        return numeroMetro2;
    }

    public double obtenerCostoFinal() {
        return costoFinal;
    }

    public Ubicacion obtenerUbicacionCasa() {
        return ubicacionCasa;
    }

    public Ciudad obtenerCiudadCasa() {
        return ciudadCasa;
    }

    public int obtenerNumeroCuartos() {
        return numeroCuartos;
    }

    public Constructora obtenerEmpresaConstructora() {
        return empresaConstructora;
    }

    @Override
    public String toString() {
        String cadena = String.format("Información de la Casa:\n"
                + "Propietario: %s %s\nIdentificación: %s\n"
                + "Precio por metro2: %.2f\nNúmero de metros2: %d\n"
                + "Costo final: %.2f\nUbicacion:\n - Barrio: %s\n"
                + " - Referencia: %s\n - Numero de casa: %s\n"
                + "Ciudad: %s\nProvincia: %s\nNúmero de cuartos: %d\n"
                + "Información de la constructora:\n - Nombre: %s\n"
                + " - Id de la empresa: %s\n\n",
                obtenerPersonaPropietaria().obtenerNombre(),
                obtenerPersonaPropietaria().obtenerApellido(),
                obtenerPersonaPropietaria().obtenerIdentificacion(),
                obtenerPrecioMetro2(), obtenerNumeroMetro2(),
                obtenerCostoFinal(),
                obtenerUbicacionCasa().obtenerNombreBarrio(),
                obtenerUbicacionCasa().obtenerReferencia(),
                obtenerUbicacionCasa().obtenerNumeroCasa(),
                obtenerCiudadCasa().obtenerNombreCiudad(),
                obtenerCiudadCasa().obtenerNombreProvincia(),
                obtenerNumeroCuartos(),
                obtenerEmpresaConstructora().obtenerNombreConstructora(),
                obtenerEmpresaConstructora().obtenerIdEmpresa());
        return cadena;
    }

}