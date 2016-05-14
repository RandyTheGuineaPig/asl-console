package asl.mock;

import asl.console.databaseconnection.DatabaseConnector;
import asl.dto.ConfigurationVector;
import asl.dto.ServerDetailsDto;
import asl.exceptions.ConfigurationException;
import asl.exceptions.InvalidEntityException;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import java.util.*;

/**
 * Created by sengir on 13.05.16.
 */
@Singleton
public class DatabaseConnectorMock implements DatabaseConnector {

    private Map<String, ConfigurationVector> configurations;
    private Map<String, ServerDetailsDto> servers;

    @PostConstruct
    public void init() {
        configurations = new LinkedHashMap<String, ConfigurationVector>();
        servers = new LinkedHashMap<String, ServerDetailsDto>();
        for (int i = 1; i < 10; ++i) {
            final String serverName = "Server_" + i;
            final ServerDetailsDto serverDetailsDto = prepareServerDetailsDto(serverName);
            serverDetailsDto.setIpAddress("192.168.0." + i);
            servers.put(serverName, serverDetailsDto);
            configurations.put(serverName, prepareConfigurationVector(serverName));
        }
        final ServerDetailsDto defaultServer = prepareServerDetailsDto("Default_Server");
        defaultServer.setIpAddress("127.0.0.1");
        servers.put("Default_Server", defaultServer);
    }

    @Override
    public void storeInDb(Object object) throws InvalidEntityException {
        if (object instanceof ServerDetailsDto) {
            servers.put(((ServerDetailsDto) object).getServerName(), (ServerDetailsDto) object);
        } else if (object instanceof ConfigurationVector) {
            configurations.put(((ConfigurationVector) object).getServerName(), (ConfigurationVector) object);
        } else {
            throw new InvalidEntityException("Provided object cannot be stored in database");
        }
    }

    @Override
    public Object getFromDb(Object object) {
        return null;
    }

    @Override
    public ConfigurationVector getConfigurationForServer(String serverName) throws ConfigurationException {
        final ConfigurationVector configurationVector = configurations.get(serverName);
        if (configurationVector == null) {
            throw new ConfigurationException("Configuration for " + serverName + " not found");
        }
        return configurationVector;
    }

    @Override
    public List<ServerDetailsDto> getServersByName(String pattern) {
        final List<ServerDetailsDto> serverDetailsDtos = new ArrayList<ServerDetailsDto>();
        for (final String serverName : servers.keySet()) {
            if (serverName.matches(pattern)) {
                serverDetailsDtos.add(servers.get(serverName));
            }
        }
        return serverDetailsDtos;
    }

    @Override
    public List<ConfigurationVector> getConfigurationVectorsByName(String pattern) {
        final List<ConfigurationVector> configurationVectors = new ArrayList<ConfigurationVector>();
        for (final String serverName : configurations.keySet()) {
            if (serverName.matches(pattern)) {
                configurationVectors.add(configurations.get(serverName));
            }
        }
        return configurationVectors;
    }

    private ServerDetailsDto prepareServerDetailsDto(final String serverName) {
        final ServerDetailsDto serverDetailsDto = new ServerDetailsDto();
        serverDetailsDto.setServerName(serverName);
        serverDetailsDto.setTemperature(new Random().nextDouble() * 150);
        return  serverDetailsDto;
    }

    private ConfigurationVector prepareConfigurationVector(final String serverName) {
        final ConfigurationVector configurationVector = new ConfigurationVector();
        configurationVector.setServerName(serverName);
        configurationVector.setTemperatureYellowUpperBound(new Random().nextDouble() * 150);
        configurationVector.setTemperatureGreenUpperBound(new Random().nextDouble() * configurationVector.getTemperatureYellowUpperBound());
        return configurationVector;
    }
}
