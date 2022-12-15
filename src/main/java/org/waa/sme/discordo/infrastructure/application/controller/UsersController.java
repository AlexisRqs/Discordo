package org.waa.sme.discordo.infrastructure.application.controller;

import org.waa.sme.discordo.infrastructure.application.model.EtatRelation;
import org.waa.sme.discordo.infrastructure.application.model.IdTopic;
import org.waa.sme.discordo.infrastructure.application.model.ListeAmis;
import org.waa.sme.discordo.infrastructure.application.model.Users;

// import org.waa.sme.discordo.infrastructure.application.repository.IdTopicRepository;
// import org.waa.sme.discordo.infrastructure.application.repository.IdTopicRepository;
// import org.waa.sme.discordo.infrastructure.application.repository.ListeAmisRepository;
import org.waa.sme.discordo.infrastructure.application.repository.UsersRepository;

// import org.waa.sme.discordo.infrastructure.application.service.IdTopicService;
// import org.waa.sme.discordo.infrastructure.application.service.IdTopicService;
// import org.waa.sme.discordo.infrastructure.application.service.ListeAmisService;
import org.waa.sme.discordo.infrastructure.application.service.UsersService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Optional;

@RestController
public class UsersController {
    @Autowired
    private UsersService usersService;

    @PostMapping("/usersList")
    public UsersService createUsers(@RequestBody UsersService usersService) {
        return usersService.saveUsersService(usersService);
    }


}
