package org.waa.sme.discordo.testUsers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.waa.sme.discordo.infrastructure.application.controller.UsersController;
import org.waa.sme.discordo.infrastructure.application.service.UsersService;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class deleteUser {

    @InjectMocks
    private UsersController usersController;

    @Mock
    private UsersService usersService;

    @Test
    public void testDelete() {
        // given
        Long id = 1L;

        // when
        usersController.deleteUsers(id);

        // then
        verify(usersService).deleteUsers(id);
    }
}

