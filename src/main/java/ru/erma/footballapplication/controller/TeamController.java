package ru.erma.footballapplication.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.erma.footballapplication.dto.TeamDto;
import ru.erma.footballapplication.service.TeamService;

import java.util.List;

@RestController
@RequestMapping("/teams")
@RequiredArgsConstructor
public class TeamController {
    private final TeamService teamService;
    @GetMapping
    public ResponseEntity<List<TeamDto>> getAllTeams(){
        return ResponseEntity.ok(teamService.findAllTeams());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TeamDto> getTeamById(@PathVariable Long id){
        return ResponseEntity.ok(teamService.findTeamById(id));
    }
    @PostMapping("/add")
    public ResponseEntity<HttpStatus> createTeam(@RequestBody TeamDto teamDto){
        teamService.saveTeam(teamDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
}
