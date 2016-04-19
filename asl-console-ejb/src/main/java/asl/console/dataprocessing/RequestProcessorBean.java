package asl.console.dataprocessing;

import asl.console.configuration.ConfigurationManager;
import asl.console.connectionmanagement.RequestSender;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Created by sengir on 19.04.16.
 */
@Stateless
public class RequestProcessorBean implements RequestProcessor {
    @EJB
    private RequestSender requestSender;

    @EJB
    private ConfigurationManager configurationManager;

    @Override
    public void prepareRequest() {
        //todo implement retrieving info about requested data
    }
}
