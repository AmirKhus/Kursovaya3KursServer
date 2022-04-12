package com.example.demo.resource;

import com.example.demo.entity.Marker;
import com.example.demo.entity.User;
import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.Date;

public class UserResource {
    private Integer id;
    private String login;
    private String password;

//    @JsonInclude(JsonInclude.Include.NON_NULL)
//    private MarkerResource[] markerResource;

    public UserResource() {}

    public UserResource(User user) {
        this.id = user.getId();
        this.login = user.getLogin();
        this.password = user.getPassword();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

//    public MarkerResource[] getMarkerResource() {
//        return markerResource;
//    }
//
//    public void setMarkerResource(MarkerResource[] markerResource) {
//        this.markerResource = markerResource;
//    }

    public User toEntity() {
        return new User(
                this.id,
                this.login,
                this.password
        );
    }

}
