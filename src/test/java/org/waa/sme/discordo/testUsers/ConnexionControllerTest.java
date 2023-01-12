package org.waa.sme.discordo.testUsers;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import org.waa.sme.discordo.infrastructure.application.service.UsersService;
import org.waa.sme.discordo.infrastructure.application.controller.UsersController;

@RunWith(MockitoJUnitRunner.class)
public class ConnexionControllerTest {

    @InjectMocks
    private UsersController connexionController;

    @Mock
    private UsersService usersService;

    @Test
    public void testConnexion() {
        // given
        String email = "bobletesteurfou@mail.com";
        String password = "mdpdebob";

        Long expectedResult = 1L;
        when(usersService.connexion(email, password)).thenReturn(expectedResult);

        // when
        Long result = connexionController.connexion(email, password);

        // then
        assertEquals(expectedResult, result);
    }
}

