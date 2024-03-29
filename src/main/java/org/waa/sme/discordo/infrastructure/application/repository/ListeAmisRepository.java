package org.waa.sme.discordo.infrastructure.application.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.waa.sme.discordo.infrastructure.application.model.ListeAmis;
import org.waa.sme.discordo.infrastructure.application.model.Users;

@Repository
public interface ListeAmisRepository extends CrudRepository<ListeAmis, Long> {
}
