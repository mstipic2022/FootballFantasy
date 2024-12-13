package com.football_fantasy.demo.Player;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table
public class Player {
    @Id
    @SequenceGenerator(name="player_sequence", sequenceName = "player_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "player_sequence")
    private Long id;

    private String name;
    private String position;
    private String team;
    private String nationalTeam;
    private LocalDate dob;
    public Player() {
    }

    public Player(Long id, String name, String position, String team, String nationalTeam, LocalDate dob) {
        this.id = id;
        this.name = name;
        this.position = position;
        this.team = team;
        this.nationalTeam = nationalTeam;
        this.dob = dob;
    }

    public Player(String name, String position, String team, String nationalTeam, LocalDate dob) {
        this.name = name;
        this.position = position;
        this.team = team;
        this.nationalTeam = nationalTeam;
        this.dob = dob;
    }

}
