package com.boost.boardgames.modele;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "Categorie")
public class Categorie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_Categorie;

    @Getter
    @Setter
    @Column(name = "cat_nom")
    private String catnom;

    public Categorie() {

    }

    public Categorie(String catnom) {
        this.catnom = catnom;
    }

}
