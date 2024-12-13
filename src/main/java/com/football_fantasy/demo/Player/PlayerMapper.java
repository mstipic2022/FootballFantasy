package com.football_fantasy.demo.Player;

public class PlayerMapper {
    //convert iz entity u dto
    public static PlayerDTO convertToPlayerDTO(Player player) {
        return new PlayerDTO(player.getName(), player.getPosition(), player.getTeam(), player.getNationalTeam(), player.getDob());
    }
    //convert iz dto u entity
    public static Player convertToPlayer(PlayerDTO playerDTO) {
        return new Player(playerDTO.getName(), playerDTO.getPosition(), playerDTO.getTeam(), playerDTO.getNationalTeam(), playerDTO.getDob());
    }
    //convert iz PlayerRequest u DTO
    public static PlayerDTO convertToPlayerDTO(PlayerRequest playerRequest) {
        return new PlayerDTO(playerRequest.getName(), playerRequest.getPosition(), playerRequest.getTeam(), playerRequest.getNationalTeam(), playerRequest.getDob());
    }
}
