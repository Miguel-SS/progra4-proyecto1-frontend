/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frontend.service;

import Frontend.model.Ubicacion;
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
public class UbicacionService {
    private static final Logger logger = 
            LogManager.getLogger(ClienteService.class);
    
    private static final String REST_URI = 
            Constants.WS_ENDPOINT.concat("ubicaciones");
    
    private Client client = null;
    
    public UbicacionService() { client = ClientBuilder.newClient(); }
    
    public List<Ubicacion> loadAll() {
        logger.debug("Obteniendo toda la lista de ubicaciones");
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
