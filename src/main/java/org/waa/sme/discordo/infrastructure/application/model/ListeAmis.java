package org.waa.sme.discordo.infrastructure.application.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@Table(name = "ListeAmis")
@Entity
public class ListeAmis implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "idUsers1")
    private int idUser1;
    @Column(name = "idUsers2")
    private int idUser2;

    @ToString.Exclude
    @JsonBackReference
    @OneToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "etatRelation")
    private EtatRelation etatRelation ;

    @ToString.Exclude
    @JsonBackReference
    @OneToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "idTopic")
    private IdTopic idTopic ;
}
