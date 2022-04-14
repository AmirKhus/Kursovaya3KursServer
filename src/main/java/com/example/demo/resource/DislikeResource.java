package com.example.demo.resource;

import com.example.demo.entity.Dislike;
import com.example.demo.entity.Like;

public class DislikeResource {
    private Integer id;
    private int userId;
    private int markerId;


    public DislikeResource() {}

    public DislikeResource(Dislike dislike) {
        this.id = dislike.getId();
        this.userId = dislike.getUserId();
        this.markerId = dislike.getMarkerId();
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

    public Dislike toEntity() {
        return new Dislike(
                this.id,
                this.userId,
                this.markerId
        );
    }

}
