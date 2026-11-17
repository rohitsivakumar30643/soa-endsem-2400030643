
package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.entity.Tourist;
import com.example.demo.repository.TouristRepository;



@Service
public class TouristServiceImpl implements TouristService {

    @Autowired
    private TouristRepository repository;

    @Override
    public List<Tourist> getAllTourists() {
        return repository.findAll();
    }
    
    @Override
    public Tourist addTourist(Tourist tourist) {
        return repository.save(tourist);
    }
}
