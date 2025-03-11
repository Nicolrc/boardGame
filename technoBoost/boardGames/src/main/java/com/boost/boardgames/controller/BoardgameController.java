package com.boost.boardgames.controller;

import com.boost.boardgames.modele.Boardgame;
import com.boost.boardgames.service.BoardgameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/boardgame")
public class BoardgameController {

    private final BoardgameService boardgameService;

    @Autowired
    public BoardgameController(BoardgameService boardgameService) {
        this.boardgameService = boardgameService;
    }

    @PostMapping
    public ResponseEntity<String> addGame(@RequestBody Boardgame game){
        try {
            boardgameService.addGame(game);
            return ResponseEntity.ok("Jeu ajouté avec succès !");
        } catch (Exception e) {
            return ResponseEntity.status(500).body("Erreur lors de l'ajout du jeu : ");
        }
    }
}
