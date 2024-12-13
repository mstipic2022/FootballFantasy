package com.football_fantasy.demo.Player;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class PlayerRequest {
    private String name;
    private String position;
    private String team;
    private String nationalTeam;
    private LocalDate dob;

    public PlayerRequest() {
    }


    public PlayerRequest (String name, String position, String team, String nationalTeam, LocalDate dob) {
        this.name = name;
        this.position = position;
        this.team = team;
        this.nationalTeam = nationalTeam;
        this.dob = dob;
    }
}
