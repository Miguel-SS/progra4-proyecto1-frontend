/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frontend.service;

import Frontend.model.Actividad;
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
public class ActividadService {
    private static final Logger logger = 
            LogManager.getLogger(ClienteService.class);
    
    private static final String REST_URI = 
            Constants.WS_ENDPOINT.concat("actividades");
    
    private Client client = null;
    
    public ActividadService() { client = ClientBuilder.newClient(); }
    
    public List<Actividad> loadAll() {
        logger.debug("Obteniendo toda la lista de actividades");
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
