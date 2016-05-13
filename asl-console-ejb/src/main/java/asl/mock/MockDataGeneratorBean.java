package asl.mock;

import asl.dto.ConfigurationVector;
import asl.dto.ServerDetailsDto;

import javax.ejb.Stateless;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by sengir on 19.04.16.
 */
@Stateless
public class MockDataGeneratorBean implements MockDataGenerator {
    @Override
    public String getData() {
        return "Hey, it's dummy data!";
    }

    @Override
    public List<ServerDetailsDto> getServers() {
        final List<ServerDetailsDto> servers = new ArrayList<ServerDetailsDto>();
        for (int i = 1; i < 6; ++i) {
            servers.add(prepareServerStateDto("Server " + i));
        }
        return servers;
    }

    @Override
    public ServerDetailsDto getServerDetails(final String serverName) {
        final ServerDetailsDto serverDetailsDto = new ServerDetailsDto();
        serverDetailsDto.setServerName(serverName);
        serverDetailsDto.setTemperature(116.5);
        return serverDetailsDto;
    }

    @Override
    public ConfigurationVector getConfiguration(final String serverName) {
        final ConfigurationVector configurationVector = new ConfigurationVector();
        configurationVector.setServerName(serverName);
        configurationVector.setTemperatureGreenUpperBound(60.0);
        configurationVector.setTemperatureYellowUpperBound(80.0);
        return configurationVector;
    }

    private ServerDetailsDto prepareServerStateDto(final String name) {
        final ServerDetailsDto serverStateDto = new ServerDetailsDto();
        serverStateDto.setServerName(name);
        serverStateDto.setTemperature(66.2);
        return serverStateDto;
    }
}
