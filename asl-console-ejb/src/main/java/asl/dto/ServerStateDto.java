package asl.dto;

import asl.util.ParameterColor;

/**
 * Created by sengir on 13.05.16.
 */
public class ServerStateDto {
    //todo insert appropriate fields
    private String serverName;
    private ParameterColor temperature;

    public static ServerStateDto getDefaultServerStateDto() {
        final ServerStateDto defaultServerStateDto = new ServerStateDto();
        defaultServerStateDto.setTemperature(ParameterColor.GREEN);
        return defaultServerStateDto;
    }

    public ParameterColor getTemperature() {
        return temperature;
    }

    public void setTemperature(ParameterColor temperature) {
        this.temperature = temperature;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    @Override
    public String toString() {
        return "ServerStateDto{" +
                "serverName='" + serverName + '\'' +
                ", temperature=" + temperature +
                '}';
    }
}
