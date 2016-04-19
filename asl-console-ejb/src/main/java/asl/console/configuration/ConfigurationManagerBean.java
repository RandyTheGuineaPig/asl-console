package asl.console.configuration;

import asl.console.databaseconnection.DatabaseConnector;

import javax.ejb.EJB;
import javax.ejb.Stateless;

/**
 * Created by sengir on 19.04.16.
 */
@Stateless
public class ConfigurationManagerBean implements ConfigurationManager {
    @EJB
    private DatabaseConnector databaseConnector;

    @Override
    public Object retrieveConfiguration() {
        //todo implement actual logic
        return null;
    }

    @Override
    public void storeConfiguration(Object object) {
        //todo implement actual logic
    }
}
