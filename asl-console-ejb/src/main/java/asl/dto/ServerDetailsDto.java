package asl.dto;

import javax.enterprise.inject.New;
import javax.persistence.Entity;
import javax.persistence.Id;

import static javax.swing.text.html.HTML.Tag.HEAD;

/**
 * Created by sengir on 13.05.16.
 */
@Entity
public class ServerDetailsDto {
    @Id
    private String serverName;
    private String ipAddress;
    private double temperature;

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

    @Override
    public String toString() {
        return "ServerDetailsDto{" +
                "serverName='" + serverName + '\'' +
                ", ipAddress='" + ipAddress + '\'' +
                ", temperature=" + temperature +
                '}';
    }
}
