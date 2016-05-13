package asl.mock;

import asl.dto.ConfigurationVector;
import asl.dto.ServerDetailsDto;

import javax.ejb.Local;
import java.util.List;

/**
 * Created by sengir on 19.04.16.
 */
@Local
public interface MockDataGenerator {
    String getData();
    List<ServerDetailsDto> getServers();
    ServerDetailsDto getServerDetails(final String serverName);
    ConfigurationVector getConfiguration(final String serverName);
}
