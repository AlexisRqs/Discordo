package org.waa.sme.discordo.infrastructure.application.model;

import jakarta.persistence.*;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.ToString;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

@Data
@Table(name = "Users")
@Entity
public class Users {

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
    @Column(name = "date_Naissance")
    private String date_Naissance;
    @Column(name = "ip")
    private String ip;
    @Column(name = "port")
    private Short port;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "users")
    private List<ListeAmis> listeAmis;
   /* @OneToMany(fetch = FetchType.LAZY, mappedBy = "users2")
    private List<ListeAmis> listeAmis2;*/
}
