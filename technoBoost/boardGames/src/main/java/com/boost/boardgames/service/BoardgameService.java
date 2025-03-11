package com.boost.boardgames.service;

import com.boost.boardgames.modele.Boardgame;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Service

public class BoardgameService{

    private final DataSource dataSource;

    @Autowired
    public BoardgameService(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public void addGame(Boardgame game) throws SQLException {
        try (Connection conn = dataSource.getConnection()){

            String selectCategorieSql = "SELECT id_categorie FROM categorie WHERE cat_nom = ?";
            try (PreparedStatement stmt = conn.prepareStatement(selectCategorieSql)){
                stmt.setString(1, game.getCategorie());

                try(ResultSet rs = stmt.executeQuery()){
                    if(rs.next()){
                        long idCategorie = rs.getLong("id_categorie");

                        String insertGameSql = "INSERT INTO boardgame (game_nom, joueur_min, joueur_max, id_categorie) VALUES (?,?,?,?)";
                        try (PreparedStatement insertStmt = conn.prepareStatement(insertGameSql)){
                            insertStmt.setString(1, game.getGameNom());
                            insertStmt.setInt(2, game.getJoueurMin());
                            insertStmt.setInt(3, game.getJoueurMax());
                            insertStmt.setLong(4, idCategorie);

                            int rowsAffected = insertStmt.executeUpdate();
                            if(rowsAffected > 0){
                                System.out.println("Jeu ajouté avec succès !");
                            } else {
                                System.out.println("Erreur lors de l'ajout du jeu. ");
                            }
                        }
                    } else {
                        System.out.println("Categorie n'existe pas !");
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
