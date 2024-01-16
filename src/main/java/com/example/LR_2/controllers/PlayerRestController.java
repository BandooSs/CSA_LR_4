package com.example.LR_2.controllers;

import com.example.LR_2.models.AuditEvent;
import com.example.LR_2.models.Player;
import com.example.LR_2.models.Team;
import com.example.LR_2.requests.PlayerCreatReq;
import com.example.LR_2.service.PlayerService;
import com.example.LR_2.service.TeamService;
import com.example.LR_2.utils.EventLogger;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import java.util.List;

import static com.example.LR_2.controllers.Mapper2XLT.transform2XLT;
import static com.example.LR_2.controllers.Mapper2XLT.transform2XLT_player;

@RestController
@RequiredArgsConstructor
public class PlayerRestController {
    private final PlayerService playerService;
    private final TeamService teamService;
    private final EventLogger eventLogger;

    @RequestMapping(value = "/players", method = RequestMethod.GET)
    public ResponseEntity<?> playerList(@RequestHeader("Accept") String acceptHeader) {
        if (acceptHeader.contains(MediaType.TEXT_HTML_VALUE)) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    transform2XLT(playerService.finAll(), "Players.xslt")
            );
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(
                    playerService.finAll()
            );
        }
    }
    @RequestMapping(value = "/players/create", method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<?> createPlayer(@RequestParam("first_name") String firstName,
                                        @RequestParam("last_name") String lastName, @RequestParam("id_team") long id_team) {
        try {
            Player player = new Player();

            player.setFirst_name(firstName);
            player.setLast_name(lastName);
            player.setId_team(id_team);
            playerService.savePlayer(player);
            eventLogger.log(player, AuditEvent.CREATE);
            return ResponseEntity.status(HttpStatus.FOUND)
                    .header("Location", "/players")
                    .build();
        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @RequestMapping(value = "/players/{id_player}", method = RequestMethod.GET)
    public ResponseEntity<?> selectedPlayer(@PathVariable("id_player") long id_player, @RequestHeader("Accept") String acceptHeader) {
        if (acceptHeader.contains(MediaType.TEXT_HTML_VALUE)) {
            return ResponseEntity.status(HttpStatus.OK).body(
                    transform2XLT_player(playerService.finAll(), "Player.xslt",id_player)
            );
        } else {
            return ResponseEntity.status(HttpStatus.OK).body(
                    transform2XLT_player(playerService.finAll(), "Player.xslt",id_player)
            );
        }
    }


    @RequestMapping(value = "/players/delete/{id_player}", method = RequestMethod.GET,
            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<?> softDeletePlayer(@PathVariable("id_player") Long id_player) {
        try{
            playerService.deletePlayer(id_player);
            return ResponseEntity.status(HttpStatus.FOUND)
                    .header("Location", "/players")
                    .build();
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
   /* @RequestMapping(value = "/add-player", method = RequestMethod.POST,
            produces = { MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<?> addPlayer(@RequestBody PlayerCreatReq player){
        try{
            playerService.savePlayer(player);
            return ResponseEntity.status(HttpStatus.CREATED).body("Player successfully created");
        }catch (IllegalArgumentException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }*/
}
