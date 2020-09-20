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
public class Cliente {
    
    private int id;
    private String tipo;
    private String nombre;
    private String telefono;
    private Ubicacion direccion;
    private String correo;

 /**
     * Constructor por defecto
     */
    public Cliente(){}

 /**
     * Constructor con parametros
     * @param id
     * @param tipo
     * @param nombre
     * @param telefono
     * @param direccion
     * @param correo
     */
    public Cliente(int id, String tipo,String nombre,
            String telefono,Ubicacion direccion,String correo){
        
        this.id = id;
        this.tipo=tipo;
        this.nombre=nombre;
        this.telefono=telefono;
        this.direccion=direccion;
}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTipo(String tipo){
        this.tipo=tipo;
    }


    public void setNombre(String nombre){
        this.nombre=nombre;
    }

    public void setTelefono(String telefono ){
        this.telefono=telefono;
    }

    public void setDireccion(Ubicacion direccion){
        this.direccion=direccion;
    }

    public void setCorreo(String correo){
        this.correo=correo;
    }

    public String getTipo(){
        return tipo;
    }

    public String getNombre(){
        return nombre;
    }

    public String getTelefono(){
        return telefono;
    }

    public Ubicacion getDireccion(){
        return direccion;
    }
    
    public String getCorreo(){
        return correo;
    }
    
    

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id +
                ", tipo=" + tipo + 
                ", nombre=" + nombre + ", "
                + "telefono=" + telefono + ","
                + " direccion=" + direccion +
                ", correo=" + correo + '}';
    }
}