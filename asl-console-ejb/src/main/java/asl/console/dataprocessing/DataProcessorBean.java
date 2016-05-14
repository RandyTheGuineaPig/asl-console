package asl.console.dataprocessing;

import asl.console.configuration.ConfigurationManager;
import asl.console.databaseconnection.DatabaseConnector;
import asl.exceptions.InvalidEntityException;
import asl.dto.ConfigurationVector;
import asl.dto.ServerDetailsDto;
import asl.dto.ServerStateDto;


import javax.ejb.EJB;
import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

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
    public void storeDataInDb(Object data) throws InvalidEntityException {
        databaseConnector.storeInDb(data);
    }

    @Override
    public void removeDataFromDb(Object data) throws InvalidEntityException {
        databaseConnector.deleteFromDb(data);
    }

    @Override
    public void removeServerFromDb(String serverName) throws InvalidEntityException {
        final ServerDetailsDto serverDetailsDto = new ServerDetailsDto();
        serverDetailsDto.setServerName(serverName);
        databaseConnector.deleteFromDb(serverDetailsDto);
    }

    @Override
    public void removeConfigurationFromDb(String serverName) throws InvalidEntityException {
        final ConfigurationVector configurationVector = new ConfigurationVector();
        configurationVector.setServerName(serverName);
        databaseConnector.deleteFromDb(configurationVector);
    }

    @Deprecated
    @Override
    public Object retrieveDataFromDb() {
        //todo implement actual logic
        return null;
    }

    @Override
    public List<ServerStateDto> getServers() {
        final List<ServerStateDto> servers = new ArrayList<ServerStateDto>();
        for (final ServerDetailsDto serverDetailsDto : databaseConnector.getServersByName(".*")) {
            final String serverName = serverDetailsDto.getServerName();
            ServerStateDto serverStateDto;
            final List<ConfigurationVector> matchingConfigurationVectors = databaseConnector.getConfigurationVectorsByName(serverName);
            if (matchingConfigurationVectors.size() == 1) {
                final ConfigurationVector configurationVector = matchingConfigurationVectors.get(0);
                serverStateDto = configurationVector.applyTo(serverDetailsDto);
            } else {
                serverStateDto = ServerStateDto.getDefaultServerStateDto();
                serverStateDto.setServerName(serverName);
            }
            servers.add(serverStateDto);
        }
        return servers;
    }

    @Override
    public ServerDetailsDto getServerDetails(final String serverName) {
        return databaseConnector.getServersByName(serverName).get(0);
    }

    @Override
    public List<ConfigurationVector> getConfigurations() {
        return databaseConnector.getConfigurationVectorsByName(".*");
    }

    @Override
    public void addServer(String serverName, String ipAddress) throws InvalidEntityException {
        final ServerDetailsDto serverDetailsDto = new ServerDetailsDto();
        serverDetailsDto.setServerName(serverName);
        serverDetailsDto.setIpAddress(ipAddress);
        databaseConnector.storeInDb(serverDetailsDto);
    }

    @Override
    public Object processData(Object data) {
        //todo implement actual logic
        return null;
    }
}
