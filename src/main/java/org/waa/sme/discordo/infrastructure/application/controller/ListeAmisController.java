package org.waa.sme.discordo.infrastructure.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.waa.sme.discordo.infrastructure.application.model.ListeAmis;
import org.waa.sme.discordo.infrastructure.application.service.ListeAmisService;


/*
    liste des fonctions :
    - Créer une liste d'amis
    - Supprimer un Users
    - Recuperer une listeAmis
    - Afficher tout les users
 */

@RestController
public class ListeAmisController {
    @Autowired
    private ListeAmisService listeAmisService;

    /*@PutMapping("/users/{id}/listeAmis/ajout")
    public ListeAmis ajoutListeAmis(@RequestBody ListeAmis listeAmis, @PathVariable Long idUsers) {
        return listeAmisService.saveListeAmis(listeAmis, idUsers);
    }*/
    /*@PutMapping("/users/{id}/listeAmis/ajout")
    public ListeAmis ajoutListeAmis(@PathVariable Long idUsers) {
        return listeAmisService.saveListeAmis(idUsers);
    }*/
    @PutMapping("/users/{id}/listeAmis/ajout")
    public ListeAmis ajoutListeAmis(@RequestBody ListeAmis listeAmis) {
        return listeAmisService.saveListeAmis(listeAmis);
    }

    @GetMapping("/users/{id}/listeAmis")
    public ListeAmis getListeAmis(@PathVariable Long idUsers) {
        return listeAmisService.getListeAmis(idUsers);
    }

    @PutMapping("/users/{idUsers1}/ajoutAmisId/{idUsers2}")
    public String ajoutAmisId(@PathVariable Long idUsers1, @PathVariable Long idUsers2) {
        return listeAmisService.ajoutAmisId(idUsers1, idUsers2);
    }

    @PutMapping("/users/{id}/ajoutAmisMail/{mail}")
    public String ajoutAmisId(@PathVariable Long idUsers1, @PathVariable String mail) {
        return listeAmisService.ajoutAmisMail(idUsers1, mail);
    }

    /*@GetMapping("/users/{id}/listeAmis/etatRelation/{id2}")
    public int getEtatRelation(@PathVariable Long idUsers, @PathVariable Long idUsers2) {
        return listeAmisService.getEtatRelation(idUsers, idUsers2);
    }*/



}
