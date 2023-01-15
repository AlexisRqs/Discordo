package org.waa.sme.discordo.testListeAmis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.core.AutoConfigureCache;
import org.waa.sme.discordo.infrastructure.application.controller.ListeAmisController;
import org.waa.sme.discordo.infrastructure.application.controller.UsersController;
import org.waa.sme.discordo.infrastructure.application.service.ListeAmisService;
import org.waa.sme.discordo.infrastructure.application.service.UsersService;
import org.waa.sme.discordo.infrastructure.application.model.Users;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class getListAmisEnAttente {

    @InjectMocks
    private UsersController usersController;

    @InjectMocks
    private ListeAmisController listeAmisController;

    @Mock UsersService usersService;

    @Mock
    private ListeAmisService listeAmisService;

    @Test
    public void testGetListeAmisEnAttente() {

        Users users = new Users();
        String mail = "bobletesteur@mail.com";
        users.setId(1L);
        users.setNom("bob");
        users.setPrenom("testeur");
        users.setMail("bobletesteurfou@mail.com");
        users.setPassword("mdpdebob");

        Users users2 = new Users();
        String mail2 = "bobletesteurfou@mail.com";
        users2.setId(1L);
        users2.setNom("bob");
        users2.setPrenom("testeur");
        users2.setMail("bobletesteurfou@mail.com");
        users2.setPassword("mdpdebob");

        Users bebop = usersController.updateUsers(users);
        Users bebop2 = usersController.updateUsers(users2);

        System.out.println(usersController.getUsersBis(1L));

        String ficelle = listeAmisController.ajoutAmisMail(1L,mail);
        //listeAmisController.accepterAmiEnAttente(2L,1L);

        // given
        Long idUsers = 2L;
        List<String> expectedResult = Arrays.asList("bob testeur");

        //when(listeAmisService.getListeAmisEnAttente(idUsers)).thenReturn(expectedResult);

        // when
        List<String> result = listeAmisController.getListeAmisEnAttente(idUsers);
        System.out.println(result);

        // then
        assertEquals(expectedResult, result);
    }
}

