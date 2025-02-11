package com.football_fantasy.demo.player;

import com.football_fantasy.demo.player.api.rest.PlayerCreateRequest;
import com.football_fantasy.demo.player.api.rest.PlayerUpdateRequest;
import com.football_fantasy.demo.player.repository.Player;
import com.football_fantasy.demo.player.service.PlayerCreateDto;
import com.football_fantasy.demo.player.service.PlayerDto;
import com.football_fantasy.demo.player.service.PlayerUpdateDto;

//TODO dodaj testove za svaki maper
public final class PlayerMapper {
    public static PlayerUpdateDto map(PlayerUpdateRequest playerUpdateRequest) {
        return new PlayerUpdateDto(
                playerUpdateRequest.name(),
                playerUpdateRequest.position(),
                playerUpdateRequest.team(),
                playerUpdateRequest.nationalteam(),
                playerUpdateRequest.dob(),
                playerUpdateRequest.version());
    }

    public static PlayerCreateDto map(PlayerCreateRequest playerCreateRequest) {
        return new PlayerCreateDto(
                playerCreateRequest.name(),
                playerCreateRequest.position(),
                playerCreateRequest.team(),
                playerCreateRequest.nationalteam(),
                playerCreateRequest.dob());
    }

    public static Player map(PlayerCreateDto playerCreateDto) {
        return new Player(
                playerCreateDto.name(),
                playerCreateDto.position(),
                playerCreateDto.team(),
                playerCreateDto.nationalteam(),
                playerCreateDto.dob());
    }

    public static PlayerCreateDto map(Player player) {
        return new PlayerCreateDto(
                player.getName(),
                player.getPosition(),
                player.getTeam(),
                player.getNationalteam(),
                player.getDob());
    }
}
