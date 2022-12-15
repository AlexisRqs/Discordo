package org.waa.sme.discordo.infrastructure.application.repository;

import org.waa.sme.discordo.infrastructure.application.model.Users;

import org.springframework.data.repository.CrudRepository;
import org.springframework.scheduling.config.Task;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsersRepository extends CrudRepository<Users, Long> {
}
