package ru.erma.footballapplication.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.erma.footballapplication.dto.PlayerDto;
import ru.erma.footballapplication.dto.StatisticsDto;
import ru.erma.footballapplication.mapper.ModelMapper;
import ru.erma.footballapplication.model.FootballPlayer;
import ru.erma.footballapplication.model.Statistics;
import ru.erma.footballapplication.model.Team;
import ru.erma.footballapplication.repository.PlayerRepository;
import ru.erma.footballapplication.repository.StatisticsRepository;
import ru.erma.footballapplication.repository.TeamRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PlayerService {
    private final PlayerRepository playerRepository;
    private final TeamRepository teamRepository;
    private final StatisticsRepository statisticsRepository;
    private final ModelMapper mapper;
    public List<PlayerDto> findAllPlayers(){
        List<FootballPlayer> players = playerRepository.findAll();
        return players.stream()
                .map(mapper::playerToDto)
                .collect(Collectors.toList());
    }
    public PlayerDto findPlayerByName(String lastName){
        Optional<FootballPlayer> player = playerRepository.findByLastName(lastName);
        return player
                .map(mapper::playerToDto)
                .orElse(null);
    }
    public StatisticsDto findStatisticsByPlayerName(String lastName){
        Optional<FootballPlayer> player = playerRepository.findByLastName(lastName);
        return player
                .map(player1 -> mapper.statisticsToDto(player1.getStatistics()))
                .orElse(null);

    }

    public void savePlayer(PlayerDto playerDto){
        FootballPlayer playerToSave =
                mapper.toFootballPlayer(playerDto);
        Long statisticsId = playerDto.getStatisticsId();
        Team team = teamRepository.findByTeamName(playerDto.getTeamName());
        Statistics statistics = statisticsRepository.findById(statisticsId)
                .orElseThrow(()->new RuntimeException("Statistics not found with id " + statisticsId));
        playerToSave.setTeam(team);
        playerToSave.setStatistics(statistics);
        playerRepository.save(playerToSave);
    }

    public void updatePlayer(PlayerDto playerDto, Long id) {
        FootballPlayer playerToUpdate = playerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Player not found with id: " + id));

        Team team = teamRepository.findByTeamName(playerDto.getTeamName());
        Statistics statistics = statisticsRepository.findById(playerDto.getStatisticsId())
                .orElseThrow(() -> new RuntimeException("Statistics not found with id: " + playerDto.getStatisticsId()));

        playerToUpdate.setTeam(team);
        playerToUpdate.setStatistics(statistics);

        mapper.updateFootballPlayer(playerDto, playerToUpdate);

        playerRepository.save(playerToUpdate);
    }

    public void deletePlayer(Long id){
        playerRepository.deleteById(id);
    }



}
