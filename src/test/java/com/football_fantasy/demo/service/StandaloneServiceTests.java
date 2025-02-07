package com.football_fantasy.demo.service;

import com.football_fantasy.demo.PlayerBuilder;
import com.football_fantasy.demo.player.PlayerMapper;
import com.football_fantasy.demo.player.model.Position;
import com.football_fantasy.demo.player.repository.Player;
import com.football_fantasy.demo.player.repository.PlayerRepository;
import com.football_fantasy.demo.player.service.PlayerService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StandaloneServiceTests {

    @InjectMocks
    PlayerService service;

    @Mock
    PlayerRepository dao;

    @Test
    void getPlayers() {

        Player playerOne = PlayerBuilder
                .aPlayer()
                .build();

        Player playerTwo = PlayerBuilder.aPlayer()
                .withName("Cristiano Ronaldo")
                .withPosition(Position.ST)
                .build();

        Player playerThree = new Player("Lionel Messi", Position.ST, "Barcelona", "Argentina", LocalDate.of(2008, 11, 11));

        List<Player> list = List.of(playerOne, playerTwo, playerThree);

        when(dao.findAll()).thenReturn(list);

        //test
        List<Player> playerList = service.fetchPlayers();

        assertEquals(3, playerList.size());
        verify(dao, times(1)).findAll();
    }

    @Test
    void testCreatePlayer() {
        Player player = PlayerBuilder.aPlayer().build();

        var playerDto = PlayerMapper.map(player);
        service.createPlayer(playerDto);

        verify(dao, times(1)).save(player);
    }
}
