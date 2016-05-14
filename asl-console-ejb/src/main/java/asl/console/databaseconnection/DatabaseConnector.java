package asl.console.databaseconnection;

import asl.dto.ConfigurationVector;
import asl.dto.ServerDetailsDto;
import asl.exceptions.ConfigurationException;
import asl.exceptions.InvalidEntityException;

import javax.ejb.Local;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by sengir on 19.04.16.
 */
@Local
public interface DatabaseConnector {
    void storeInDb(Object object) throws InvalidEntityException, SQLException; //todo change method signature to more appropriate
    void deleteFromDb(Object object) throws InvalidEntityException;
    Object getFromDb(Object object) throws SQLException; //todo change method signature to more appropriate
    ConfigurationVector getConfigurationForServer(final String serverName) throws ConfigurationException;
    List<ServerDetailsDto> getServersByName(final String pattern) throws SQLException;
    List<ConfigurationVector> getConfigurationVectorsByName(final String pattern) throws SQLException; //to be deprecated!
}
