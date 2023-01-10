package org.waa.sme.discordo.infrastructure.application.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.ToString;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Table(name = "ListeAmis")
@Entity
public class ListeAmis implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "idUsers1")
    private Long idUser1;
    @Column(name = "idUsers2")
    private Long idUser2;

    @Column(name = "enAttente")
    private Boolean enAttente;
    @Column(name = "accepte")
    private Boolean accepte;
    @Column(name = "bloquee")
    private Boolean bloquee;

    @Column(name = "idBloqueur")
    private Long idBloqueur = null;
/*
    @ToString.Exclude
    @JsonBackReference
    @OneToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "EtatRelation", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "id_lieeEtatRelation"))
    private EtatRelation etatRelation;
*/
    @ToString.Exclude
    @JsonBackReference
    @OneToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "IdTopic", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "id_lieeIdTopic"))
    private IdTopic idTopic;

}
