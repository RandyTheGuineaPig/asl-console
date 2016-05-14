package asl.rest;

import asl.console.dataprocessing.DataProcessor;
import asl.dto.ServerStateDto;

import javax.inject.Inject;
import javax.ws.rs.*;
import java.util.List;

import asl.util.JsonBuilder;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
        return JsonBuilder.prepareJson(dataProcessor.getServers());
    }

    @GET
    @Path("/{serverName}")
    @Produces("text/plain")
    public String getServerDetails(@PathParam("serverName") final String serverName) {
        return JsonBuilder.prepareJson(dataProcessor.getServerDetails(serverName));
    }

}
