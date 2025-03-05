package com.boost.boardgames.repository;

import com.boost.boardgames.modele.Boardgame;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoardgameRepository extends JpaRepository<Boardgame, Long> {

}
