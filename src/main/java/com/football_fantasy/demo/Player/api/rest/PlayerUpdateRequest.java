package com.football_fantasy.demo.player.api.rest;

import com.football_fantasy.demo.player.model.Position;

import java.time.LocalDate;

public record PlayerUpdateRequest (String name,
                                   Position position,
                                   String team,
                                   String nationalteam,
                                   LocalDate dob,
                                   Long version
) {
}
