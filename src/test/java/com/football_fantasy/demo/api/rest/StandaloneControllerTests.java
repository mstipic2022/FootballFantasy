package com.football_fantasy.demo.api.rest;

import com.football_fantasy.demo.player.api.rest.PlayerController;
import com.football_fantasy.demo.player.model.Position;
import com.football_fantasy.demo.player.repository.Player;
import com.football_fantasy.demo.player.service.PlayerService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.util.List;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(PlayerController.class)
public class StandaloneControllerTests {
    @MockBean
    PlayerService playerService;
    @Autowired
    MockMvc mockMvc;
    @Test
    public void getPlayers() throws Exception {
        Player player = new Player("Luka Modric", Position.CM, "Real Madrid", "Croatia", LocalDate.of(2008, 11, 11));
        List<Player> players = List.of(player);
        when(playerService.fetchPlayers()).thenReturn(players);
        mockMvc.perform(get("/api/player/v1/players"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", Matchers.hasSize(1)))
                .andExpect(jsonPath("$[0].name", Matchers.is("Luka Modric")));
    }

    @Test
    public void getPlayersFailed() throws Exception {
        when(playerService.fetchPlayers()).thenThrow(new RuntimeException());
        mockMvc.perform(get("/api/player/v1/players"))
                .andExpect(status().isInternalServerError());
    }
}
