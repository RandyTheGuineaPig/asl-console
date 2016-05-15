package asl.console.dataprocessing;

import asl.dto.ConfigurationVector;
import asl.dto.ServerDetailsDto;
import asl.dto.ServerStateDto;
import asl.exceptions.InvalidEntityException;

import javax.ejb.Local;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by sengir on 19.04.16.
 */
@Local
public interface DataProcessor {
    void storeDataInDb(Object data) throws InvalidEntityException, SQLException; //todo change parameter and return types to more appropriate ones
    void removeDataFromDb(Object data) throws InvalidEntityException, SQLException;
    void removeServerFromDb(String serverName) throws InvalidEntityException, SQLException;
    void removeConfigurationFromDb(String serverName) throws InvalidEntityException, SQLException;
    Object retrieveDataFromDb(); //todo change parameter and return types to more appropriate ones
    void addServer(final String serverName, final String ipAddress) throws InvalidEntityException, SQLException;
    List<ServerStateDto> getServers() throws SQLException;
    ServerDetailsDto getServerDetails(String serverName) throws SQLException;
    List<ConfigurationVector> getConfigurations() throws SQLException; //todo change parameter and return types to more appropriate ones
    Object processData(Object data); //todo change parameter and return types to more appropriate ones
}
