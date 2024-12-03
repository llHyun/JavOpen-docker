package com.JavOpen.contest.model;

import java.util.List;

public class DetectSummaryDTO {
    private String location;
    private int count;
    private List<DetectDTO> detects;

    public DetectSummaryDTO(String location, int count, List<DetectDTO> detects) {
        this.location = location;
        this.count = count;
        this.detects = detects;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public List<DetectDTO> getDetects() {
        return detects;
    }

    public void setDetects(List<DetectDTO> detects) {
        this.detects = detects;
    }
}

