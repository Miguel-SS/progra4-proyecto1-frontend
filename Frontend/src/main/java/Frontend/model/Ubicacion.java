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
public class Ubicacion {
    private int id;
    private String provincia;
    private String canton;
    private String distrito;
    private String otrasSenas;

 /**
     * Constructor por defecto
     */
    public Ubicacion(){}

 /**
     * Constructor con parametros
     * @param id
     * @param provincia
     * @param canton 
     * @param distrito
     * @param otrasSenas
     */
    public Ubicacion(int id,String provincia,String canton, 
            String distrito,String otrasSenas){
        this.id=id;
        this.provincia= provincia;
        this.canton=canton;
        this.distrito=distrito;
        this.otrasSenas=otrasSenas;
    }

    public void setId(int id){
        this.id=id;
    }
    
    public void setProvincia(String provincia){
        this.provincia=provincia;
    }


    public void setCanton(String canton){
        this.canton=canton;
    }

    public void setDistrito(String distrito){
        this.distrito=distrito;
    }

    public void setOtrasSenas(String otrasSenas){
        this.otrasSenas=otrasSenas;
    }
    
    public int getId() {
        return id;
    }
    
    public String getProvincia(){
        return provincia;
    }

    public String getCanton(){
        return canton;
    }

    public String getDistrito(){
        return distrito;
    }

    public String getOtrasSenas(){
        return otrasSenas;
    }

    @Override
    public String toString() {
        return "Ubicacion{" + 
                "provincia=" + provincia + 
                ", canton=" + canton + 
                ", distrito=" + distrito + 
                ", otrasSenas=" + otrasSenas + '}';
    }
}
