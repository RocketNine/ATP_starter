package main.java;

import java.time.LocalDateTime;
import java.util.UUID;

public class LaunchInfo {

    private UUID launchID;
    private String destination;
    private String flightNumber;
    private LocalDateTime time;
    private String launchPad;
    private LaunchStatus status;

    public enum LaunchStatus {
        Aok, Delayed, Scrubbed, Launched
    };

    public LaunchInfo(UUID launchID) {
        this.launchID = launchID;
    }

    private LaunchInfo() {
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public void setTime(LocalDateTime time) {
        this.time = time;
    }

    public void setLaunchPad(String launchPad) {
        this.launchPad = launchPad;
    }

    public void setStatus(LaunchStatus status) {
        this.status = status;
    }

    public UUID getLaunchID() {
        return launchID;
    }

    public String getDestination() {
        return destination;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public String getLaunchPad() {
        return launchPad;
    }

    public LaunchStatus getStatus() {
        return status;
    }
}
