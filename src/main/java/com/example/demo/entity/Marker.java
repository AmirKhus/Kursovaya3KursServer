package com.example.demo.entity;

import java.util.Date;

public class Marker extends BaseEntity {
    private String typeOfEnvironmentalProblem;
    private String description;
    private Date dateOfPublication;
    private Integer likeMarker;
    private Integer dislikeMarker;
    private Float longitude;
    private Float latitude;
    private Integer userId;

    public Marker(Integer id, String typeOfEnvironmentalProblem, String description, Date dateOfPublication, Integer likeMarker, Integer dislikeMarker, Float longitude, Float latitude, Integer userId) {
        super(id);
        this.typeOfEnvironmentalProblem = typeOfEnvironmentalProblem;
        this.description = description;
        this.dateOfPublication = dateOfPublication;
        this.likeMarker = likeMarker;
        this.dislikeMarker = dislikeMarker;
        this.longitude = longitude;
        this.latitude = latitude;
        this.userId = userId;
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

    public int getLikeMarker() {
        return likeMarker;
    }

    public void setLikeMarker(int likeMarker) {
        this.likeMarker = likeMarker;
    }

    public int getDislikeMarker() {
        return dislikeMarker;
    }

    public void setDislikeMarker(int dislikeMarker) {
        this.dislikeMarker = dislikeMarker;
    }

    public void setLikeMarker(Integer likeMarker) {
        this.likeMarker = likeMarker;
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

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
