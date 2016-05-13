package asl.dto;

import asl.util.ParameterColor;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by sengir on 13.05.16.
 */
@Entity
public class ConfigurationVector { //info from database
    @Id
    private String serverName;

    private double temperatureGreenUpperBound;
    private double temperatureYellowUpperBound;
    public ServerStateDto applyTo(final ServerDetailsDto serverDetailsDto) {
        final ServerStateDto serverStateDto = new ServerStateDto();
        serverStateDto.setServerName(serverDetailsDto.getServerName());
        final double temperature = serverDetailsDto.getTemperature();
        if (temperature > temperatureYellowUpperBound) {
            serverStateDto.setTemperature(ParameterColor.RED);
        } else if (temperature > temperatureGreenUpperBound) {
            serverStateDto.setTemperature(ParameterColor.YELLOW);
        } else {
            serverStateDto.setTemperature(ParameterColor.GREEN);
        }
        return serverStateDto;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public double getTemperatureGreenUpperBound() {
        return temperatureGreenUpperBound;
    }

    public void setTemperatureGreenUpperBound(double temperatureGreenUpperBound) {
        this.temperatureGreenUpperBound = temperatureGreenUpperBound;
    }

    public double getTemperatureYellowUpperBound() {
        return temperatureYellowUpperBound;
    }

    public void setTemperatureYellowUpperBound(double temperatureYellowUpperBound) {
        this.temperatureYellowUpperBound = temperatureYellowUpperBound;
    }

    @Override
    public String toString() {
        return "ConfigurationVector{" +
                "serverName='" + serverName + '\'' +
                ", temperatureGreenUpperBound=" + temperatureGreenUpperBound +
                ", temperatureYellowUpperBound=" + temperatureYellowUpperBound +
                '}';
    }
}
