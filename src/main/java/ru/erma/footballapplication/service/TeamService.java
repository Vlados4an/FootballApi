package ru.erma.footballapplication.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.erma.footballapplication.dto.TeamDto;
import ru.erma.footballapplication.mapper.ModelMapper;
import ru.erma.footballapplication.model.Team;
import ru.erma.footballapplication.repository.TeamRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class TeamService {
    private final TeamRepository teamRepository;
    private final ModelMapper mapper;

    public List<TeamDto> findAllTeams(){
        List<Team> teams = teamRepository.findAll();
        return teams.stream()
                .map(mapper::teamToDto)
                .collect(Collectors.toList());
    }
    public TeamDto findTeamById(Long id){
        Team foundTeam = teamRepository.findById(id)
                .orElseThrow(()-> new RuntimeException("Team not found with id: " + id));
        return mapper
                .teamToDto(foundTeam);
    }
    public void saveTeam(TeamDto teamDto){
        Team teamToSave = mapper.toTeam(teamDto);
        teamRepository.save(teamToSave);
    }
}
