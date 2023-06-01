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
@Setter
@Getter
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idImage;
    @Lob
    private byte[] image;
    //Relation : Image - Produit
    @ManyToOne
    @JoinColumn(name = "idProduit")
    private Produit produit;


}

