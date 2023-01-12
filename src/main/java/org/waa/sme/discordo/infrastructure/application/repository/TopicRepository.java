package org.waa.sme.discordo.infrastructure.application.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.waa.sme.discordo.infrastructure.application.model.Topic;

@Repository
public interface TopicRepository extends CrudRepository<Topic, Long> {
}
