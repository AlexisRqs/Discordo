package org.waa.sme.discordo.infrastructure.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.waa.sme.discordo.infrastructure.application.model.ListeAmis;
import org.waa.sme.discordo.infrastructure.application.service.ListeAmisService;
import org.waa.sme.discordo.infrastructure.application.service.UsersService;


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

    @PostMapping("/users/{id}/listeAmis")
    public ListeAmis createListeAmis(@RequestBody ListeAmis listeAmis, @PathVariable Long idUsers) {
        return listeAmisService.saveListeAmis(listeAmis, idUsers);
    }


}
