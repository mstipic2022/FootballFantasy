package com.football_fantasy.demo.player.api.rest;

import com.football_fantasy.demo.player.PlayerMapper;
import com.football_fantasy.demo.player.repository.Player;
import com.football_fantasy.demo.player.service.PlayerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@Slf4j
@RequestMapping(path = "/api/players/v1")
@RestController
public class PlayerController {

    private final PlayerService playerService;

    @GetMapping(path = "/")
    public @ResponseBody List<Player> fetchPlayers() {
        log.info("fetchPlayerRequest received request");
        return playerService.fetchPlayers();
    }

    @PostMapping
    public void createPlayerRequest(@RequestBody PlayerCreateRequest playerCreateRequest) {
        log.info("createPlayerRequest received request={}", playerCreateRequest);
        var playerCreateDto = PlayerMapper.map(playerCreateRequest);
        playerService.createPlayer(playerCreateDto);
    }

    @PutMapping(path = "/{id}")
    public void updatePlayer(@PathVariable Long id, @RequestBody PlayerUpdateRequest playerUpdateRequest) {
        log.info("updatePlayer received id={}, request={}", id, playerUpdateRequest);
        var playerUpdateDto = PlayerMapper.map(playerUpdateRequest);
        playerService.updatePlayer(id, playerUpdateDto);
    }

    @DeleteMapping(path = "/{id}")
    public void deletePlayer(@PathVariable Long id) {
        log.info("deletePlayer received id={}", id);
        playerService.deletePlayer(id);
    }
}