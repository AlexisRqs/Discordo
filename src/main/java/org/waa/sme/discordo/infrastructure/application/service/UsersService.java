package org.waa.sme.discordo.infrastructure.application.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.waa.sme.discordo.infrastructure.application.model.Users;
import org.waa.sme.discordo.infrastructure.application.repository.UsersRepository;

import java.util.ArrayList;
import java.util.List;

import java.util.Optional;

@Data
@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;


    /**
     * Permet d'enregistrer un user avec en paramètre un user
     * @return
     */
    public Users saveUsers(Users users) {
        String email = users.getMail();
        Iterable<Users> Allusers = usersRepository.findAll();
        for (Users usersFor : Allusers) {
            if (usersFor.getMail().equals(email)) {
                return null;
            }
        }
        Users savedUsers = usersRepository.save(users);
        return savedUsers;
    }

    /**
     * Permet de supprimer un user avec en paramètre un ID
     * @param id
     * @return
     */
    public void deleteUsers(final Long id) {
        usersRepository.deleteById(id);
    }

    /**
     * Permet de récupérer un user avec en paramètre un ID,
     * Ne pas utiliser cette méthode pour récupérer un user pour le front,
     * Préférer la méthode getUserBis
     * @param id
     * @return
     */
    public Optional<Users> getUsers(final Long id) {
        return usersRepository.findById(id);
    }

    /**
     * Permet de récupérer un user avec en paramètre un ID et retourne seulement son nom, prenom et mail
     * @return
     */
    public List<String> getUsersBis(final Long id) {
        List<String> list = new ArrayList<String>();
        list.add(usersRepository.findById(id).get().getNom());
        list.add(usersRepository.findById(id).get().getPrenom());
        list.add(usersRepository.findById(id).get().getMail());
        return list;
    }

    /**
     * Permet de trouver et recuperer un users par son mail et retourne son ID
     * @return
     */
    public Optional<Users> getUsersMail(final String email) {
        Iterable<Users> Allusers = usersRepository.findAll();
        for (Users users : Allusers) {
            if (users.getMail().equals(email)) {
                return usersRepository.findById(users.getId());
            }
        }
        return null;
    }

    /**
     * Permet de trouver et recuperer un users par son mail et retourne son nom, prenom, mail
     * @return
     */
    public List<String> getUserMailBis(final String email) {
        List<String> list = new ArrayList<String>();
        Iterable<Users> Allusers = usersRepository.findAll();
        for (Users users : Allusers) {
            if (users.getMail().equals(email)) {
                list.add(users.getNom());
                list.add(users.getPrenom());
                list.add(users.getMail());
            }
        }
        return list;
    }

    /**
     * Retourne la liste amis des deux usersId en paramètre
     * @return
     */
    public List<Users> getUsersRelationAmis (Long idDemandeur, Long idReveceur) {
        List<Users> listUsers = new ArrayList<Users>();
        listUsers.add(getUsers(idDemandeur).get());
        listUsers.add(getUsers(idReveceur).get());
        return listUsers;
    }

    /**
     * Permet de se connecter en verifiant les mails et les mots de passe
     * @return
     */
    public Long connexion(String email, String password) {
        Users user = getUsersMail(email).get();
        if (user.getPassword().equals(password)) {
            return user.getId();
        }
        return null;
    }
}
