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
public class Cliente {
    
    private int tipo;
    private int numero;
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
     * @param tipo
     * @param numero 
     * @param nombre
     * @param telefono
     * @param direccion
     * @param correo
     */
    public Cliente(int tipo,int numero,String nombre,
            String telefono,Ubicacion direccion,String correo){
        this.tipo=tipo;
        this.numero=numero;
        this.nombre=nombre;
        this.telefono=telefono;
        this.direccion=direccion;
}

    public void setTipo(int tipo){
        this.tipo=tipo;
    }

    public void setNumero(int numero){
        this.numero=numero;
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

    public int getTipo(){
        return tipo;
    }

    public int getNumero(){
        return numero;
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
        return "Cliente{" + 
                "tipo=" + tipo + 
                ", numero=" + numero + 
                ", nombre=" + nombre + 
                ", telefono=" + telefono + 
                ", direccion=" + direccion + 
                ", correo=" + correo + '}';
    }
}