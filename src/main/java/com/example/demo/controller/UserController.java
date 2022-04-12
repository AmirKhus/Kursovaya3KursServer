package com.example.demo.controller;

import com.example.demo.entity.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.resource.UserResource;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@CrossOrigin
@RestController
@RequestMapping(value = "user")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @CrossOrigin
    @RequestMapping(value = "", method = RequestMethod.GET)
    UserResource[] getAll(@RequestParam(required = false) String login) {
        User[] entities = login == null ?
                //выводим все записи с помощью селект запроса
                userRepository.select() :
                //выводим только те данные которые имеют нужный нам region_id с помощью селект запроса
                userRepository.selectByLogin(login);
        return Arrays.stream(entities)
                .map(entity -> {
                    UserResource resource = new UserResource(entity);
                    return resource;
                })
                .toArray(UserResource[]::new);
    }
//http://localhost:8080/game?name=Grand Theft Auto 6

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    UserResource get(@PathVariable Integer id,
                       @RequestParam(required = false) Object expand) {
        User entity = userRepository.select(id);
        if (entity == null) return null;
        UserResource resource = new UserResource(entity);
        return resource;
    }


    @CrossOrigin
    @RequestMapping(value = "", method = RequestMethod.POST)
    UserResource post(@RequestBody UserResource resource) {
        User entity = userRepository.insert(resource.toEntity());
        if (entity == null) return null;
        return new UserResource(entity);
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    UserResource put(@PathVariable Integer id,
                       @RequestBody UserResource resource) {
        User entity = userRepository.update(id, resource.toEntity());
        if (entity == null) return null;
        return new UserResource(entity);
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    UserResource delete(@PathVariable Integer id) {
        User entity = userRepository.delete(id);
        if (entity == null) return null;
        return new UserResource(entity);
    }}
