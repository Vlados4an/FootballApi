package ru.erma.footballapplication.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.erma.footballapplication.model.Team;
@Repository
public interface TeamRepository extends JpaRepository<Team,Long> {
    Team findByTeamName(String teamName);
}
