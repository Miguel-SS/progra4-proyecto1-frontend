/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facturas.service;

import Facturas.model.Cliente;
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
public class ClienteService {
   
    
    private static final String REST_URI = 
            Constants.WS_ENDPOINT.concat("clientes");
    
    private Client client = null;
    
    public ClienteService() { client = ClientBuilder.newClient(); }
    
    public List<Cliente> loadAll() {
       
        return Arrays.asList(client.target(REST_URI)
                .request(MediaType.APPLICATION_JSON).get(Cliente[].class));
    }
    
    public Cliente searchById(int id) {
        String url = REST_URI+"/"+id;
        return client.target(url)
                .request(MediaType.APPLICATION_JSON).get(Cliente.class);
    }
    
    public Cliente save(Cliente cliente) {
        return client.target(REST_URI).request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(cliente,
                MediaType.APPLICATION_JSON), Cliente.class);
    }

    public Cliente update(Cliente cliente) {
        return client.target(REST_URI)
                .request(MediaType.APPLICATION_JSON).put(Entity.entity(cliente,
                MediaType.APPLICATION_JSON), Cliente.class);
    }

    public void delete(Cliente cliente) {
        String url = REST_URI+"/"+cliente.getId();
        client.target(url).request(MediaType.APPLICATION_JSON).delete().close();
    }
}
