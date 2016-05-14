package asl.rest;

import asl.console.dataprocessing.DataProcessor;
import asl.exceptions.ConfigurationException;
import asl.exceptions.InvalidEntityException;
import asl.util.JsonBuilder;

import javax.ejb.EJB;
import javax.ws.rs.*;

/**
 * Created by sengir on 14.05.16.
 */
@Path("/")
public class StoreDataRESTEndpoint {
    @EJB
    private DataProcessor dataProcessor;

    @GET
    @Path("/add-server")
    public String addServerData(@QueryParam("serverName") String serverName, @QueryParam("ipAddress") String ipAddress) {
        try {
            dataProcessor.addServer(serverName, ipAddress);
            return "Successfully added server: " + serverName + " with IP address: " + ipAddress;
        } catch (InvalidEntityException e) {
            return "Oops, something went terribly wong!";
        }
        //todo better stati
    }

    @GET
    @Path("/add-configuration")
    public String addConfiguration(@QueryParam("serverName") String serverName, @QueryParam("config") String config) { //remember! URI has to have { replaced with %7B and } with %7D
        try {
            dataProcessor.storeDataInDb(JsonBuilder.prepareConfigurationVector(config));
        } catch (InvalidEntityException e) {
            return e.getMessage();
        } catch (ConfigurationException e) {
            return e.getMessage();
        }
        return String.format("Successfully added configuration for server: %s", serverName);
    }
}
