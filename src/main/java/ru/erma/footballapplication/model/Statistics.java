package ru.erma.footballapplication.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;

@Entity
@Data
public class Statistics {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer goals;
    private Integer assists;
    private Integer yellowCards;
    private Integer redCards;

    @OneToOne(mappedBy = "statistics", cascade = CascadeType.ALL)
    private FootballPlayer footballPlayer;
}