package org.waa.sme.discordo.application.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;
import lombok.ToString;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@Table(name = "Users")
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
    @Column(name = "date_Naissance")
    private String date_Naissance;

    @ToString.Exclude
    @JsonBackReference
    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "ListeAmis", joinColumns = @JoinColumn(name = "id"), inverseJoinColumns = @JoinColumn(name = "idUsers1"))
    private List<ListeAmis> listeAmis = new ArrayList<ListeAmis>();

}
