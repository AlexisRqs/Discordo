package org.waa.sme.discordo.infrastructure.application.model;

import lombok.Data;

import jakarta.persistence.*;
import java.util.List;

@Data
@Table(name = "topic")
@Entity
public class Topic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "topic")
    private List<ListeAmis> listeAmis;

    @Column(name = "path")
    private String path;
    @Column(name = "msg_en_attente")
    private String msgEnAttente;
    @Column(name = "id_user_envoie_msg_en_attente")
    private Long idUserEnvoieMsgEnAttente;
}
