package org.waa.sme.discordo.infrastructure.application.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.waa.sme.discordo.infrastructure.application.model.ListeAmis;
import org.waa.sme.discordo.infrastructure.application.model.Users;
import org.waa.sme.discordo.infrastructure.application.repository.ListeAmisRepository;
import org.waa.sme.discordo.infrastructure.application.repository.UsersRepository;
import java.util.Optional;


@Data
@Service
public class ListeAmisService {
    @Autowired
    private ListeAmisRepository listeAmisRepository;
    @Autowired
    private UsersService usersService;

    public ListeAmis saveListeAmis(ListeAmis listeAmis, Long idUsers) {
        Optional<Users> users = usersService.getUsers(idUsers);
        users.get().setListeAmis(listeAmis);
        return null;
    }

}
