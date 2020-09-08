/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frontend.service;

import Frontend.model.Condicion;
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
public class CondicionService {
    private static final Logger logger = 
            LogManager.getLogger(ClienteService.class);
    
    private static final String REST_URI = 
            Constants.WS_ENDPOINT.concat("condiciones");
    
    private Client client = null;
    
    public CondicionService() { client = ClientBuilder.newClient(); }
    
    public List<Condicion> loadAll() {
        logger.debug("Obteniendo toda la lista de condiciones");
        return Arrays.asList(client.target(REST_URI)
                .request(MediaType.APPLICATION_JSON).get(Condicion[].class));
    }
    
    public Condicion searchById(int id) {
        String url = REST_URI+"/"+id;
        return client.target(url)
                .request(MediaType.APPLICATION_JSON).get(Condicion.class);
    }
    
    public Condicion save(Condicion condicion) {
        return client.target(REST_URI).request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(condicion,
                MediaType.APPLICATION_JSON), Condicion.class);
    }

    public Condicion update(Condicion condicion) {
        return client.target(REST_URI)
                .request(MediaType.APPLICATION_JSON).put(Entity.entity(condicion,
                MediaType.APPLICATION_JSON), Condicion.class);
    }

    public void delete(Condicion condicion) {
        String url = REST_URI+"/"+condicion.getId();
        client.target(url).request(MediaType.APPLICATION_JSON).delete().close();
    }
}
