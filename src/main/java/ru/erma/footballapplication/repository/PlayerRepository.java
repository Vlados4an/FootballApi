package ru.erma.footballapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.erma.footballapplication.model.FootballPlayer;

import java.util.Optional;

@Repository
public interface PlayerRepository extends JpaRepository<FootballPlayer,Long> {
    Optional<FootballPlayer> findByLastName(String name);
}
