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
public class Servicio {
    private String id;
    private String nombre;
    private String tipo;
    private int cantidad;
    private String unidad;
    private double precioUnitario;
    private double impuesto;
    private double subTotal;
    private double total;
    private String descripcion;

    /**
     * Constructor por defecto
     */
    public Servicio() { }

    /**
     * Constructor con parametros
     * @param id
     * @param nombre
     * @param tipo
     * @param cantidad
     * @param unidad
     * @param precioUnitario
     * @param impuesto
     * @param subTotal
     * @param total
     * @param descripcion 
     */
    public Servicio(String id, String nombre, String tipo, int cantidad, 
            String unidad, double precioUnitario, double impuesto, 
            double subTotal, double total, String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.unidad = unidad;
        this.precioUnitario = precioUnitario;
        this.impuesto = impuesto;
        this.subTotal = subTotal;
        this.total = total;
        this.descripcion = descripcion;
    }

    public String getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getTipo() {
        return tipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getUnidad() {
        return unidad;
    }

    public double getPrecioUnitario() {
        return precioUnitario;
    }

    public double getImpuesto() {
        return impuesto;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public double getTotal() {
        return total;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public void setPrecioUnitario(double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public void setImpuesto(double impuesto) {
        this.impuesto = impuesto;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Servicio{" + 
                "id=" + id + 
                ", nombre=" + nombre + 
                ", tipo=" + tipo + 
                ", cantidad=" + cantidad + 
                ", unidad=" + unidad + 
                ", precioUnitario=" + precioUnitario + 
                ", impuesto=" + impuesto + 
                ", subTotal=" + subTotal + 
                ", total=" + total +
                ", descripcion=" + descripcion + '}';
    }
}
