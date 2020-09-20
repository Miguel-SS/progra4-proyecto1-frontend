/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facturas.service;

import Facturas.model.*;

import java.util.List;


/**
 *
 * @author migue
 */
public class ServiceFacade {
    private final ActividadService actividadService;
    private final ClienteService clienteService;
    private final CondicionService condicionService;
    private final FacturaService facturaService;
    private final ProveedorService proveedorService;
    private final ServicioService servicioService;
    private final UbicacionService ubicacionService;
    private final UnidadService unidadService;
    private final AdminService adminService;
    
    public ServiceFacade() {
        actividadService = new ActividadService();
        clienteService = new ClienteService();
        condicionService = new CondicionService();
        facturaService = new FacturaService();
        proveedorService = new ProveedorService();
        servicioService = new ServicioService();
        ubicacionService = new UbicacionService();
        unidadService = new UnidadService();
        adminService = new AdminService();
    }
    
    public void save(Object o) {
        if(o.getClass() == Actividad.class) {
            actividadService.save((Actividad) o);
        }
        if(o.getClass() == Cliente.class) {
            clienteService.save((Cliente) o);
        }
        if(o.getClass() == Condicion.class) {
            condicionService.save((Condicion) o);
        }
        if(o.getClass() == Factura.class) {
            facturaService.save((Factura) o);
        }
        if(o.getClass() == Proveedor.class) {
            proveedorService.save((Proveedor) o);
        }
        if(o.getClass() == Servicio.class) {
            servicioService.save((Servicio) o);
        }
        if(o.getClass() == Ubicacion.class) {
            ubicacionService.save((Ubicacion) o);
        }
        if(o.getClass() == Unidad.class) {
            unidadService.save((Unidad) o);
        }
        if(o.getClass() == Admin.class){
            adminService.save((Admin)o);
        }
    }
    
    public void delete(Object o) {
        if(o.getClass() == Actividad.class) {
            actividadService.delete((Actividad) o);
        }
        if(o.getClass() == Cliente.class) {
            clienteService.delete((Cliente) o);
        }
        if(o.getClass() == Condicion.class) {
            condicionService.delete((Condicion) o);
        }
        if(o.getClass() == Factura.class) {
            facturaService.delete((Factura) o);
        }
        if(o.getClass() == Proveedor.class) {
            proveedorService.delete((Proveedor) o);
        }
        if(o.getClass() == Servicio.class) {
            servicioService.delete((Servicio) o);
        }
        if(o.getClass() == Ubicacion.class) {
            ubicacionService.delete((Ubicacion) o);
        }
        if(o.getClass() == Unidad.class) {
            unidadService.delete((Unidad) o);
        }
         if(o.getClass() == Admin.class){
             adminService.delete((Admin)o);
         }
    }
    
    public void update(Object o) {
        if(o.getClass() == Actividad.class) {
            actividadService.update((Actividad) o);
        }
        if(o.getClass() == Cliente.class) {
            clienteService.update((Cliente) o);
        }
        if(o.getClass() == Condicion.class) {
            condicionService.update((Condicion) o);
        }
        if(o.getClass() == Factura.class) {
            facturaService.update((Factura) o);
        }
        if(o.getClass() == Proveedor.class) {
            proveedorService.update((Proveedor) o);
        }
        if(o.getClass() == Servicio.class) {
            servicioService.update((Servicio) o);
        }
        if(o.getClass() == Ubicacion.class) {
            ubicacionService.update((Ubicacion) o);
        }
        if(o.getClass() == Unidad.class) {
            unidadService.update((Unidad) o);
        }
        
         if(o.getClass() == Admin.class){
             adminService.update((Admin) o);
         }
    }
    
    
    
    public Object searchUser(int id) {
        Object user = null;
        user = proveedorService.searchById(id);
        if(user != null) {
            return user;
        }
        user = clienteService.searchById(id);
        if(user != null) {
            return user;
        }
        
        user = adminService.searchById(id);
        if(user != null){
            return user;
        }
        return null;
    }
    
    public Actividad searchActividad(int id) {
        return actividadService.searchById(id);
    }
    
    public Condicion searchCondicion(int id) {
        return condicionService.searchById(id);
    }
    
    public Factura searchFactura(int id) {
        return facturaService.searchById(id);
    }
    
    public Servicio searchServicio(int id) {
        return servicioService.searchById(id);
    }
    
    public Ubicacion searchUbicacion(int id) {
        return ubicacionService.searchById(id);
    }
    
    public Unidad searchUnidad(int id) {
        return unidadService.searchById(id);
    }
    
    
    
    public List<Actividad> getActividades() {
        return actividadService.loadAll();
    }
    
    public List<Cliente> getClientes() {
        return clienteService.loadAll();
    }
    
    public List<Condicion> getCondiciones() {
        return condicionService.loadAll();
    }
    
    public List<Factura> getFacturas() {
        return facturaService.loadAll();
    }
    
    public List<Proveedor> getPoveedores() {
        return proveedorService.loadAll();
    }
    
    public List<Servicio> getServicios() {
        return servicioService.loadAll();
    }
    
    public List<Ubicacion> getUbicaciones() {
        return ubicacionService.loadAll();
    }
    
    public List<Unidad> getUnidades() {
        return unidadService.loadAll();
    }
}
