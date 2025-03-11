package com.boost.boardgames.modele;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "boardgame")
public class Boardgame {

    @Id
    private long idBoardgame;

    @Getter
    @Setter
    private String gameNom;

    @Getter
    @Setter
    private Integer joueurMin;

    @Getter
    @Setter
    private Integer joueurMax;

    // L'attribut Categorie est maintenant un simple String
    @Getter
    @Setter
    private String categorie;

    // Constructeur par défaut
    public Boardgame() {}

}
