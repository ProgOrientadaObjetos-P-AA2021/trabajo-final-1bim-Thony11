/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package paquetecinco;

import java.io.Serializable;

/**
 *
 * @author Lenovo
 */
public class Constructora implements Serializable {

    private String nombreConstructora;
    private String idEmpresa;

    public Constructora(String nombre, String id) {
        nombreConstructora = nombre;
        idEmpresa = id;
    }

    public void establecerNombreConstructora(String nombre) {
        nombreConstructora = nombre;
    }

    public void establecerIdEmpresa(String id) {
        idEmpresa = id;
    }

    public String obtenerNombreConstructora() {
        return nombreConstructora;
    }

    public String obtenerIdEmpresa() {
        return idEmpresa;
    }
    
    @Override
    public String toString() {
        String cadena = String.format("Información del Constructora:\n"
                + " - Nombre de la empresa: %s\n"
                + " - Id de la empresa: %s\n",
                obtenerNombreConstructora(),
                obtenerIdEmpresa());
        return cadena;
    }

}