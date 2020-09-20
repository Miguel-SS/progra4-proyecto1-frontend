/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Facturas.service;


import Facturas.model.Admin;
import Facturas.utilities.Constants;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class AdminService {

     private static final String REST_URI = 
            Constants.WS_ENDPOINT.concat("admins");
    
    private Client client = null;
    
    public AdminService() { client =  ClientBuilder.newClient(); }
    
    public List<Admin> loadAll() {
       
        return Arrays.asList(client.target(REST_URI)
                .request(MediaType.APPLICATION_JSON).get(Admin[].class));
    }
    
    public Admin searchById(int id) {
        String url = REST_URI+"/"+id;
        return client.target(url)
                .request(MediaType.APPLICATION_JSON).get(Admin.class);
    }
    
    public Admin save(Admin admin) {
        return client.target(REST_URI).request(MediaType.APPLICATION_JSON)
                .post(Entity.entity(admin,
                MediaType.APPLICATION_JSON), Admin.class);
    }

    public Admin update(Admin admin) {
        return client.target(REST_URI)
                .request(MediaType.APPLICATION_JSON).put(Entity.entity(admin,
                MediaType.APPLICATION_JSON), Admin.class);
    }

    public void delete(Admin admin) {
        String url = REST_URI+"/"+admin.getId();
        client.target(url).request(MediaType.APPLICATION_JSON).delete().close();
    }
}
