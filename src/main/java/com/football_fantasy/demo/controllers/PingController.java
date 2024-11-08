package com.football_fantasy.demo.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class PingController {

    @GetMapping("/ping")
    public String ping() {
        return "Service is up";
    }

    @GetMapping("/ping/{id}")
    public ResponseEntity<Map<String, Object>> ping(@PathVariable int id) {
        if (id == 1) {
            Map<String, Object> response = new HashMap<>();
            response.put("status", "Service is up");
            response.put("timestamp", LocalDateTime.now());
        } else {
            Map<String, Object> errorResponse = new HashMap<>();
            errorResponse.put("error", "Invalid API call");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
        }
        return null;
    }
}
