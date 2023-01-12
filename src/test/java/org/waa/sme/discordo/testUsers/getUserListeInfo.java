package org.waa.sme.discordo.testUsers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.waa.sme.discordo.infrastructure.application.controller.UsersController;
import org.waa.sme.discordo.infrastructure.application.service.UsersService;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

import java.util.Optional;

@RunWith(MockitoJUnitRunner.class)
public class getUserListeInfo {

    @InjectMocks
    private UsersController usersController;

    @Mock
    private UsersService usersService;

    @Test
    public void testGetUsersBis() {
        // given
        Long id = 1L;
        List<String> expectedResult = Arrays.asList("rigolo fedro");

        when(usersService.getUsersBis(id)).thenReturn(expectedResult);

        // when
        List<String> result = usersController.getUsersBis(id);

        // then
        assertEquals(expectedResult, result);
    }
}

