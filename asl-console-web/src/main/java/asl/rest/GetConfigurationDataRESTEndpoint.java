package asl.rest;

import asl.console.dataprocessing.DataProcessor;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created by sengir on 14.05.16.
 */
@Path("/configuration")
public class GetConfigurationDataRESTEndpoint {
    @EJB
    private DataProcessor dataProcessor;

    @GET
    @Produces("text/plain")
    public String getConfigurations() {
        return dataProcessor.getConfigurations().toString();
    }
}
