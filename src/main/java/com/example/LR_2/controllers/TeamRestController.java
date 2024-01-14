package com.example.LR_2.controllers;

import com.example.LR_2.models.Team;
import com.example.LR_2.requests.TeamCreatReq;
import com.example.LR_2.service.PlayerService;
import com.example.LR_2.service.TeamService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static com.example.LR_2.controllers.Mapper2XLT.transform2XLT;

@RestController
@RequiredArgsConstructor
public class TeamRestController {
    private final PlayerService playerService;
    private final TeamService teamService;

    @RequestMapping(value = "/teams", method = RequestMethod.GET)
    public ResponseEntity<?> home(@RequestHeader("Accept") String acceptHeader) {
        if (acceptHeader.contains(MediaType.TEXT_HTML_VALUE)) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    transform2XLT(teamService.findAll(), "Teams.xslt")
            );
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(
                    teamService.findAll()
            );
        }
    }

    @RequestMapping(value = "/teams/delete/{id_team}", method = RequestMethod.GET,
            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<?> deleteTeam(@PathVariable("id_team") Long id_team) {
        try{
            teamService.deleteTeam(id_team);
            return ResponseEntity.status(HttpStatus.FOUND)
                    .header("Location", "/teams")
                    .build();
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    @RequestMapping(value = "/teams/{id_team}", method = RequestMethod.GET)
    public ResponseEntity<?> selectedTeam(@PathVariable("id_team") long id_team, @RequestHeader("Accept") String acceptHeader) {
        if (acceptHeader.contains(MediaType.TEXT_HTML_VALUE)) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    transform2XLT(teamService.findAll(), "Team.xslt",id_team)
            );
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(
                    transform2XLT(teamService.findAll(), "Team.xslt",id_team)
            );
        }
    }

    @RequestMapping(value = "/teams/create", method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<?> createTeam(@RequestParam("first_name") String firstName,
                                        @RequestParam("city_name") String lastName) {
        try {
            Team team = new Team();

            team.setFirst_name(firstName);
            team.setCity_name(lastName);
            teamService.saveTeam(team);
            return ResponseEntity.status(HttpStatus.FOUND)
                    .header("Location", "/teams")
                    .build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


}
