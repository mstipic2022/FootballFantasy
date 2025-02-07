package com.football_fantasy.demo;

import com.football_fantasy.demo.player.model.Position;
import com.football_fantasy.demo.player.repository.Player;

import java.time.LocalDate;
public class PlayerBuilder {

    private String name;
    private Position position;
    private String team;
    private String nationalTeam;
    private LocalDate dob;

    private final static String DEFAULT_NAME = "Luka Ivekovic";
    private final static Position DEFAULT_POSITION = Position.ST;
    private final static String DEFAULT_TEAM = "Real Madrid";
    private final static String DEFAULT_NATIONAL_TEAM = "Croatia";
    private final static LocalDate DEFAULT_DOB = LocalDate.parse("1997-08-01");


    public Player build() {
        return new Player(name,
                position,
                team,
                nationalTeam,
                dob);
    }

    public static PlayerBuilder aPlayer() {
        return new PlayerBuilder();
    }

    public PlayerBuilder withName(String name) {
        this.name = name;
        return this;
    }

    public PlayerBuilder withPosition(Position position) {
        this.position = position;
        return this;
    }

    public PlayerBuilder withTeam(String team) {
        this.team = team;
        return this;
    }

    public PlayerBuilder withNationalTeam(String nationalTeam) {
        this.nationalTeam = nationalTeam;
        return this;
    }
    public PlayerBuilder withDob(LocalDate dob) {
        this.dob = dob;
        return this;
    }
}
