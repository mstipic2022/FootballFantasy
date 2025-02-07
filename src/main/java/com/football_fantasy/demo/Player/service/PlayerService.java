package com.football_fantasy.demo.player.service;

import com.football_fantasy.demo.player.repository.Player;
import com.football_fantasy.demo.player.PlayerMapper;
import com.football_fantasy.demo.player.repository.PlayerRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@Transactional
@RequiredArgsConstructor
public class PlayerService {

    private final PlayerRepository playerRepository;

    @Transactional
    public void createPlayer(PlayerCreateDto playerCreateDto) {
        var player = PlayerMapper.map(playerCreateDto);
        playerRepository.save(player);
        String trackingId = MDC.get("trackingId");
        log.info("Created playerId={}, trackingId={}", player.getId(), trackingId);
    }

    @Transactional(readOnly = true)
    public List<Player> fetchPlayers() {
        List<Player> players = playerRepository.findAll();
        String trackingId = MDC.get("trackingId");
        log.info("Fetched players: {}, trackingId={}", players, trackingId);
        return players;
    }

    @Transactional
    public void updatePlayer(Long id, PlayerUpdateDto playerUpdateDto) {
        var player = playerRepository.findById(id).orElseThrow(() -> new RuntimeException("Player not found"));
        player.setName(playerUpdateDto.name());
        player.setPosition(playerUpdateDto.position());
        player.setTeam(playerUpdateDto.team());
        player.setNationalteam(playerUpdateDto.nationalteam());
        player.setDob(playerUpdateDto.dob());
        playerRepository.save(player);
        String trackingId = MDC.get("trackingId");
        log.info("Updated playerId={}, trackingId={}", player.getId(), trackingId);
    }

    @Transactional
    public void deletePlayer(Long id) {
        playerRepository.deleteById(id);
        String trackingId = MDC.get("trackingId");
        log.info("Deleted playerId={}, trackingId={}", id, trackingId);
    }
}
