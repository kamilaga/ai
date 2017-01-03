package com.mas.controllers;

import com.mas.domain.model.Series;
import com.mas.services.SeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/series")
public class SeriesController {

    @Autowired
    SeriesService seriesService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Series> get(){
        return seriesService.get();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Series create(@RequestBody Series series){
        return seriesService.create(series);
    }
}
