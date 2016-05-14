package asl.dto;

import asl.util.ParameterColor;

import javax.persistence.Entity;
import javax.persistence.Id;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;

/**
 * Created by sengir on 13.05.16.
 */
@Entity
public class ConfigurationVector { //info from database
    @Id
    private String serverName;
    private double temperatureGreenUpperBound; //todo change those to Doubles and Integers - null values mean no constraint
    private double temperatureYellowUpperBound;
    private double cpuLoadGreenUpperBound;
    private double cpuLoadYellowUpperBound;
    private double bandwidthGreenUpperBound;
    private double bandwidthYellowUpperBound;
    private int iopsGreenUpperBound;
    private int iopsYellowUpperBound;
    private double ramLoadGreenUpperBound;
    private double ramLoadYellowUpperBound;

    public ServerStateDto applyTo(final ServerDetailsDto serverDetailsDto) {
        final ServerStateDto serverStateDto = new ServerStateDto();
        serverStateDto.setServerName(serverDetailsDto.getServerName());

        updateTemperature(serverDetailsDto, serverStateDto);
        updateCpuLoad(serverDetailsDto, serverStateDto);
        updateBandwidth(serverDetailsDto, serverStateDto);
        updateIops(serverDetailsDto, serverStateDto);
        updateRamLoad(serverDetailsDto, serverStateDto);

        return serverStateDto;
    }

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public Double getTemperatureGreenUpperBound() {
        return temperatureGreenUpperBound;
    }

    public void setTemperatureGreenUpperBound(Double temperatureGreenUpperBound) {
        this.temperatureGreenUpperBound = temperatureGreenUpperBound;
    }

    public Double getTemperatureYellowUpperBound() {
        return temperatureYellowUpperBound;
    }

    public void setTemperatureYellowUpperBound(Double temperatureYellowUpperBound) {
        this.temperatureYellowUpperBound = temperatureYellowUpperBound;
    }

    public Double getCpuLoadGreenUpperBound() {
        return cpuLoadGreenUpperBound;
    }

    public void setCpuLoadGreenUpperBound(Double cpuLoadGreenUpperBound) {
        this.cpuLoadGreenUpperBound = cpuLoadGreenUpperBound;
    }

    public Double getCpuLoadYellowUpperBound() {
        return cpuLoadYellowUpperBound;
    }

    public void setCpuLoadYellowUpperBound(Double cpuLoadYellowUpperBound) {
        this.cpuLoadYellowUpperBound = cpuLoadYellowUpperBound;
    }

    public Double getBandwidthGreenUpperBound() {
        return bandwidthGreenUpperBound;
    }

    public void setBandwidthGreenUpperBound(Double bandwidthGreenUpperBound) {
        this.bandwidthGreenUpperBound = bandwidthGreenUpperBound;
    }

    public Double getBandwidthYellowUpperBound() {
        return bandwidthYellowUpperBound;
    }

    public void setBandwidthYellowUpperBound(Double bandwidthYellowUpperBound) {
        this.bandwidthYellowUpperBound = bandwidthYellowUpperBound;
    }

    public Integer getIopsGreenUpperBound() {
        return iopsGreenUpperBound;
    }

    public void setIopsGreenUpperBound(Integer iopsGreenUpperBound) {
        this.iopsGreenUpperBound = iopsGreenUpperBound;
    }

    public Integer getIopsYellowUpperBound() {
        return iopsYellowUpperBound;
    }

    public void setIopsYellowUpperBound(Integer iopsYellowUpperBound) {
        this.iopsYellowUpperBound = iopsYellowUpperBound;
    }

    public Double getRamLoadGreenUpperBound() {
        return ramLoadGreenUpperBound;
    }

    public void setRamLoadGreenUpperBound(Double ramLoadGreenUpperBound) {
        this.ramLoadGreenUpperBound = ramLoadGreenUpperBound;
    }

    public Double getRamLoadYellowUpperBound() {
        return ramLoadYellowUpperBound;
    }

    public void setRamLoadYellowUpperBound(Double ramLoadYellowUpperBound) {
        this.ramLoadYellowUpperBound = ramLoadYellowUpperBound;
    }

    @Override
    public String toString() {
        return "ConfigurationVector{" +
                "serverName='" + serverName + '\'' +
                ", temperatureGreenUpperBound=" + temperatureGreenUpperBound +
                ", temperatureYellowUpperBound=" + temperatureYellowUpperBound +
                ", cpuLoadGreenUpperBound=" + cpuLoadGreenUpperBound +
                ", cpuLoadYellowUpperBound=" + cpuLoadYellowUpperBound +
                ", bandwidthGreenUpperBound=" + bandwidthGreenUpperBound +
                ", bandwidthYellowUpperBound=" + bandwidthYellowUpperBound +
                ", iopsGreenUpperBound=" + iopsGreenUpperBound +
                ", iopsYellowUpperBound=" + iopsYellowUpperBound +
                ", ramLoadGreenUpperBound=" + ramLoadGreenUpperBound +
                ", ramLoadYellowUpperBound=" + ramLoadYellowUpperBound +
                '}';
    }

    private void updateTemperature(final ServerDetailsDto details, final ServerStateDto state) {
        final double temperature = details.getTemperature();
        if (temperature > temperatureYellowUpperBound) {
            state.setTemperature(ParameterColor.RED);
        } else if (temperature > temperatureGreenUpperBound) {
            state.setTemperature(ParameterColor.YELLOW);
        } else {
            state.setTemperature(ParameterColor.GREEN);
        }
    }

    private void updateCpuLoad(final ServerDetailsDto details, final ServerStateDto state) {
        final double cpuLoad = details.getCpuLoad();
        if (cpuLoad > cpuLoadYellowUpperBound) {
            state.setCpuLoad(ParameterColor.RED);
        } else if (cpuLoad > cpuLoadGreenUpperBound) {
            state.setCpuLoad(ParameterColor.YELLOW);
        } else {
            state.setCpuLoad(ParameterColor.GREEN);
        }
    }

    private void updateBandwidth(final ServerDetailsDto details, final ServerStateDto state) {
        final double bandwidth = details.getBandwidth();
        if (bandwidth > bandwidthYellowUpperBound) {
            state.setBandwidth(ParameterColor.RED);
        } else if (bandwidth > bandwidthGreenUpperBound) {
            state.setBandwidth(ParameterColor.YELLOW);
        } else {
            state.setBandwidth(ParameterColor.GREEN);
        }
    }

    private void updateIops(final ServerDetailsDto details, final ServerStateDto state) {
        final int iops = details.getIops();
        if (iops > iopsYellowUpperBound) {
            state.setIops(ParameterColor.RED);
        } else if (iops > iopsGreenUpperBound) {
            state.setIops(ParameterColor.YELLOW);
        } else {
            state.setIops(ParameterColor.GREEN);
        }
    }

    private void updateRamLoad(final ServerDetailsDto details, final ServerStateDto state) {
        final double ramLoad = details.getRamLoad();
        if (ramLoad > ramLoadYellowUpperBound) {
            state.setRamLoad(ParameterColor.RED);
        } else if (ramLoad > ramLoadGreenUpperBound) {
            state.setRamLoad(ParameterColor.YELLOW);
        } else {
            state.setRamLoad(ParameterColor.GREEN);
        }
    }

}
