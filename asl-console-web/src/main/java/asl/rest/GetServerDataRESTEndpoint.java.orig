package asl.rest;

import asl.console.dataprocessing.DataProcessor;

import javax.inject.Inject;
import javax.ws.rs.*;

/**
 * Created by sengir on 10.05.16.
 */
@Path("/monitored")
public class GetServerDataRESTEndpoint {

    @Inject
    private DataProcessor dataProcessor;

    @GET
    @Path("/")
    @Produces("text/plain")
    public String getServers() {
        return dataProcessor.getServers().toString();
    }

    @GET
    @Path("/{serverName}")
    @Produces("text/plain")
    public String getServerDetails(@PathParam("serverName") final String serverName) {
        return dataProcessor.getServerDetails(serverName).toString();
    }

}
