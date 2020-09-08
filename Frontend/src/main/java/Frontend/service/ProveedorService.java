/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frontend.service;

import Frontend.model.Proveedor;
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
public class ProveedorService {
    private static final Logger logger = 
            LogManager.getLogger(ClienteService.class);
    
    private static final String REST_URI = 
            Constants.WS_ENDPOINT.concat("proveedores");
    
    private Client client = null;
    
    public ProveedorService() { client = ClientBuilder.newClient(); }
    
    public List<Proveedor> loadAll() {
        logger.debug("Obteniendo toda la lista de proveedores");
        return Arrays.asList(client.target(REST_URI)
                .request(MediaType.APPLICATION_JSON).get(Proveedor[].class));
    }
    
    public Proveedor searchById(int id) {
        String url = REST_URI+"/"+id;
        return client.target(url)
                .request(MediaType.APPLICATION_JSON).get(Proveedor.class);
    }
    
    public Proveedor save(Proveedor proveedor) {
        return client.target(REST_URI).request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(proveedor,
                MediaType.APPLICATION_JSON), Proveedor.class);
    }

    public Proveedor update(Proveedor proveedor) {
        return client.target(REST_URI)
                .request(MediaType.APPLICATION_JSON).put(Entity.entity(proveedor,
                MediaType.APPLICATION_JSON), Proveedor.class);
    }

    public void delete(Proveedor proveedor) {
        String url = REST_URI+"/"+proveedor.getId();
        client.target(url).request(MediaType.APPLICATION_JSON).delete().close();
    }
}
