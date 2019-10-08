/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

/**
 *
 * @author Ruslan López Carro <scherzo16 at gmail.com>
 */
public class Usuario {
    private String rut;
    private String nombre;
    //private String paterno;
    //private String materno;
    //private String direccion;
    //private String telefono;
    private String tipo;
    //private String nouser;
    //private int cargo;
    
    public String getRut() {
        return rut;
    }

    public void setRut(String rut) {
        this.rut = rut;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
