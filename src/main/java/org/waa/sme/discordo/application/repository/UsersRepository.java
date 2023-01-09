package org.waa.sme.discordo.application.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.waa.sme.discordo.infrastructure.application.model.Users;

@Repository
public interface UsersRepository extends CrudRepository<Users, Long> {
}
