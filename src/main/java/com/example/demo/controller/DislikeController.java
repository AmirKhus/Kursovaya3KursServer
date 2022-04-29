package com.example.demo.controller;


import com.example.demo.entity.Dislike;

import com.example.demo.repository.DislikeRepository;
import com.example.demo.resource.DislikeResource;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@CrossOrigin
@RestController
@RequestMapping(value = "dislike")
public class DislikeController {
    private final DislikeRepository dislikeRepository;

    public DislikeController(DislikeRepository dislikeRepository) {
        this.dislikeRepository = dislikeRepository;
    }

    @CrossOrigin
    @RequestMapping(value = "", method = RequestMethod.GET)
    DislikeResource[] getAll(@RequestParam(required = false) Integer userId,
                             @RequestParam(required = false) Integer markerId) {
        Dislike[] entities;
        if (userId == null) {
            if(markerId == null){
                entities = dislikeRepository.select();
            }else {
                entities = dislikeRepository.selectByMarkerId(markerId);
            }
        }else{
            if (markerId == null) {
                entities = dislikeRepository.selectByUserId(userId);
            }else {
                entities = dislikeRepository.selectByMarkerId(markerId);
            }
        }
//        Dislike[] entities = userId == null ?
//                //выводим все записи с помощью селект запроса
//                dislikeRepository.select() :
//                //выводим только те данные которые имеют нужный нам region_id с помощью селект запроса
//                dislikeRepository.selectByUserId(userId);
        return Arrays.stream(entities)
                .map(entity -> {
                    DislikeResource resource = new DislikeResource(entity);
                    return resource;
                })
                .toArray(DislikeResource[]::new);
    }
//http://localhost:8080/game?name=Grand Theft Auto 6

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    DislikeResource get(@PathVariable Integer id) {
        Dislike entity = dislikeRepository.select(id);
        if (entity == null) return null;
        DislikeResource resource = new DislikeResource(entity);
        return resource;
    }


    @CrossOrigin
    @RequestMapping(value = "", method = RequestMethod.POST)
    DislikeResource post(@RequestBody DislikeResource resource) {
        Dislike entity = dislikeRepository.insert(resource.toEntity());
        if (entity == null) return null;
        return new DislikeResource(entity);
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    DislikeResource put(@PathVariable Integer id,
                     @RequestBody DislikeResource resource) {
        Dislike entity = dislikeRepository.update(id, resource.toEntity());
        if (entity == null) return null;
        return new DislikeResource(entity);
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    DislikeResource delete(@PathVariable Integer id) {
        Dislike entity = dislikeRepository.delete(id);
        if (entity == null) return null;
        return new DislikeResource(entity);
    }}
