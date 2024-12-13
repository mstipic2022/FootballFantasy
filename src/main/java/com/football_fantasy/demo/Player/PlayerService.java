package com.football_fantasy.demo.Player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class PlayerService {
    private final PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public List<PlayerDTO> getPlayers() {
        List<Player> players = playerRepository.findAll();
        List<PlayerDTO> playerDTOs = new ArrayList<PlayerDTO>();
        for (Player player : players){
            playerDTOs.add(PlayerMapper.convertToPlayerDTO(player));
        }
        return playerDTOs;
    }

    public Optional<Player> getPlayer(Player player) {
        return playerRepository.findPlayerById(player.getId());
    }


    public void addPlayer(Player player) {
        playerRepository.save(player);
        System.out.println("Added player " + player);
    }

    public List<Player> getPlayersByNationalTeam(String nationalTeam) {
        return playerRepository.findByNationalTeam(nationalTeam);
    }

    //List.of(new Player(1L, "Cristiano Ronaldo", "ST", "Al-Nassr", "Portugal", LocalDate.of(1985, Month.FEBRUARY, 5)))
}
