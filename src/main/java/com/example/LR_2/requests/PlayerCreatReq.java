package com.example.LR_2.requests;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class PlayerCreatReq {
    private String first_name;
    private String last_name;
    private int id_team;
}
