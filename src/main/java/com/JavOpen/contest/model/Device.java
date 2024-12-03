package com.JavOpen.contest.model;

import jakarta.persistence.*;

@Entity
@Table(name = "device")
public class Device {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer deviceId;

    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)  // USER_ID 외래키 연결
    private User user;

    @Column(name = "LOCATION", nullable = false)
    private String location;  // BIG_RESULT와 연결

    @Column(name = "ADDRESS", nullable = true)
    private String address;

    public Integer getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(Integer deviceId) {
        this.deviceId = deviceId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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
}