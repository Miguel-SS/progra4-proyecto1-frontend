/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frontend.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Gabriela
 */
public class Factura {
    private int id;
    private int clave;
    private Date fecha;

    private Cliente cliente;
    private Proveedor idProveedor;
    private Condicion condicion;
    private String medioPago;
    private String observacion;
    private double montoTotal;
    private double subTotal;
    private double impuesto;
    private double neto;
    
    private List<Servicio> servicios;
    

    /**
     * Constructor sin parametros
     */
    public Factura() {
    }

    /**
     * Constructor con parametros
     *
     * @param id
     * @param clave
     * @param fecha
     * @param idCliente
     * @param idProveedor
     * @param condicion
     * @param medioPago
     * @param observacion
     * @param montoTotal
     * @param subTotal
     * @param impuesto
     * @param neto
     */
    public Factura(int id, int clave, Date fecha, Cliente idCliente, 
                    Proveedor idProveedor, Condicion condicion, 
                    String medioPago,String observacion,
                    double montoTotal, double subTotal,
                    double impuesto, double neto) {
        this.id = id;
        this.clave = clave;
        this.fecha = fecha;
        this.cliente = idCliente;
        this.idProveedor = idProveedor;
        this.condicion = condicion;
        this.medioPago = medioPago;
        this.observacion = observacion;
        this.montoTotal = montoTotal;
        this.subTotal = subTotal;
        this.impuesto = impuesto;
        this.neto = neto;
        servicios = new ArrayList<>();
    }

    
    public int getId() {
        return id;
    }

    public int getClave() {
        return clave;
    }

    public Date getFecha() {
        return fecha;
    }

    public Cliente getIdCliente() {
        return cliente;
    }

    public Proveedor getIdProveedor() {
        return idProveedor;
    }

    public Condicion getCondicion() {
        return condicion;
    }

    public String getMedioPago() {
        return medioPago;
    }

    public String getObservacion() {
        return observacion;
    }

    public double getMontoTotal() {
        return montoTotal;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public double getImpuesto() {
        return impuesto;
    }

    public double getNeto() {
        return neto;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setIdCliente(Cliente idCliente) {
        this.cliente = idCliente;
    }

    public void setIdProveedor(Proveedor idProveedor) {
        this.idProveedor = idProveedor;
    }

    public void setCondicion(Condicion condicion) {
        this.condicion = condicion;
    }

    public void setMedioPago(String medioPago) {
        this.medioPago = medioPago;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public void setMontoTotal(double montoTotal) {
        this.montoTotal = montoTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    public void setImpuesto(double impuesto) {
        this.impuesto = impuesto;
    }

    public void setNeto(double neto) {
        this.neto = neto;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(List<Servicio> servicios) {
        this.servicios = servicios;
    }

    @Override
    public String toString() {
        return "Factura{" + "id=" + id + 
               ", clave=" + clave + 
               ", fecha=" + fecha + 
               ", cliente=" + cliente + 
               ", idProveedor=" + idProveedor + 
               ", condicion=" + condicion + 
               ", medioPago=" + medioPago + 
               ", observacion=" + observacion + 
               ", montoTotal=" + montoTotal + 
               ", subTotal=" + subTotal + 
               ", impuesto=" + impuesto + 
               ", neto=" + neto + 
               ", servicios=" + servicios + '}';
    }
    
}

