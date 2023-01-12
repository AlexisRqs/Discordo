package org.waa.sme.discordo.testListeAmis;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.waa.sme.discordo.infrastructure.application.controller.ListeAmisController;
import org.waa.sme.discordo.infrastructure.application.controller.UsersController;
import org.waa.sme.discordo.infrastructure.application.service.ListeAmisService;

@RunWith(MockitoJUnitRunner.class)
public class getListAmis {

    @InjectMocks
    private ListeAmisController listeAmisController;

    @Mock
    private ListeAmisService listeAmisService;

    @Test
    public void testGetListeAmis() {
        // given
        Long idUsers = 1L;
        List<String> expectedResult = Arrays.asList("rigolo fedro");

        when(listeAmisService.getListeAmis(idUsers)).thenReturn(expectedResult);

        // when
        List<String> result = listeAmisController.getListeAmis(idUsers);

        // then
        assertEquals(expectedResult, result);
    }
}

