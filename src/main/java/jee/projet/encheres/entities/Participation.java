package jee.projet.encheres.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Participation
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idParticipation;

    @ManyToOne
    @JoinColumn(name = "idEnchere")
    private Enchere enchere;

    @ManyToOne
    @JoinColumn(name = "idUtilisateur")
    private Utilisateur utilisateur;
}
