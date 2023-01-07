package org.waa.sme.discordo.infrastructure.application.controller;

import org.waa.sme.discordo.infrastructure.application.model.EtatRelation;
import org.waa.sme.discordo.infrastructure.application.model.IdTopic;
import org.waa.sme.discordo.infrastructure.application.model.ListeAmis;
import org.waa.sme.discordo.infrastructure.application.model.Users;

// import org.waa.sme.discordo.infrastructure.application.repository.IdTopicRepository;
// import org.waa.sme.discordo.infrastructure.application.repository.IdTopicRepository;
// import org.waa.sme.discordo.infrastructure.application.repository.ListeAmisRepository;
import org.waa.sme.discordo.infrastructure.application.repository.UsersRepository;

// import org.waa.sme.discordo.infrastructure.application.service.IdTopicService;
// import org.waa.sme.discordo.infrastructure.application.service.IdTopicService;
// import org.waa.sme.discordo.infrastructure.application.service.ListeAmisService;
import org.waa.sme.discordo.infrastructure.application.service.UsersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

/*
    liste des fonctions :
    - Créer un Users
    - Supprimer un Users
    - Recuperer un Users
    - Afficher tout les users
    - Recuperer la liste amis
 */

@RestController
public class UsersController {
    @Autowired
    private UsersService usersService;

    @PostMapping("/users")
    public Users createUsers(@RequestBody Users users) {
        return usersService.saveUsers(users);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUsers(@PathVariable Long id) {
        usersService.deleteUsers(id);
    }

    @GetMapping("/users/{id}")
    public Users getUsers(@PathVariable Long id) {
        return usersService.getUsers(id).get();
    }

    @GetMapping("/users")
    public Iterable<Users> getUsers() {
        return usersService.getAllUsers();
    }

    @GetMapping("/users/listeAmis")
    public Iterable<Users> getListeAmis(@PathVariable Long idUsers) {
        return (Iterable<Users>) usersService.getListeAmis(idUsers);
    }
}
