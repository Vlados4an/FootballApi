package ru.erma.footballapplication.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlayerDto {
    private String firstName;
    private String lastName;
    private String position;
    private Integer age;
    private Double height;
    private Double weight;
    private Integer number;
    private Double cost;
    private String teamName;
    private Long statisticsId;
}
