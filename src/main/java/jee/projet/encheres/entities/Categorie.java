package jee.projet.encheres.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCategorie;
    private String nomCategorie;
    private String descriptionCategorie;

    // Relation : Catégorie : 1-N : Produit : //
    @OneToMany(mappedBy = "categorie")
    private List<Produit> produits;
}
