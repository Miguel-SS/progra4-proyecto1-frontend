/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facturas.service;

import Facturas.model.Actividad;
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
public class ActividadService {
    
    
    private static final String REST_URI = 
            Constants.WS_ENDPOINT.concat("actividades");
    
    private Client client = null;
    
    public ActividadService() { client = ClientBuilder.newClient(); }
    
    public List<Actividad> loadAll() {
        return Arrays.asList(client.target(REST_URI)
                .request(MediaType.APPLICATION_JSON).get(Actividad[].class));
    }
    
    public Actividad searchById(int id) {
        String url = REST_URI+"/"+id;
        return client.target(url)
                .request(MediaType.APPLICATION_JSON).get(Actividad.class);
    }
    
    public Actividad save(Actividad actividad) {
        return client.target(REST_URI).request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(actividad,
                MediaType.APPLICATION_JSON), Actividad.class);
    }

    public Actividad update(Actividad cliente) {
        return client.target(REST_URI)
                .request(MediaType.APPLICATION_JSON).put(Entity.entity(cliente,
                MediaType.APPLICATION_JSON), Actividad.class);
    }

    public void delete(Actividad actividad) {
        String url = REST_URI+"/"+actividad.getId();
        client.target(url).request(MediaType.APPLICATION_JSON).delete().close();
    }
}
