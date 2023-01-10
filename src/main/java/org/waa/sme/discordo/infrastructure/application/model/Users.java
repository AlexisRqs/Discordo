package org.waa.sme.discordo.infrastructure.application.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.ToString;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;
import java.io.Serializable;

@Data
@Table(name = "users")
@Entity
public class Users implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nom")
    private String nom;
    @Column(name = "prenom")
    private String prenom;
    @Column(name = "mail")
    private String mail;
    @Column(name = "password")
    private String password;
    @Column(name = "banni")
    private Boolean banni;
    @Column(name = "date_naissance")
    private String date_Naissance;
    @Column(name = "ip")
    private String ip;
    @Column(name = "port")
    private Short port;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
    private List<ListeAmis> listeAmis;
}