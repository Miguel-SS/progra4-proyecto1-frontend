/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frontend.service;

import Frontend.model.Unidad;
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
public class UnidadService {
    private static final Logger logger = 
            LogManager.getLogger(ClienteService.class);
    
    private static final String REST_URI = 
            Constants.WS_ENDPOINT.concat("unidades");
    
    private Client client = null;
    
    public UnidadService() { client = ClientBuilder.newClient(); }
    
    public List<Unidad> loadAll() {
        logger.debug("Obteniendo toda la lista de unidades");
        return Arrays.asList(client.target(REST_URI)
                .request(MediaType.APPLICATION_JSON).get(Unidad[].class));
    }
    
    public Unidad searchById(int id) {
        String url = REST_URI+"/"+id;
        return client.target(url)
                .request(MediaType.APPLICATION_JSON).get(Unidad.class);
    }
    
    public Unidad save(Unidad unidad) {
        return client.target(REST_URI).request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(unidad,
                MediaType.APPLICATION_JSON), Unidad.class);
    }

    public Unidad update(Unidad unidad) {
        return client.target(REST_URI)
                .request(MediaType.APPLICATION_JSON).put(Entity.entity(unidad,
                MediaType.APPLICATION_JSON), Unidad.class);
    }

    public void delete(Unidad unidad) {
        String url = REST_URI+"/"+unidad.getId();
        client.target(url).request(MediaType.APPLICATION_JSON).delete().close();
    }
}
