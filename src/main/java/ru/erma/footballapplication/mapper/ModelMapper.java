package ru.erma.footballapplication.mapper;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import ru.erma.footballapplication.dto.PlayerDto;
import ru.erma.footballapplication.dto.StatisticsDto;
import ru.erma.footballapplication.dto.TeamDto;
import ru.erma.footballapplication.model.FootballPlayer;
import ru.erma.footballapplication.model.Statistics;
import ru.erma.footballapplication.model.Team;

import java.util.Optional;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ModelMapper {
    @Mapping(source = "team.teamName",target = "teamName")
    @Mapping(source = "statistics.id",target = "statisticsId")
    PlayerDto playerToDto(FootballPlayer player);
    @Mapping(source = "teamName",target = "team.teamName")
    FootballPlayer toFootballPlayer(PlayerDto playerDto);
    TeamDto teamToDto(Team team);

    Team toTeam(TeamDto teamDto);
    Statistics toStatistics(StatisticsDto statisticsDto);
    StatisticsDto statisticsToDto(Statistics statistics);

    PlayerDto playerToDto(Optional<FootballPlayer> player);

    void updateFootballPlayer(PlayerDto playerDto, @MappingTarget FootballPlayer playerToUpdate);
    void updateStatistics(StatisticsDto statisticsDto, @MappingTarget Statistics statisticsToUpdate);

}
