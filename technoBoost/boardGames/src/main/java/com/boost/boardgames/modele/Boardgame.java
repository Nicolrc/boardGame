package com.boost.boardgames.modele;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "boardgame")
public class Boardgame {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_Boardgame;

    @Getter
    @Setter
    @Column(name = "game_nom")
    private String GameNom;

    @Getter
    @Setter
    @Column(name = "joueur_min")
    private Integer joueurMin;

    @Getter
    @Setter
    @Column(name = "joueur_max")
    private Integer joueurMax;

    @ManyToOne
    @JoinColumn(name = "id_categorie")
    private Categorie Categorie;

    public Boardgame() {

    }

    public Boardgame(String GameNom, Integer joueurMin, Integer joueurMax, Categorie Categorie) {
        this.GameNom = GameNom;
        this.joueurMin = joueurMin;
        this.joueurMax = joueurMax;
        this.Categorie = Categorie;
    }

}
