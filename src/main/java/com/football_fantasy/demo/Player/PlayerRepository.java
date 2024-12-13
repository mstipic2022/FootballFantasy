package com.football_fantasy.demo.Player;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
    List<Player> findByNationalTeam(String nationalTeam);

    Optional<Player> findPlayerById(Long id);

    //Optional<Player> findPlayerByName(String name);
}