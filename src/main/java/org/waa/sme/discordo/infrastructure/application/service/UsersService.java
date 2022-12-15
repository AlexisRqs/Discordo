package org.waa.sme.discordo.infrastructure.application.service;

import org.waa.sme.discordo.infrastructure.application.model.Users;
import org.waa.sme.discordo.infrastructure.application.repository.UsersRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Data
@Service
public class UsersService {
    @Autowired
    private UsersService usersService;

    public UsersService saveUsersService(UsersService usersService) {
        UsersService savedUsersService = usersService.saveUsersService(usersService);
        return savedUsersService;
    }
}
