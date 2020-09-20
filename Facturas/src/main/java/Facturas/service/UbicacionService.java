/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facturas.service;

import Facturas.model.Ubicacion;
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
public class UbicacionService {
  
    
    private static final String REST_URI = 
            Constants.WS_ENDPOINT.concat("ubicaciones");
    
    private Client client = null;
    
    public UbicacionService() { client = ClientBuilder.newClient(); }
    
    public List<Ubicacion> loadAll() {
       
        return Arrays.asList(client.target(REST_URI)
                .request(MediaType.APPLICATION_JSON).get(Ubicacion[].class));
    }
    
    public Ubicacion searchById(int id) {
        String url = REST_URI+"/"+id;
        return client.target(url)
                .request(MediaType.APPLICATION_JSON).get(Ubicacion.class);
    }
    
    public Ubicacion save(Ubicacion ubicacion) {
        return client.target(REST_URI).request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(ubicacion,
                MediaType.APPLICATION_JSON), Ubicacion.class);
    }

    public Ubicacion update(Ubicacion ubicacion) {
        return client.target(REST_URI)
                .request(MediaType.APPLICATION_JSON).put(Entity.entity(ubicacion,
                MediaType.APPLICATION_JSON), Ubicacion.class);
    }

    public void delete(Ubicacion ubicacion) {
        String url = REST_URI+"/"+ubicacion.getId();
        client.target(url).request(MediaType.APPLICATION_JSON).delete().close();
    }
}
