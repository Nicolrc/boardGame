package com.boost.boardgames.service;

import com.boost.boardgames.modele.Boardgame;
import com.boost.boardgames.repository.BoardgameRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class BoardgameServicImpl implements BoardgameService{

    private final BoardgameRepository boardgameRepository;

    public BoardgameServicImpl(BoardgameRepository boardgameRepository) {
        this.boardgameRepository = boardgameRepository;
    }

    @Override
    public Boardgame creer(Boardgame boardgame) {
        return boardgameRepository.save(boardgame);
    }

    @Override
    public List<Boardgame> Lire() {
        return boardgameRepository.findAll();
    }

    @Override
    public Boardgame modifier(Long id, Boardgame boardgame) {
        return boardgameRepository.findById(id)
                .map(p->{
                    p.setGameNom(boardgame.getGameNom());
                    p.setJoueurMin(boardgame.getJoueurMin());
                    p.setJoueurMax(boardgame.getJoueurMax());
                    return boardgameRepository.save(p);
                }).orElseThrow(() -> new RuntimeException("Jeux de société non trouvé") );
    }

    @Override
    public String supprimer(Long id) {
        boardgameRepository.deleteById(id);
        return "Jeux de société supprimé !";
    }
}
