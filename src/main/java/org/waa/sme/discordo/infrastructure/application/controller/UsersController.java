package org.waa.sme.discordo.infrastructure.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.waa.sme.discordo.infrastructure.application.model.Users;
import org.waa.sme.discordo.infrastructure.application.service.UsersService;

import java.util.List;
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

    // FROM PUT TO POST TTENTION LOOSER
    @PostMapping("/usersAjout")
    public Users updateUsers(@RequestBody Users users) {
        System.out.println("update users");
        return usersService.saveUsers(users);
    }
    @PostMapping("/users")
    public Users createUsers(@RequestBody Users users) {
        return usersService.saveUsers(users);
    }

    @PostMapping("/connexion/{email}")
    public Long connexion(@PathVariable String email, @RequestBody String password) {
        System.out.println("email : " + email + " password : " + password);
        return usersService.connexion(email, password);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUsers(@PathVariable Long id) {
        usersService.deleteUsers(id);
    }

    @GetMapping("/users/{id}")
    public Users getUsers(@PathVariable Long id) {
        return usersService.getUsers(id).get();
    }

    @GetMapping("/usersBis/{id}")
    public List<String> getUsersBis(@PathVariable Long id) {
        return usersService.getUsersBis(id);
    }

    @GetMapping("/usersPrecis/{email}")
    public Users getUsers(@PathVariable String email) {
        System.out.println("email : " + email);
        return usersService.getUsersMail(email).get();
    }
    @GetMapping("/usersPrecisBis/{email}")
    public List<String> getUsersBis(@PathVariable String email) {
        System.out.println("email : " + email);
        return usersService.getUserMailBis(email);
    }

    /*@GetMapping("/users/listeAmis")
    public Iterable<Users> getListeAmis(@PathVariable Long idUsers) {
        return (Iterable<Users>) usersService.getListeAmis(idUsers);
    }*/
}
