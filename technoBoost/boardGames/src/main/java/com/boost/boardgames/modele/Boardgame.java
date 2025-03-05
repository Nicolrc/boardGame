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

    @Column(name = "joueur_min")
    private Integer JoueurMin;

    @Column(name = "joueur_max")
    private Integer JoueurMax;

    @ManyToOne
    @JoinColumn(name = "id_categorie")
    private Categorie Categorie;

    public Boardgame() {

    }

    public Boardgame(String GameNom, Integer JoueurMin, Integer JoueurMax, Categorie Categorie) {
        this.GameNom = GameNom;
        this.JoueurMin = JoueurMin;
        this.JoueurMax = JoueurMax;
        this.Categorie = Categorie;
    }

}
