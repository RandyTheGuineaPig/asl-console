package asl.rest;

import asl.console.dataprocessing.DataProcessor;
import asl.exceptions.InvalidEntityException;

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
    public String addConfiguration(@QueryParam("serverName") String serverName, @QueryParam("config") String config) {
        return null;
        //todo implement the fuck out of this
    }
}
