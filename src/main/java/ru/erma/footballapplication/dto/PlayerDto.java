package ru.erma.footballapplication.dto;


import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PlayerDto {
    @NotBlank(message = "First name cannot be blank")
    private String firstName;

    @NotBlank(message = "Last name cannot be blank")
    private String lastName;

    @NotBlank(message = "Position cannot be blank")
    private String position;

    @NotNull(message = "Age cannot be null")
    @Min(value = 15,message = "Age should be greater than 15")
    @Max(value = 60,message = "age should be less than 60")
    private Integer age;

    @NotNull(message = "Height cannot be null")
    @Min(value = 150,message = "Height should be greater than 150")
    @Max(value = 250,message = "Height should be less than 250")
    private Double height;

    @NotNull(message = "Weight cannot be null")
    @Min(value = 40,message = "Weight should be greater than 40")
    @Max(value = 150,message = "Weight should be less than 150")
    private Double weight;

    @NotNull(message = "Number cannot be null")
    @Positive(message = "Number must be a positive number")
    private Integer number;

    @NotNull(message = "Cost cannot be null")
    @Positive(message = "Cost must be a positive number")
    private Double cost;

    @NotBlank(message = "Team name cannot be blank")
    private String teamName;

    @NotNull(message = "Statistics ID cannot be null")
    @Positive(message = "Statistics ID must be a positive number")
    private Long statisticsId;
}
