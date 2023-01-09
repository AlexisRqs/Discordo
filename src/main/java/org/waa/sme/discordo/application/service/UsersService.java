package org.waa.sme.discordo.application.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.waa.sme.discordo.infrastructure.application.model.Users;
import org.waa.sme.discordo.infrastructure.application.repository.UsersRepository;

import java.util.Optional;

@Data
@Service
public class UsersService {
    @Autowired
    private UsersRepository usersRepository;


    public Users saveUsers(Users users) {
        Users savedUsers = usersRepository.save(users);
        return savedUsers;
    }

    public void deleteUsers(final Long id) {
        usersRepository.deleteById(id);
    }

    public Optional<Users> getUsers(final Long id) {
        return usersRepository.findById(id);
    }

    public Optional<Users> getUsersMail(final String email) {
        Iterable<Users> Allusers = usersRepository.findAll();
        for (Users users : Allusers) {
            if (users.getMail().equals(email)) {
                return usersRepository.findById(users.getId());
            }
        }
        return null;
    }

    public Optional<Users> connexion(String email, String password) {
        Iterable<Users> Allusers = usersRepository.findAll();
        for (Users users : Allusers) {
            if (users.getMail().equals(email) && users.getPassword().equals(password)) {
                return usersRepository.findById(users.getId());
            }
        }
        return null;
    }

    /*public ListeAmis getListeAmis(final Long idUsers) {
        return usersRepository.findById(idUsers).get().getListeAmis();
    }*/





}
