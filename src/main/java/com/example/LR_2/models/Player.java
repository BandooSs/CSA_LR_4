package com.example.LR_2.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_player;

    @Column(name = "first_name")
    private String first_name;

    @Column(name = "last_name")
    private String last_name;

    /*@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_team")
//    @JsonIgnore
    private Team team;*/

   @Column(name = "id_team")
    private long id_team;


}
