package ru.erma.footballapplication.dto;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class StatisticsDto {
    private Integer goals;
    private Integer assists;
    private Integer yellowCards;
    private Integer redCards;
}
