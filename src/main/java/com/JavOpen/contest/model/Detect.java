package com.JavOpen.contest.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "detect")
public class Detect {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer detectId;

    @ManyToOne
    @JoinColumn(name = "USER_ID", nullable = false)  // USER_ID 외래키 연결
    private User user;

    @Column(name = "LOCATION", nullable = false)
    private String location;

    @Column(name = "ADDRESS", nullable = false)
    private String address;

    @Column(name="PROBABILITY", nullable = false)
    private Double probability;

    @Lob
    @Column(name = "ANT_IMG", columnDefinition = "LONGBLOB")
    private String antImg;

    @Column(nullable = false)
    private LocalDateTime date = LocalDateTime.now();

    public Integer getDetectId() {
        return detectId;
    }

    public void setDetectId(Integer detectId) {
        this.detectId = detectId;
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
