package com.football_fantasy.demo.Player;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Setter
@Getter
public class PlayerDTO {
    private String name;
    private String position;
    private String team;
    private String nationalTeam;
    private LocalDate dob;

    public PlayerDTO() {
    }


    public PlayerDTO(String name, String position, String team, String nationality, LocalDate dob) {
        this.name = name;
        this.position = position;
        this.team = team;
        this.nationalTeam = nationality;
        this.dob = dob;
    }
}
