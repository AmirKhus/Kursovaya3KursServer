package com.example.demo.resource;

import com.example.demo.entity.Like;
import com.example.demo.entity.User;

public class LikeResource {
    private Integer id;
    private int userId;
    private int markerId;


    public LikeResource() {}

    public LikeResource(Like like) {
        this.id = like.getId();
        this.userId = like.getUserId();
        this.markerId = like.getMarkerId();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

//    public MarkerResource[] getMarkerResource() {
//        return markerResource;
//    }
//
//    public void setMarkerResource(MarkerResource[] markerResource) {
//        this.markerResource = markerResource;
//    }

    public Like toEntity() {
        return new Like(
                this.id,
                this.userId,
                this.markerId
        );
    }

}
