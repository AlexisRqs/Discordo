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

    @PostMapping("/users/{id}/listeAmis/ajout")
    public ListeAmis ajoutListeAmis(@RequestBody ListeAmis listeAmis, @PathVariable Long idUsers) {
        return listeAmisService.saveListeAmis(listeAmis, idUsers);
    }

    @GetMapping("/users/{id}/listeAmis/etatRelation/{id2}")
    public int getEtatRelation(@PathVariable Long idUsers, @PathVariable Long idUsers2) {
        return listeAmisService.getEtatRelation(idUsers, idUsers2);
    }



}
