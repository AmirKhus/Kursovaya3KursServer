package com.example.demo.controller;

import com.example.demo.entity.Marker;
import com.example.demo.repository.MarkerRepository;
import com.example.demo.resource.MarkerResource;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

@CrossOrigin
@RestController
@RequestMapping(value = "marker")
public class MarkerController {
    private final MarkerRepository markerRepository;

    public MarkerController(MarkerRepository markerRepository) {
        this.markerRepository = markerRepository;
    }

    @CrossOrigin
    @RequestMapping(value = "", method = RequestMethod.GET)
    MarkerResource[] getAll(@RequestParam(required = false) Object expand) {
        return Arrays.stream(markerRepository.select())
                .map(entity -> {
                    MarkerResource resource = new MarkerResource(entity);
                    return resource;
                })
                .toArray(MarkerResource[]::new);
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    MarkerResource get(@PathVariable Integer id,
                       @RequestParam(required = false) Object expand) {
        Marker entity = markerRepository.select(id);
        if (entity == null) return null;
        MarkerResource resource = new MarkerResource(entity);
        return resource;
    }

    @CrossOrigin
    @RequestMapping(value = "", method = RequestMethod.POST)
    MarkerResource post(@RequestBody MarkerResource resource) {
        Marker entity = markerRepository.insert(resource.toEntity());
        if (entity == null) return null;
        return new MarkerResource(entity);
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    MarkerResource put(@PathVariable Integer id,
                       @RequestBody MarkerResource resource) {
        Marker entity = markerRepository.update(id, resource.toEntity());
        if (entity == null) return null;
        return new MarkerResource(entity);
    }

    @CrossOrigin
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    MarkerResource delete(@PathVariable Integer id) {
        Marker entity = markerRepository.delete(id);
        if (entity == null) return null;
        return new MarkerResource(entity);
    }}
