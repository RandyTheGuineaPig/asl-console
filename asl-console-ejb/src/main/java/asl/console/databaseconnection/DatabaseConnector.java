package asl.console.databaseconnection;

import asl.dto.ConfigurationVector;
import asl.dto.ServerDetailsDto;
import asl.exceptions.ConfigurationNotFoundException;
import asl.exceptions.InvalidEntityException;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by sengir on 19.04.16.
 */
@Local
public interface DatabaseConnector {
    void storeInDb(Object object) throws InvalidEntityException; //todo change method signature to more appropriate
    Object getFromDb(Object object); //todo change method signature to more appropriate
    ConfigurationVector getConfigurationForServer(final String serverName) throws ConfigurationNotFoundException;
    List<ServerDetailsDto> getServersByName(final String pattern);
    List<ConfigurationVector> getConfigurationVectorsByName(final String pattern); //to be deprecated!
}
