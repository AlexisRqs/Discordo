package org.waa.sme.discordo.infrastructure.application.model;

import lombok.Data;

import jakarta.persistence.*;
import java.io.Serializable;

@Data
@Table(name = "IdTopic")
@Entity
public class IdTopic implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "id_lieeIdTopic")
    private Long id_lieeIdTopic;

    @Column(name = "path")
    private String path;
    @Column(name = "msgEnAttente")
    private String msgEnAttente;
}
