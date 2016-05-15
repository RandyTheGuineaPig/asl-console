package asl.dto;

import asl.util.ParameterColor;

/**
 * Created by sengir on 13.05.16.
 */
public class ServerStateDto {
    //todo insert appropriate fields
    private String serverName;
    private ParameterColor temperature;
    private ParameterColor cpuLoad;
    private ParameterColor bandwidth;
    private ParameterColor iops;
    private ParameterColor ramLoad;

    public static ServerStateDto getDefaultServerStateDto() {
        final ServerStateDto defaultServerStateDto = new ServerStateDto();
        defaultServerStateDto.setTemperature(ParameterColor.GREEN);
        defaultServerStateDto.setCpuLoad(ParameterColor.GREEN);
        defaultServerStateDto.setBandwidth(ParameterColor.GREEN);
        defaultServerStateDto.setIops(ParameterColor.GREEN);
        defaultServerStateDto.setRamLoad(ParameterColor.GREEN);
        return defaultServerStateDto;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public ParameterColor getTemperature() {
        return temperature;
    }

    public void setTemperature(ParameterColor temperature) {
        this.temperature = temperature;
    }

    public ParameterColor getCpuLoad() {
        return cpuLoad;
    }

    public void setCpuLoad(ParameterColor cpuLoad) {
        this.cpuLoad = cpuLoad;
    }

    public ParameterColor getBandwidth() {
        return bandwidth;
    }

    public void setBandwidth(ParameterColor bandwidth) {
        this.bandwidth = bandwidth;
    }

    public ParameterColor getIops() {
        return iops;
    }

    public void setIops(ParameterColor iops) {
        this.iops = iops;
    }

    public ParameterColor getRamLoad() {
        return ramLoad;
    }

    public void setRamLoad(ParameterColor ramLoad) {
        this.ramLoad = ramLoad;
    }

    @Override
    public String toString() {
        return "ServerStateDto{" +
                "serverName='" + serverName + '\'' +
                ", temperature=" + temperature +
                ", cpuLoad=" + cpuLoad +
                ", bandwidth=" + bandwidth +
                ", iops=" + iops +
                ", ramLoad=" + ramLoad +
                '}';
    }
}
