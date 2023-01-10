package org.waa.sme.discordo.infrastructure.application.model;

import javax.persistence.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
}
