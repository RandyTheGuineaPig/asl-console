package asl.rest;

import asl.console.dataprocessing.DataProcessor;
import asl.exceptions.ConfigurationException;
import asl.exceptions.InvalidEntityException;
import asl.util.JsonBuilder;

import javax.ejb.EJB;
import javax.ws.rs.*;
import java.sql.SQLException;

/**
 * Created by sengir on 14.05.16.
 */
@Path("/configuration")
public class ConfigurationDataRESTEndpoint {
    @EJB
    private DataProcessor dataProcessor;


    @GET
    @Path("/get")
    @Produces("text/plain")
    public String getConfigurations() {
        try {
            return JsonBuilder.prepareJson(dataProcessor.getConfigurations());
        } catch (SQLException e) {
            return "Oops, something went terribly wong!";
        }
    }

    @GET
    @Path("/store")
    public String addConfiguration(@QueryParam("serverName") String serverName, @QueryParam("config") String config) { //remember! URI has to have { replaced with %7B and } with %7D
        try {
            dataProcessor.storeDataInDb(JsonBuilder.prepareConfigurationVector(config));
        } catch (InvalidEntityException e) {
            return e.getMessage();
        } catch (ConfigurationException e) {
            return e.getMessage();
        } catch (SQLException e) {
            return e.getMessage();
        }
        return String.format("Successfully added configuration for server: %s", serverName);
    }

    @GET
    @Path("/delete")
    @Produces("text/plain")
    public String deleteConfiguration(@QueryParam("serverName") final String serverName) {
        try {
            dataProcessor.removeConfigurationFromDb(serverName);
        } catch (InvalidEntityException e) {
            return e.getMessage();
        } catch (SQLException e) {
            return e.getMessage();
        }
        return String.format("Successfully deleted configuration for server: %s", serverName);
    }
}
