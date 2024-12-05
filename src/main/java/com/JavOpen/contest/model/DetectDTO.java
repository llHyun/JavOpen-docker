package com.JavOpen.contest.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDateTime;

public class DetectDTO {
    @JsonIgnore
    private String location;
    private String address;
    private String antImg;
    private LocalDateTime date;

    private Double probability;

    public DetectDTO(String location, String address, Double probability, String antImg, LocalDateTime date) {
        this.location = location;
        this.address = address;
        this.probability = probability;
        this.antImg = antImg;
        this.date = date;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getProbability() {
        return probability;
    }

    public void setProbability(Double probability) {
        this.probability = probability;
    }

    public String getAntImg() {
        return antImg;
    }

    public void setAntImg(String antImg) {
        this.antImg = antImg;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }
}

