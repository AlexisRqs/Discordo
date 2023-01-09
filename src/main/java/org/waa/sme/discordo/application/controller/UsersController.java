package org.waa.sme.discordo.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.waa.sme.discordo.infrastructure.application.model.Users;
import org.waa.sme.discordo.infrastructure.application.service.UsersService;

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

    @PutMapping("/usersAjout")
    public Users updateUsers(@RequestBody Users users) {
        System.out.println("update users");
        return usersService.saveUsers(users);
    }
    @PostMapping("/users")
    public Users createUsers(@RequestBody Users users) {
        return usersService.saveUsers(users);
    }

    @GetMapping("/connexion/{email}/{password}")
    public Users connexion(@PathVariable String email, @PathVariable String password) {
        System.out.println("email : " + email + " password : " + password);
        return usersService.connexion(email, password).get();
    }

    @DeleteMapping("/users/{id}")
    public void deleteUsers(@PathVariable Long id) {
        usersService.deleteUsers(id);
    }

    @GetMapping("/users/{id}")
    public Users getUsers(@PathVariable Long id) {
        return usersService.getUsers(id).get();
    }

    @GetMapping("/usersPrecis/{email}")
    public Users getUsers(@PathVariable String email) {
        System.out.println("email : " + email);
        return usersService.getUsersMail(email).get();
    }

    /*@GetMapping("/users/listeAmis")
    public Iterable<Users> getListeAmis(@PathVariable Long idUsers) {
        return (Iterable<Users>) usersService.getListeAmis(idUsers);
    }*/
}
