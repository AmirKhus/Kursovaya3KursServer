package com.example.demo.controller;


import com.example.demo.entity.Like;
import com.example.demo.repository.LikeRepository;
import com.example.demo.resource.LikeResource;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@CrossOrigin
@RestController
@RequestMapping(value = "like")
public class LikeController {
    private final LikeRepository likeRepository;

    public LikeController(LikeRepository likeRepository) {
        this.likeRepository = likeRepository;
    }

    @CrossOrigin
    @RequestMapping(value = "", method = RequestMethod.GET)
    LikeResource[] getAll(@RequestParam(required = false) Integer userId) {
        Like[] entities = userId == null ?
                //выводим все записи с помощью селект запроса
                likeRepository.select() :
                //выводим только те данные которые имеют нужный нам region_id с помощью селект запроса
                likeRepository.selectByUserId(userId);
        return Arrays.stream(entities)
                .map(entity -> {
                    LikeResource resource = new LikeResource(entity);
                    return resource;
                })
                .toArray(LikeResource[]::new);
    }
//http://localhost:8080/game?name=Grand Theft Auto 6

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    LikeResource get(@PathVariable Integer id) {
        Like entity = likeRepository.select(id);
        if (entity == null) return null;
        LikeResource resource = new LikeResource(entity);
        return resource;
    }


    @CrossOrigin
    @RequestMapping(value = "", method = RequestMethod.POST)
    LikeResource post(@RequestBody LikeResource resource) {
        Like entity = likeRepository.insert(resource.toEntity());
        if (entity == null) return null;
        return new LikeResource(entity);
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    LikeResource put(@PathVariable Integer id,
                     @RequestBody LikeResource resource) {
        Like entity = likeRepository.update(id, resource.toEntity());
        if (entity == null) return null;
        return new LikeResource(entity);
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    LikeResource delete(@PathVariable Integer id) {
        Like entity = likeRepository.delete(id);
        if (entity == null) return null;
        return new LikeResource(entity);
    }}
