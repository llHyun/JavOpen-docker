package com.JavOpen.contest.model;

public class DeviceDTO {
    private String location;

    public DeviceDTO(String location){
        this.location = location;
    }


    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
