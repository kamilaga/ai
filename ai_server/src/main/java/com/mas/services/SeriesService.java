package com.mas.services;

import com.mas.domain.model.Series;
import com.mas.domain.repositories.SeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeriesService {

    @Autowired
    SeriesRepository seriesRepository;

    public List<Series> get(){
        return seriesRepository.findAll();
    }

    public Series create(Series series) {
        series.setId(null);
        return seriesRepository.save(series);
    }
}
