package com.example.demo.entity;

public class Dislike extends BaseEntity {
    private Integer userId;
    private Integer markerId;

    public Dislike(Integer id, Integer userId, Integer markerId) {
        super(id);
        this.userId = userId;
        this.markerId = markerId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getMarkerId() {
        return markerId;
    }

    public void setMarkerId(Integer markerId) {
        this.markerId = markerId;
    }
}
