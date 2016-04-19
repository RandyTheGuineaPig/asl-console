package asl.console.dataprocessing;

import asl.console.configuration.ConfigurationManager;
import asl.console.databaseconnection.DatabaseConnector;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Created by sengir on 19.04.16.
 */
@Stateless
public class DataProcessorBean implements DataProcessor {
    @EJB
    private DatabaseConnector databaseConnector;

    @EJB
    private ConfigurationManager configurationManager;

    @Override
    public void storeDataInDb(Object data) {
        //todo implement actual logic
    }

    @Override
    public Object retrieveDataFromDb() {
        //todo implement actual logic
        return null;
    }

    @Override
    public Object getConfiguration() {
        //todo implement actual logic
        return null;
    }

    @Override
    public Object processData(Object data) {
        //todo implement actual logic
        return null;
    }
}
