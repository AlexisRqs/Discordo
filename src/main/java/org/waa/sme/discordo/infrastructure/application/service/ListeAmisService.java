package org.waa.sme.discordo.infrastructure.application.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.waa.sme.discordo.infrastructure.application.model.ListeAmis;
import org.waa.sme.discordo.infrastructure.application.model.Users;
import org.waa.sme.discordo.infrastructure.application.repository.ListeAmisRepository;
import org.waa.sme.discordo.infrastructure.application.repository.UsersRepository;

import java.util.List;
import java.util.Optional;


@Data
@Service
public class ListeAmisService {
    @Autowired
    private ListeAmisRepository listeAmisRepository;
    @Autowired
    private UsersService usersService;
    @Autowired
    private UsersRepository usersRepository;


    public ListeAmis saveListeAmis(ListeAmis listeAmis){
        //return listeAmisRepository.save(listeAmis);
        Optional<Users> savedUsers = usersService.getUsers(1L);
        //usersRepository.save(savedUsers).setListeAmis((List<ListeAmis>) listeAmis);
        //usersService.getUsers(listeAmis.getIdUser1()).get().getListeAmis().add(listeAmis);
        //usersService.getUsers(1L).get().getListeAmis().add(listeAmis);
        return getListeAmis(Long.valueOf(1));
    }

    public ListeAmis getListeAmis(Long idUsers1) {
        List<ListeAmis> listeAmis = usersService.getUsers(idUsers1).get().getListeAmis();
        for (ListeAmis amis : listeAmis) {
            if (amis.getUsers().getId().equals(idUsers1)) {
                if (amis.getAccepte().equals(true)) {
                    return amis;
                }
            }
        }
        return null;
    }

    public String ajoutAmisId(Long idUsers1, Long idUsers2) {
        List<ListeAmis> listeAmis = usersService.getUsers(idUsers1).get().getListeAmis();
        for (ListeAmis amis : listeAmis) {
            if (amis.getIdUser2().equals(idUsers2)) {
                if (amis.getAccepte().equals(true)) {
                    return "deja ami";
                } else if (amis.getEnAttente().equals(true)) {
                    return "votre demande est en attente";
                } else if (amis.getBloquee().equals(true)) {
                    return "vous avez bloqué cet utilisateur";
                }
            }
        }
        List<ListeAmis> listeAmis2 = usersService.getUsers(idUsers2).get().getListeAmis();
        for (ListeAmis amis2 : listeAmis2) {
            if (amis2.getAccepte().equals(true)) {
                return "deja ami";
            } else if (amis2.getEnAttente().equals(true)) {
                amis2.setAccepte(true);
                amis2.setEnAttente(false);
                listeAmisRepository.save(amis2);
                return "L'utilisateur vous avais deja envoyé une demande, vous venez de l'accepter";
            } else if (amis2.getBloquee().equals(true)) {
                return "l'utilisateur n'est pas disponible";
            }
        }
        //creation de la demande d'ami
        ListeAmis listeAmis1 = new ListeAmis();
        listeAmis1.setUsers(usersService.getUsers(idUsers1).get());
        listeAmis1.setIdUser2(idUsers2);
        listeAmis1.setEnAttente(true);
        listeAmis1.setBloquee(false);
        listeAmis1.setAccepte(false);
        listeAmis1.setIdBloqueur(0L);
        listeAmisRepository.save(listeAmis1);
        return "une demande à été envoyé";
    }

    public String ajoutAmisMail(Long idUsers1, String Mail) {
        List<ListeAmis> listeAmis = usersService.getUsers(idUsers1).get().getListeAmis();
        for (ListeAmis amis : listeAmis) {
            if (usersService.getUsersMail(Mail).get().getId().equals(amis.getIdUser2())) {
                if (amis.getAccepte().equals(true)) {
                    return "deja ami";
                } else if (amis.getEnAttente().equals(true)) {
                    return "votre demande est en attente";
                } else if (amis.getBloquee().equals(true)) {
                    return "vous avez bloqué cet utilisateur";
                }
            }
        }
        List<ListeAmis> listeAmis2 = usersService.getUsersMail(Mail).get().getListeAmis();
        for (ListeAmis amis2 : listeAmis2) {
            if (amis2.getIdUser2().equals(idUsers1)) {
                if (amis2.getAccepte().equals(true)) {
                    return "deja ami";
                } else if (amis2.getEnAttente().equals(true)) {
                    amis2.setAccepte(true);
                    amis2.setEnAttente(false);
                    listeAmisRepository.save(amis2);
                    return "L'utilisateur vous avais deja envoyé une demande, vous venez de l'accepter";
                } else if (amis2.getBloquee().equals(true)) {
                    return "l'utilisateur n'est pas disponible";
                }
            }
        }
        //creation de la demande d'ami
        ListeAmis listeAmis1 = new ListeAmis();
        listeAmis1.setUsers(usersService.getUsers(idUsers1).get());
        listeAmis1.setIdUser2(usersService.getUsersMail(Mail).get().getId());
        listeAmis1.setEnAttente(true);
        listeAmis1.setBloquee(false);
        listeAmis1.setAccepte(false);
        listeAmis1.setIdBloqueur(0L);
        listeAmisRepository.save(listeAmis1);
        return "une demande à été envoyé";
    }





    /*
    public ListeAmis saveListeAmis(Long idUsers) {
        Optional<Users> users = usersService.getUsers(idUsers);
        ListeAmis listeAmis = new ListeAmis();
        //users.get().setListeAmis((List<ListeAmis>) listeAmis);
        usersService.getUsers(idUsers).get().getListeAmis().add(listeAmis);
        return null;
    }
    */

    /*public boolean saveListeAmis(ListeAmis listeAmis){
        //return listeAmisRepository.save(listeAmis);
        Optional<Users> savedUsers = usersService.getUsers(Long.valueOf(1));
        usersRepository.save(savedUsers).setListeAmis((List<ListeAmis>) listeAmis);
        //return usersService.getUsers(Long.valueOf(1)).get().getListeAmis().add(listeAmis);
        return true;
    }*/
/*
    public String getTopic(Long idUsers, Long idUsers2) {
        Optional<Users> users = usersService.getUsers(idUsers);
        ListeAmis listeAmis = usersService.getListeAmis(idUsers);
        //return listeAmis.getTopic();
        return null;
    }
    */

}
