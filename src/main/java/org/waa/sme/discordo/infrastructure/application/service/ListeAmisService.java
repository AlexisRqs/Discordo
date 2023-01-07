package org.waa.sme.discordo.infrastructure.application.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.waa.sme.discordo.infrastructure.application.model.ListeAmis;
import org.waa.sme.discordo.infrastructure.application.model.Users;
import org.waa.sme.discordo.infrastructure.application.repository.ListeAmisRepository;

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


    public int getEtatRelation(Long idUsers1, Long idUsers2) {
        ListeAmis listeAmis = (ListeAmis) listeAmisRepository.findAll();
        //ListeAmis listeAmis = usersService.getListeAmis(idUsers1);
        if (listeAmis.getIdUser1()==idUsers1 && listeAmis.getIdUser2()==idUsers2) {
            if (listeAmis.getEtatRelation().getEnAttente()) {
                return 1;
            } else if (listeAmis.getEtatRelation().getAccepte()) {
                return 2;
            } else if (listeAmis.getEtatRelation().getBloquee()) {
                return 3;
            }
        }
        return 0;
    }

    public String getTopic(Long idUsers, Long idUsers2) {
        Optional<Users> users = usersService.getUsers(idUsers);
        ListeAmis listeAmis = usersService.getListeAmis(idUsers);
        //return listeAmis.getTopic();
        return null;
    }

}
