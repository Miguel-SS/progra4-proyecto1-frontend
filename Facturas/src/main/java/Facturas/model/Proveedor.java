/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facturas.model;

import java.util.ArrayList;
import java.util.List;

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
    private Actividad actividad;
    private boolean estado;
    private String password;
    private List <Servicio> servicios;

   /**
  * 
  * @param id
  * @param nombre
  * @param telefono
  * @param correo
  * @param ubicacion
  * @param actividad
  * @param estado
  * @param password 
  */
    public Proveedor(int id, String nombre, String telefono, String correo, 
            Ubicacion ubicacion, Actividad actividad, boolean estado, String password) {
        this.id = id;
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.ubicacion = ubicacion;
        this.actividad = actividad;
        this.estado = estado;
        this.password = password;
        servicios = new ArrayList<>();
    }
  /**
   * Constructor sin parametros
   */
    public Proveedor(){
    
    }

    public List<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(List<Servicio> servicios) {
        this.servicios = servicios;
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

    public Actividad getActividad() {
        return actividad;
    }

    public void setActividad(Actividad actividad) {
        this.actividad = actividad;
    }

    public boolean isEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Proveedor{" + "id=" + id + 
                ", nombre=" + nombre + 
                ", telefono=" + telefono + 
                ", correo=" + correo + 
                ", ubicacion=" + ubicacion + 
                ", actividad=" + actividad + 
                ", estado=" + estado + 
                ", password=" + password +
                ", servicios=" + servicios + '}';
    }

}
