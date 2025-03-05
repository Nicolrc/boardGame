package com.boost.boardgames.service;

import com.boost.boardgames.modele.Boardgame;

import java.util.List;

public interface BoardgameService {

    Boardgame creer(Boardgame boardgame);

    List<Boardgame> Lire();

    Boardgame modifier(Long id, Boardgame boardgame);

    String supprimer(Long id);
}
