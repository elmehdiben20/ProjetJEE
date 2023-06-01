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
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idProduit;
    private String nomProduit;
    private String descriptionProduit;
    private double prixInitial;

    // Relation : utilisateur : 1-N : produit  //
    @ManyToOne
    @JoinColumn(name = "idUtilisateur")
    private Utilisateur utilisateur;


    // Relation : Produit :1-N : Enchère  //
    @OneToMany(mappedBy = "produit")
    private List<Enchere> encheres;


    // Relation : Catégorie : 1-N : Produit  //
    @ManyToOne
    @JoinColumn(name = "idCategorie")
    private Categorie categorie;

    // Statut pour indiquer s'il est vendu ou pas.
    private  String statutProduit;

    // Relation : Produit : Image
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "produit")
    private List<Image> images;


}
