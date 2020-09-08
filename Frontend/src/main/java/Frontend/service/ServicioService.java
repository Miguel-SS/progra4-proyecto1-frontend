/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frontend.service;

import Frontend.model.Servicio;
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
public class ServicioService {
    private static final Logger logger = 
            LogManager.getLogger(ClienteService.class);
    
    private static final String REST_URI = 
            Constants.WS_ENDPOINT.concat("servicios");
    
    private Client client = null;
    
    public ServicioService() { client = ClientBuilder.newClient(); }
    
    public List<Servicio> loadAll() {
        logger.debug("Obteniendo toda la lista de servicios");
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
