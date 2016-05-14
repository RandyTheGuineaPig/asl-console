package asl.mock;

import asl.console.databaseconnection.DatabaseConnector;
import asl.dto.ConfigurationVector;
import asl.dto.ServerDetailsDto;
import asl.exceptions.ConfigurationException;
import asl.exceptions.InvalidEntityException;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import java.sql.*;
import java.util.*;


/**
 * Created by sengir on 13.05.16.
 */
@Singleton
public class DatabaseConnectorMock implements DatabaseConnector {

    //todo fuck those out
    private Map<String, ConfigurationVector> configurations;
    private Map<String, ServerDetailsDto> servers;

    private Connection connection;
    private Statement statement;

    @PostConstruct
    public void init() {
        /*here goes db connection*/
        try {
            Class.forName("org.h2.Driver");
            connection = DriverManager.getConnection("jdbc:h2:~/test", "admin", "admin");
            statement = connection.createStatement();
            statement.executeUpdate("DROP TABLE IF EXISTS SERVERS");
            statement.executeUpdate("DROP TABLE IF EXISTS CONFIGURATIONS");
            final String prepareServersTable = prepareCreateServersTableQuery();
            final String prepareConfigurationsTable = prepareCreateConfigurationsTableQuery();
            statement.executeUpdate(prepareServersTable);
            statement.executeUpdate(prepareConfigurationsTable);
            insertDummyData();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

//        //the below to be fucked out
//        configurations = new LinkedHashMap<String, ConfigurationVector>();
//        servers = new LinkedHashMap<String, ServerDetailsDto>();
//        for (int i = 1; i < 2; ++i) {
//            final String serverName = "Server_" + i;
//            final ServerDetailsDto serverDetailsDto = prepareServerDetailsDto(serverName);
//            serverDetailsDto.setIpAddress("192.168.0." + i);
//            servers.put(serverName, serverDetailsDto);
//            configurations.put(serverName, prepareConfigurationVector(serverName));
//        }
//        final ServerDetailsDto defaultServer = prepareServerDetailsDto("Default_Server");
//        defaultServer.setIpAddress("127.0.0.1");
//        servers.put("Default_Server", defaultServer);
    }

    @Override
    public void storeInDb(Object object) throws InvalidEntityException, SQLException {
        if (object instanceof ServerDetailsDto) {
            statement.executeUpdate(prepareInsertQuery((ServerDetailsDto) object));
//            servers.put(((ServerDetailsDto) object).getServerName(), (ServerDetailsDto) object);
        } else if (object instanceof ConfigurationVector) {
            statement.executeUpdate(prepareInsertQuery((ConfigurationVector) object));
//            configurations.put(((ConfigurationVector) object).getServerName(), (ConfigurationVector) object);
        } else {
            throw new InvalidEntityException("Provided object cannot be stored in database");
        }
    }

    @Override
    public void deleteFromDb(Object object) throws InvalidEntityException {
        if (object instanceof ServerDetailsDto) {
            servers.remove(((ServerDetailsDto) object).getServerName());
        } else if (object instanceof ConfigurationVector) {
            configurations.remove(((ConfigurationVector) object).getServerName());
        } else {
            throw new InvalidEntityException("Provided object could not be removed from database because it is not a valid object");
        }
    }

    @Override
    public Object getFromDb(Object object) throws SQLException {
        if (object instanceof ServerDetailsDto) {
            ResultSet rs = statement.executeQuery("SELECT * FROM SERVERS WHERE serverName LIKE '" + ((ServerDetailsDto) object).getServerName() + "'");
        } else if (object instanceof ConfigurationVector) {
            ResultSet rs = statement.executeQuery("SELECT * FROM CONFIGURATIONS WHERE serverName LIKE '" + ((ConfigurationVector) object).getServerName() + "'");
        }
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
    public List<ServerDetailsDto> getServersByName(String pattern) throws SQLException {
        final ResultSet resultSet = statement.executeQuery("SELECT * FROM SERVERS WHERE serverName LIKE '%" + pattern + "'");
        final List<ServerDetailsDto> serverDetailsDtos = createServerDetailsFromResultSet(resultSet);
        return serverDetailsDtos;
    }

    @Override
    public List<ConfigurationVector> getConfigurationVectorsByName(String pattern) throws SQLException {
        final ResultSet resultSet = statement.executeQuery("SELECT * FROM CONFIGURATIONS WHERE serverName LIKE '%" + pattern + "'");
        final List<ConfigurationVector> configurationVectors = createConfigurationVectorsFromResultSet(resultSet);
//        for (final String serverName : configurations.keySet()) {
//            if (serverName.matches(pattern)) {
//                configurationVectors.add(configurations.get(serverName));
//            }
//        }
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

    private String prepareCreateServersTableQuery() {
        return "CREATE TABLE IF NOT EXISTS SERVERS ("
                + "serverName varchar(255) not null, "
                + "ipAddress varchar(15) not null, "
                + "temperature decimal(5,2), "
                + "cpuLoad decimal(4,2), "
                + "bandwidth decimal(7,2), "
                + "iops int, "
                + "ramLoad decimal(4,2), "
                + "PRIMARY KEY (serverName)"
                + ")";
    }

    private String prepareCreateConfigurationsTableQuery() {
        return "CREATE TABLE IF NOT EXISTS CONFIGURATIONS ("
                + "serverName varchar(255) not null, "
                + "temperatureUpperGreenBound decimal(5,2), "
                + "temperatureUpperYellowBound decimal(5,2), "
                + "cpuLoadUpperGreenBound decimal(4,2), "
                + "cpuLoadUpperYellowBound decimal(4,2), "
                + "bandwidthUpperGreenBound decimal(7,2), "
                + "bandwidthUpperYellowBound decimal(7,2), "
                + "iopsUpperGreenBound int, "
                + "iopsUpperYellowBound int, "
                + "ramLoadUpperGreenBound decimal(4,2), "
                + "ramLoadUpperYellowBound decimal(4,2), "
                + "PRIMARY KEY (serverName)"
                + ")";
    }

    //todo remove its usages in production code
    private void insertDummyData() throws SQLException, InvalidEntityException {
        for (int i = 1; i < 10; ++i) {
            final String serverName = "Server_" + i;
            final ServerDetailsDto serverDetailsDto = prepareServerDetailsDto(serverName);
            serverDetailsDto.setIpAddress("192.168.0." + i);
            final ConfigurationVector configurationVector = prepareConfigurationVector(serverName);
            storeInDb(serverDetailsDto);
            storeInDb(configurationVector);
        }
    }

    private String prepareInsertQuery(final ServerDetailsDto serverDetailsDto) {
        return String.format("INSERT INTO SERVERS (serverName, ipAddress, temperature, cpuLoad, bandwidth, iops, ramLoad) VALUES ('%s', '%s', '0.00', '0.00', '0.00', '0', '0.00')", serverDetailsDto.getServerName(), serverDetailsDto.getIpAddress());
    }

    private String prepareInsertQuery(final ConfigurationVector configurationVector) {
        return "INSERT INTO CONFIGURATIONS (serverName, temperatureUpperGreenBound, temperatureUpperYellowBound, cpuLoadUpperGreenBound, cpuLoadUpperYellowBound, bandwidthUpperGreenBound, bandwidthUpperYellowBound, iopsUpperGreenBound, iopsUpperYellowBound, ramLoadUpperGreenBound, ramLoadUpperYellowBound) VALUES ('"
                + configurationVector.getServerName()
                + "','"
                + configurationVector.getTemperatureGreenUpperBound()
                + "','"
                + configurationVector.getTemperatureYellowUpperBound()
                + "','"
                + configurationVector.getCpuLoadGreenUpperBound()
                + "','"
                + configurationVector.getCpuLoadYellowUpperBound()
                + "','"
                + configurationVector.getBandwidthGreenUpperBound()
                + "','"
                + configurationVector.getBandwidthYellowUpperBound()
                + "','"
                + configurationVector.getIopsGreenUpperBound()
                + "','"
                + configurationVector.getIopsYellowUpperBound()
                + "','"
                + configurationVector.getRamLoadGreenUpperBound()
                + "','"
                + configurationVector.getRamLoadYellowUpperBound()
                + "')";
    }

    private List<ServerDetailsDto> createServerDetailsFromResultSet(final ResultSet resultSet) throws SQLException {
        final List<ServerDetailsDto> serverDetailsDtos = new ArrayList<ServerDetailsDto>();
        while (resultSet.next()) {
            final ServerDetailsDto serverDetailsDto = new ServerDetailsDto();
            serverDetailsDto.setServerName(resultSet.getString(1));
            serverDetailsDto.setIpAddress(resultSet.getString(2));
            serverDetailsDto.setTemperature(Double.parseDouble(resultSet.getString(3)));
            serverDetailsDto.setCpuLoad(Double.parseDouble(resultSet.getString(4)));
            serverDetailsDto.setBandwidth(Double.parseDouble(resultSet.getString(5)));
            serverDetailsDto.setIops(Integer.parseInt(resultSet.getString(6)));
            serverDetailsDto.setRamLoad(Double.parseDouble(resultSet.getString(7)));
            serverDetailsDtos.add(serverDetailsDto);
        }
        return serverDetailsDtos;
    }

    private List<ConfigurationVector> createConfigurationVectorsFromResultSet(final ResultSet resultSet) throws SQLException {
        final List<ConfigurationVector> configurationVectors = new ArrayList<ConfigurationVector>();
        while (resultSet.next()) {
            final ConfigurationVector configurationVector = new ConfigurationVector();
            configurationVector.setServerName(resultSet.getString(1));
            configurationVector.setTemperatureGreenUpperBound(Double.parseDouble(resultSet.getString(2)));
            configurationVector.setTemperatureYellowUpperBound(Double.parseDouble(resultSet.getString(3)));
            configurationVector.setCpuLoadGreenUpperBound(Double.parseDouble(resultSet.getString(4)));
            configurationVector.setCpuLoadYellowUpperBound(Double.parseDouble(resultSet.getString(5)));
            configurationVector.setBandwidthGreenUpperBound(Double.parseDouble(resultSet.getString(6)));
            configurationVector.setBandwidthYellowUpperBound(Double.parseDouble(resultSet.getString(7)));
            configurationVector.setIopsGreenUpperBound(Integer.parseInt(resultSet.getString(8)));
            configurationVector.setIopsYellowUpperBound(Integer.parseInt(resultSet.getString(9)));
            configurationVector.setRamLoadGreenUpperBound(Double.parseDouble(resultSet.getString(10)));
            configurationVector.setRamLoadYellowUpperBound(Double.parseDouble(resultSet.getString(11)));
            configurationVectors.add(configurationVector);
        }
        return configurationVectors;
    }
}
