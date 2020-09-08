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
public class Proveedor {
    private int id;
    private String nombre;
    private String telefono;
    private String correo;
    private Ubicacion ubicacion;

    /**
     * 
     * @param id id proveedor
     * @param nombre nombre del proovedor
     * @param telefono telefono del proovedor
     * @param correo correo del proovedor
     * @param ubicacion ubicacion del proveedor
     */
    public Proveedor(int id, String nombre, String telefono, String correo, 
            Ubicacion ubicacion) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.ubicacion = ubicacion;
    }
    /**
     * Constructor sin parametros
     */
    public Proveedor(){

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

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public Ubicacion getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(Ubicacion ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Override
    public String toString() {
        return "Proveedor{" + "id=" + id + 
                ", nombre=" + nombre + ", telefono=" + telefono +
                ", correo=" + correo + ", "
                + "ubicacion=" + ubicacion + '}';

    }
}
