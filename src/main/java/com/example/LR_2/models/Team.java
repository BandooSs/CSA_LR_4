package com.example.LR_2.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "team", schema = "public")
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_team;

    @Column(name = "first_name", unique = true)
    private String first_name;

    @Column(name = "city_name")
    private String city_name;
    @Override
    public String toString() {
        return "Team{" +
                "id_team=" + id_team +
                ", first_name='" + first_name + '\'' +
                ", city_name='" + city_name + '\'' +
                '}';
    }
    /*@JsonIgnore
    @OneToMany(mappedBy = "team", cascade = CascadeType.ALL)
    private List<Player> players;*/

}
