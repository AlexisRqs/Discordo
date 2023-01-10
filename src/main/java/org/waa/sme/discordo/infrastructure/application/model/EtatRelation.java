package org.waa.sme.discordo.infrastructure.application.model;

import lombok.Data;

import jakarta.persistence.*;
import java.io.Serializable;

@Data
@Table(name = "EtatRelation")
@Entity
public class EtatRelation implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEtatRelation;

    @Column(name = "id_lieeEtatRelation")
    private Long id_lieeEtatRelation;

    @Column(name = "enAttente")
    private Boolean enAttente;
    @Column(name = "accepte")
    private Boolean accepte;
    @Column(name = "bloquee")
    private Boolean bloquee;

}
