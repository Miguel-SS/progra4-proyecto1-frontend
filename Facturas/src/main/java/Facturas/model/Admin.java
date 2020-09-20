/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facturas.model;



/**
 *
 * @author Usuario
 */
public class Admin {
    private int id;  
    private String password;
    private String nombre;

    public Admin(int id, String password, String nombre) {
        this.id = id;
        this.password = password;
        this.nombre = nombre;
    }
 
    public Admin(){
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Admin{" + "id=" + id + 
                ", password=" + password + 
                ", nombre=" + nombre + '}';
    }   
}
