package org.waa.sme.discordo.infrastructure.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.waa.sme.discordo.infrastructure.application.model.ListeAmis;
import org.waa.sme.discordo.infrastructure.application.service.ListeAmisService;

import java.util.List;


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

    @GetMapping("/users/{idUsers}/listeAmis")
    public List<String> getListeAmis(@PathVariable Long idUsers) {
        return listeAmisService.getListeAmis(idUsers);
    }
    @GetMapping("/users/{idUsers}/listeAmisEnAttente")
    public List<String> getListeAmisEnAttente(@PathVariable Long idUsers) {
        return listeAmisService.getListeAmisEnAttente(idUsers);
    }

    @PutMapping("/users/{idUsers1}/ajoutAmisId/{idUsers2}")
    public String ajoutAmisId(@PathVariable Long idUsers1, @PathVariable Long idUsers2) {
        return listeAmisService.ajoutAmisId(idUsers1, idUsers2);
    }

    @PutMapping("/users/{idDemandeur}/ajoutAmisMail/{idUserABloquer}")
    public String ajoutAmisId(@PathVariable Long idDemandeur, @PathVariable String mailReceveur) {
        return listeAmisService.ajoutAmisMail(idDemandeur, mailReceveur);
    }

    @PutMapping("/users/{currentUserId}/bloquer/{idUserABloquer}/{bloquerBoolean}")
    public String amisBloquer(@PathVariable Long currentUserId, @PathVariable Long idUserABloquer, @PathVariable Boolean bloquerBoolean) {
        return listeAmisService.amisBloquer(currentUserId, idUserABloquer, bloquerBoolean);
    }

}
