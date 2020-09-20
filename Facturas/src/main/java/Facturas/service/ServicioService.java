/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facturas.service;

import Facturas.model.Servicio;
import Facturas.utilities.Constants;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author migue
 */
public class ServicioService {
    
    
    private static final String REST_URI = 
            Constants.WS_ENDPOINT.concat("servicios");
    
    private Client client = null;
    
    public ServicioService() { client = ClientBuilder.newClient(); }
    
    public List<Servicio> loadAll() {
       
        return Arrays.asList(client.target(REST_URI)
                .request(MediaType.APPLICATION_JSON).get(Servicio[].class));
    }
    
    public Servicio searchById(int id) {
        String url = REST_URI+"/"+id;
        return client.target(url)
                .request(MediaType.APPLICATION_JSON).get(Servicio.class);
    }
    
    public Servicio save(Servicio servicio) {
        return client.target(REST_URI).request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(servicio,
                MediaType.APPLICATION_JSON), Servicio.class);
    }

    public Servicio update(Servicio servicio) {
        return client.target(REST_URI)
                .request(MediaType.APPLICATION_JSON).put(Entity.entity(servicio,
                MediaType.APPLICATION_JSON), Servicio.class);
    }

    public void delete(Servicio servicio) {
        String url = REST_URI+"/"+servicio.getId();
        client.target(url).request(MediaType.APPLICATION_JSON).delete().close();
    }
}
