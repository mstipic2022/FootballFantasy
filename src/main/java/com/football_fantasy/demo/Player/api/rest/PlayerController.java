package com.football_fantasy.demo.player.api.rest;

import com.football_fantasy.demo.player.repository.Player;
import com.football_fantasy.demo.player.PlayerMapper;
import com.football_fantasy.demo.player.service.PlayerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@Slf4j
@RequestMapping(path = "/api/player/v1")
public class PlayerController {

    private final PlayerService playerService;

    @GetMapping(path = "/")
    public @ResponseBody String ping() {
        return "Hello, World!";
    }

    @GetMapping(path = "/players")
    public @ResponseBody List<Player> fetchPlayers() {
        return playerService.fetchPlayers();
    }

    @PostMapping
    public void createPlayerRequest(@RequestBody PlayerCreateRequest playerCreateRequest) {
        String trackingId = MDC.get("trackingId");
        log.info("createPlayerRequest received request={}, trackingId={} ", playerCreateRequest, trackingId);
        var playerCreateDto = PlayerMapper.map(playerCreateRequest);
        playerService.createPlayer(playerCreateDto);
    }

    @PutMapping(path = "/{id}")
    public void updatePlayer(@PathVariable Long id, @RequestBody PlayerUpdateRequest playerUpdateRequest) {
        String trackingId = MDC.get("trackingId");
        log.info("updatePlayer received id={}, request={}, trackingId={} ", id, playerUpdateRequest, trackingId);
        var playerUpdateDto = PlayerMapper.map(playerUpdateRequest);
        playerService.updatePlayer(id, playerUpdateDto);
    }

    @DeleteMapping(path = "/{id}")
    public void deletePlayer(@PathVariable Long id) {
        String trackingId = MDC.get("trackingId");
        log.info("deletePlayer received id={}, trackingId={} ", id, trackingId);
        playerService.deletePlayer(id);
    }
}