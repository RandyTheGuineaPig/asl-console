package asl.console.configuration;

import javax.ejb.Local;

/**
 * Created by sengir on 19.04.16.
 */
@Local
public interface ConfigurationManager {
    Object retrieveConfiguration(); //todo change return type to something more appropriate
    void storeConfiguration(Object object); //todo change parameter type to something more appropriate
}
