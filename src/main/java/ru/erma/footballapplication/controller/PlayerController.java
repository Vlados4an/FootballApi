package ru.erma.footballapplication.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.erma.footballapplication.dto.PlayerDto;
import ru.erma.footballapplication.dto.StatisticsDto;
import ru.erma.footballapplication.service.PlayerService;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/players")
public class PlayerController {
    private final PlayerService playerService;
    @GetMapping
    public ResponseEntity<List<PlayerDto>> getAllPlayers(){
        return ResponseEntity.ok(playerService.findAllPlayers());
    }

    @GetMapping("/{name}")
    public ResponseEntity<PlayerDto> getPlayerByName(@PathVariable String name){
        return ResponseEntity.ok(playerService.findPlayerByName(name));
    }
    @GetMapping("/{name}/statistics")
    public ResponseEntity<StatisticsDto> getStatisticsByPlayerName(@PathVariable String name){
        return ResponseEntity.ok(playerService.findStatisticsByPlayerName(name));
    }
    @PostMapping("/add")
    public ResponseEntity<HttpStatus> createPlayer(@RequestBody PlayerDto playerDto){
        playerService.savePlayer(playerDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @PutMapping("/{id}")
    public ResponseEntity<PlayerDto> updatePlayer(@PathVariable Long id,@RequestBody PlayerDto playerDto){
        playerService.updatePlayer(playerDto,id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deletePlayer(@PathVariable Long id){
        playerService.deletePlayer(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
