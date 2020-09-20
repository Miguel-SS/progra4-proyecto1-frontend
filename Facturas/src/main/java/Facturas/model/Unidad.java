/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facturas.model;

/**
 *
 * @author migue
 */
public class Unidad {
    private int id;
    private String nombre;
    private String tipo;

    /**
     * Constructor por defecto
     */
    public Unidad() {}

    /**
     * Constructor
     * @param id
     * @param nombre
     * @param tipo 
     */
    public Unidad(int id, String nombre, String tipo) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "Unidad{" + 
                "id=" + id + 
                ", nombre=" + nombre + 
                ", tipo=" + tipo + '}';
    }
}
