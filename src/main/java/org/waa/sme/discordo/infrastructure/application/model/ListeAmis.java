package org.waa.sme.discordo.infrastructure.application.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Table(name = "liste_amis")
@Entity
public class ListeAmis {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_users_1")
    private Users users;

    @Column(name = "id_Users2")
    private Long idUser2;
    @Column(name = "id_demandeur")
    private Long id_demandeur;

    @Column(name = "en_Attente")
    private Boolean enAttente;
    @Column(name = "accepte")
    private Boolean accepte;
    @Column(name = "bloquee")
    private Boolean bloquee;
    @Column(name = "id_bloqueur")
    private Long idBloqueur = null;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_topic")
    private Topic topic;

}
