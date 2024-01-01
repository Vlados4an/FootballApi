package ru.erma.footballapplication.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Data
@Entity
public class FootballPlayer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName;
    private String lastName;
    private String position;
    private Integer age;
    private Double height;
    private Double weight;
    private Integer number;
    private Double cost;

    @ManyToOne
    @JoinColumn(name = "team_id")
    private Team team;

    @OneToOne(cascade = CascadeType.ALL)
    private Statistics statistics;
}
