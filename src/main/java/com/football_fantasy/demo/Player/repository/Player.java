package com.football_fantasy.demo.player.repository;

import com.football_fantasy.demo.player.model.Position;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "player", schema = "marko")
@NoArgsConstructor
public class Player {
    @Id
    @SequenceGenerator(name="player_id_seq", sequenceName = "player_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "player_id_seq")
    private Long id;

    @Column(name = "name")
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "position")
    private Position position;

    @Column(name = "team")
    private String team;

    @Column(name = "nationalteam")
    private String nationalteam;

    @Column(name = "dob")
    private LocalDate dob;

    @Column(name = "version")
    @Version
    private Long version;

    public Player(String name, Position position, String team, String nationalTeam, LocalDate dob) {
        this.name = name;
        this.position = position;
        this.team = team;
        this.nationalteam = nationalTeam;
        this.dob = dob;
    }

}
