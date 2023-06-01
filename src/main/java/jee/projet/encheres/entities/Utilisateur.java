package jee.projet.encheres.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idUtilisateur;
    private String telephone;
    private String nom;
    private String prenom;
    private String email;
    private String mdp;
    private String typeUtilisateur;

    // Relation : utilisateur : 1-N : produit  //
    @OneToMany(mappedBy = "utilisateur")
    private List<Produit> produits;

    // Relation : utilisateur : participation  //

    @OneToMany(mappedBy = "utilisateur")
    private List<Participation> participations;

    private String blackList;
    private LocalDate dateExpiration;

}
