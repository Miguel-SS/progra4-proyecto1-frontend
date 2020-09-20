/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facturas.service;

import Facturas.model.Factura;
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
public class FacturaService {
    
    
    private static final String REST_URI = 
            Constants.WS_ENDPOINT.concat("facturas");
    
    private Client client = null;
    
    public FacturaService() { client = ClientBuilder.newClient(); }
    
    public List<Factura> loadAll() {
       
        return Arrays.asList(client.target(REST_URI)
                .request(MediaType.APPLICATION_JSON).get(Factura[].class));
    }
    
    public Factura searchById(int id) {
        String url = REST_URI+"/"+id;
        return client.target(url)
                .request(MediaType.APPLICATION_JSON).get(Factura.class);
    }
    
    public Factura save(Factura factura) {
        return client.target(REST_URI).request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(factura,
                MediaType.APPLICATION_JSON), Factura.class);
    }

    public Factura update(Factura factura) {
        return client.target(REST_URI)
                .request(MediaType.APPLICATION_JSON).put(Entity.entity(factura,
                MediaType.APPLICATION_JSON), Factura.class);
    }

    public void delete(Factura factura) {
        String url = REST_URI+"/"+factura.getId();
        client.target(url).request(MediaType.APPLICATION_JSON).delete().close();
    }
}
