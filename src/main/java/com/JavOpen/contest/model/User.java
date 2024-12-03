package com.JavOpen.contest.model;

import jakarta.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private int userId;


    @Column(name = "ADMIN_ID", nullable = false)
    private String adminId;

    @Column(name = "ADMIN_PW", nullable = false)
    private String adminPw;

    // Getters and setters
    public int getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) { this.userId = userId; }

    public String getAdminId() {
        return adminId;
    }

    public String getAdminPw() {
        return adminPw;
    }

    public void setAdminPw(String adminPw) {this.adminPw = adminPw;}
}
