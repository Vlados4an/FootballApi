package ru.erma.footballapplication.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.erma.footballapplication.dto.StatisticsDto;
import ru.erma.footballapplication.service.StatisticsService;

import java.util.List;

@RestController
@RequestMapping("/statistics")
@RequiredArgsConstructor
public class StatisticsController {
    private final StatisticsService statisticsService;
    @GetMapping
    public ResponseEntity<List<StatisticsDto>> getAllStatistics(){
        return ResponseEntity.ok(statisticsService.findAllStatistics());
    }
    @PostMapping("/add")
    public ResponseEntity<HttpStatus> createStatistics(@RequestBody StatisticsDto statisticsDto){
        statisticsService.saveStatistics(statisticsDto);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<HttpStatus> updateStatistics(
            @RequestBody StatisticsDto statisticsDto,@PathVariable Long id){
        statisticsService.updateStatisticsById(statisticsDto,id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
