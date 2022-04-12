package com.example.demo.resource;

import com.example.demo.entity.Marker;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;

public class MarkerResource {
    private Integer id;
    private String typeOfEnvironmentalProblem;
    private String description;
    private Date dateOfPublication;
    private Integer likeMarker;
    private Integer dislikeMarker;
    private Float longitude;
    private Float latitude;
    private Integer userId;

//    @JsonInclude(JsonInclude.Include.NON_NULL)
//    private UserResource userResource;


    public MarkerResource() {}

    public MarkerResource(Marker marker) {
        this.id = marker.getId();
        this.typeOfEnvironmentalProblem = marker.getTypeOfEnvironmentalProblem();
        this.description = marker.getDescription();
        this.dateOfPublication = marker.getDateOfPublication();
        this.likeMarker = marker.getLikeMarker();
        this.dislikeMarker = marker.getDislikeMarker();
        this.longitude = marker.getLongitude();
        this.latitude = marker.getLatitude();;
        this.userId = marker.getUserId();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTypeOfEnvironmentalProblem() {
        return typeOfEnvironmentalProblem;
    }

    public void setTypeOfEnvironmentalProblem(String typeOfEnvironmentalProblem) {
        this.typeOfEnvironmentalProblem = typeOfEnvironmentalProblem;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getDateOfPublication() {
        return dateOfPublication;
    }

    public void setDateOfPublication(Date dateOfPublication) {
        this.dateOfPublication = dateOfPublication;
    }

    public Integer getLikeMarker() {
        return likeMarker;
    }

    public void setLikeMarker(Integer likeMarker) {
        this.likeMarker = likeMarker;
    }

    public Integer getDislikeMarker() {
        return dislikeMarker;
    }

    public void setDislikeMarker(Integer dislikeMarker) {
        this.dislikeMarker = dislikeMarker;
    }

    public Float getLongitude() {
        return longitude;
    }

    public void setLongitude(Float longitude) {
        this.longitude = longitude;
    }

    public Float getLatitude() {
        return latitude;
    }

    public void setLatitude(Float latitude) {
        this.latitude = latitude;
    }

    public Integer getUserId() {
        return userId;
    }

//    public UserResource getUserResource() {
//        return userResource;
//    }
//
//    public void setUserResource(UserResource userResource) {
//        this.userResource = userResource;
//    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Marker toEntity() {
        return new Marker(
                this.id,
                this.typeOfEnvironmentalProblem,
                this.description,
                this.dateOfPublication,
                this.likeMarker,
                this.dislikeMarker,
                this.longitude,
                this.latitude,
                this.userId
        );
    }

}
