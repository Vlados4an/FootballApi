package ru.erma.footballapplication.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;
import ru.erma.footballapplication.model.FootballPlayer;

import java.util.List;
@Getter
@Setter
public class TeamDto {
    @NotBlank(message = "Team name cannot be blank")
    private String teamName;
}
