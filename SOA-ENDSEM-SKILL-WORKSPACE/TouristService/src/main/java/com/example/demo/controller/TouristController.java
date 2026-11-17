
package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.Tourist;
import com.example.demo.service.TouristService;



@RestController
@RequestMapping("/api")
public class TouristController {

    @Autowired
    private TouristService service;

    private final String VALID_TOKEN = "tourist123";

    @GetMapping("/tourists")
    public ResponseEntity<?> getAllTourists(
            @RequestHeader(value = "Token", required = false)
            String token) {

        if (token == null || !token.equals(VALID_TOKEN)) {
            return ResponseEntity
                    .status(500)
                    .body("Unauthorized: Invalid Token Provided");
        }

        List<Tourist> tourists = service.getAllTourists();

        return ResponseEntity.ok(tourists);
    }
    
    @PostMapping("/add")
    public ResponseEntity<?> addTourist(@RequestBody Tourist tourist) {

        Tourist t = service.addTourist(tourist);

        return ResponseEntity.ok(t);
    }
}
