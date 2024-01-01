package ru.erma.footballapplication.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;


import java.util.List;
@Data
@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String teamName;

    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private List<FootballPlayer> footballPlayers;
}
