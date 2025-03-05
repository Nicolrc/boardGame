package com.boost.boardgames.controller;

import com.boost.boardgames.modele.Boardgame;
import com.boost.boardgames.service.BoardgameService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boardgame")
public class BoardgameController {

    private final BoardgameService boardgameService;

    public BoardgameController(BoardgameService boardgameService) {
        this.boardgameService = boardgameService;
    }

    @PostMapping("/create")
    public Boardgame create(@RequestBody Boardgame boardgame) {
        return boardgameService.creer(boardgame);
    }

    @GetMapping
    public List<Boardgame> read() {
        return boardgameService.Lire();
    }

    @PutMapping("/update/{id}")
    public Boardgame update(@PathVariable Long id, @RequestBody Boardgame boardgame) {
        return boardgameService.modifier(id, boardgame);
    }

    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Long id) {
        return boardgameService.supprimer(id);
    }
}
