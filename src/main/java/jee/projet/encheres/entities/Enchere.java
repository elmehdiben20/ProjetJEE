package jee.projet.encheres.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Enchere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idEnchere;
    private String statut;
    private LocalDate dateDebut;
    private LocalDate dateFin;
    private LocalTime heureDebut;
    private LocalTime heureFin;
    private double prixFinal;

    // Relation : Enchère : 1-N : Produit :   //
    @ManyToOne
    @JoinColumn(name = "idProduit")
    private Produit produit;

    // Declarer le remportant
    private int idGagnant;

    // Relation : enchere : participation  //

    @OneToMany(mappedBy = "enchere")
    private List<Participation> participations;


}