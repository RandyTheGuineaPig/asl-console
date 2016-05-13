package asl.rest;

import asl.console.dataprocessing.DataProcessor;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 * Created by sengir on 10.05.16.
 */
@Path("/monitored")
public class RestEndpoint {

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

    @GET
    @Path("/configurations")
    @Produces("text/plain")
    public String getConfigurations() { //MOVE to other class - avoid URI collision (ie. server named "configurations")
        return dataProcessor.getConfigurations().toString();
    }
}
