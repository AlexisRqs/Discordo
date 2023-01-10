package org.waa.sme.discordo.infrastructure.application.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.ToString;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Table(name = "liste_amis")
@Entity
public class ListeAmis implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_users_1")
    private Users users;

    /*@Column(name = "id_users_1")
    private Long idUser1;*/

    @Column(name = "id_users_2")
    private Long idUser2;

    @Column(name = "en_attente")
    private Boolean enAttente;
    @Column(name = "accepte")
    private Boolean accepte;
    @Column(name = "bloquee")
    private Boolean bloquee;

    @Column(name = "id_bloqueur")
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
    @JoinTable(name = "id_topic", joinColumns = @JoinColumn(name = "id_topic_id"), inverseJoinColumns = @JoinColumn(name = "id_liee_id_topic"))
    private IdTopic idTopic;

}