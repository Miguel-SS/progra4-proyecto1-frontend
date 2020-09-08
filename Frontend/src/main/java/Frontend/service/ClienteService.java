/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frontend.service;

import Frontend.model.Cliente;
import Frontend.utilities.Constants;
import java.util.Arrays;
import java.util.List;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 *
 * @author migue
 */
public class ClienteService {
    private static final Logger logger = 
            LogManager.getLogger(ClienteService.class);
    
    private static final String REST_URI = 
            Constants.WS_ENDPOINT.concat("clientes");
    
    private Client client = null;
    
    public ClienteService() { client = ClientBuilder.newClient(); }
    
    public List<Cliente> loadAll() {
        logger.debug("Obteniendo toda la lista de clientes");
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
