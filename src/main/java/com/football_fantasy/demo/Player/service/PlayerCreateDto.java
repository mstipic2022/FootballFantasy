package com.football_fantasy.demo.player.service;

import com.football_fantasy.demo.player.model.Position;

import java.time.LocalDate;


public record PlayerCreateDto(
        String name,
        Position position,
        String team,
        String nationalteam,
        LocalDate dob
) {
}
