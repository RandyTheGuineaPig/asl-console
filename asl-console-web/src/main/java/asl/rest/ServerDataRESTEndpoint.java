package asl.rest;

import asl.console.dataprocessing.DataProcessor;
import asl.exceptions.InvalidEntityException;
import asl.util.JsonBuilder;

import javax.ejb.EJB;
import javax.ws.rs.*;

/**
 * Created by sengir on 14.05.16.
 */
@Path("/monitored")
public class ServerDataRESTEndpoint {
    @EJB
    private DataProcessor dataProcessor;


    @GET
    @Path("/get")
    @Produces("text/plain")
    public String getServers() {
        return JsonBuilder.prepareJson(dataProcessor.getServers());
    }

    @GET
    @Path("/get/{serverName}")
    @Produces("text/plain")
    public String getServerDetails(@PathParam("serverName") final String serverName) {
        return JsonBuilder.prepareJson(dataProcessor.getServerDetails(serverName));
    }

    @GET
    @Path("/store")
    public String addServerData(@QueryParam("serverName") String serverName, @QueryParam("ipAddress") String ipAddress) {
        try {
            dataProcessor.addServer(serverName, ipAddress);
            return "Successfully added server: " + serverName + " with IP address: " + ipAddress;
        } catch (InvalidEntityException e) {
            return "Oops, something went terribly wong!";
        }
    }

    @GET
    @Path("/delete")
    @Produces("text/plain")
    public String deleteServerData(@QueryParam("serverName") final String serverName) {
        try {
            dataProcessor.removeServerFromDb(serverName);
        } catch (InvalidEntityException e) {
            return e.getMessage();
        }
        return String.format("Successfully deleted configuration for server: %s", serverName);
    }
}