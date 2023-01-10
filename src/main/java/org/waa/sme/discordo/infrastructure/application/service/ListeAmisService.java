package org.waa.sme.discordo.infrastructure.application.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.waa.sme.discordo.infrastructure.application.model.ListeAmis;
import org.waa.sme.discordo.infrastructure.application.model.Users;
import org.waa.sme.discordo.infrastructure.application.repository.ListeAmisRepository;
import org.waa.sme.discordo.infrastructure.application.repository.UsersRepository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

    /*
    liste fonctionnalitées
        -ajouter
     */

@Data
@Service
public class ListeAmisService {
    @Autowired
    private ListeAmisRepository listeAmisRepository;
    @Autowired
    private UsersService usersService;
    @Autowired
    private UsersRepository usersRepository;

    public List<ListeAmis> getListeAmis(Long idUsers1) {
        System.out.println("liste amiiiiiiiiiiiiiiiiiiis : ");
        List<ListeAmis> listeAmis = usersService.getUsers(idUsers1).get().getListeAmis();
        for (ListeAmis amis : listeAmis) {
            long mathnul = 1;
            long mathnul2 = 1;
            mathnul2 =mathnul+mathnul2;
            //System.out.println("liste petit : " + amis);
        }
        return null;
        /*System.out.println("1");
        Iterable<ListeAmis> listeAmisAll = listeAmisRepository.findAll();
        System.out.println(listeAmisAll);
        System.out.println("2");
        List<ListeAmis> listeAmisAcceptes= new ArrayList<ListeAmis>();
        System.out.println("3");;
        for (ListeAmis amis : listeAmisAll) {
            System.out.println("4");
            if (amis.getAccepte().equals(true)) {
                System.out.println("5");
                listeAmisAcceptes.add(amis);
            }
        }
        return listeAmisAcceptes;*/
    }
    public ListeAmis getDemandeAmis(Long idUsers1) {
        Iterable<ListeAmis> listeAmisAll = listeAmisRepository.findAll();
        for (ListeAmis amis : listeAmisAll) {
            if (amis.getEnAttente().equals(true) && amis.getIdUser2().equals(idUsers1)) {
                return amis;
            }
        }
        return null;
    }

    public String ajoutAmisIdBis(Long idUsers1, Long idUsers2) {
        Optional<Users> user1 = usersService.getUsers(idUsers1);

        List user2 = usersService.getUsers(idUsers2).get().getListeAmis();
        System.out.println(user2);
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
        //listeAmis1.setUsers(idUsers1);
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
        //listeAmis1.setIdUser1(idUsers1);
        listeAmis1.setUsers(usersService.getUsers(idUsers1).get());
        listeAmis1.setIdUser2(usersService.getUsersMail(Mail).get().getId());
        listeAmis1.setEnAttente(true);
        listeAmis1.setBloquee(false);
        listeAmis1.setAccepte(false);
        listeAmis1.setIdBloqueur(0L);
        listeAmisRepository.save(listeAmis1);
        return "une demande à été envoyé";
    }


    //FONCTION TESTS ABANDONNEES

    /*public ListeAmis getListeAmis(Long idUsers1) {
        List<ListeAmis> listeAmis = usersService.getUsers(idUsers1).get().getListeAmis();
        for (ListeAmis amis : listeAmis) {
            if (amis.getAccepte().equals(true)) {
                return amis;
            }
        }
        return null;
    }*/
    /*
    public String getTopic(Long idUsers, Long idUsers2) {
        Optional<Users> users = usersService.getUsers(idUsers);
        ListeAmis listeAmis = usersService.getListeAmis(idUsers);
        //return listeAmis.getTopic();
        return null;
    }
    */
    /*//fonction qui cree une relation entre deux utilisateurs
    public ListeAmis saveListeAmis(ListeAmis listeAmis){
        return listeAmisRepository.save(listeAmis);
    }*/

}
