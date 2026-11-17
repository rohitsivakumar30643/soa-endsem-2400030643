
package com.example.demo.service;

import java.util.List;

import com.example.demo.entity.Tourist;


public interface TouristService {

    List<Tourist> getAllTourists();
    Tourist addTourist(Tourist tourist);
}
