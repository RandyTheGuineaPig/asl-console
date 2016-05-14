package asl.dto;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Created by sengir on 13.05.16.
 */
@Entity
public class ServerDetailsDto {
    @Id
    private String serverName;
    private String ipAddress;
    private double temperature;
    private double cpuLoad;
    private double bandwidth;
    private int iops;
    private double ramLoad;

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    public double getCpuLoad() {
        return cpuLoad;
    }

    public void setCpuLoad(double cpuLoad) {
        this.cpuLoad = cpuLoad;
    }

    public double getBandwidth() {
        return bandwidth;
    }

    public void setBandwidth(double bandwidth) {
        this.bandwidth = bandwidth;
    }

    public int getIops() {
        return iops;
    }

    public void setIops(int iops) {
        this.iops = iops;
    }

    public double getRamLoad() {
        return ramLoad;
    }

    public void setRamLoad(double ramLoad) {
        this.ramLoad = ramLoad;
    }

    @Override
    public String toString() {
        return "ServerDetailsDto{" +
                "serverName='" + serverName + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                ", temperature=" + temperature +
                ", cpuLoad=" + cpuLoad +
                ", bandwidth=" + bandwidth +
                ", iops=" + iops +
                ", ramLoad=" + ramLoad +
                '}';
    }
}
