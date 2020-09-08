/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frontend.model;

/**
 *
 * @author migue
 */
public class Actividad {
    private int id;
    private String nombre;

    /**
     * 
     * @param id de la actividad
     * @param nombre nombre de la actividad
     */
    public Actividad(int id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Actividad() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Actividad{" + "id=" + id + ", nombre=" + nombre + '}';
    }
}
