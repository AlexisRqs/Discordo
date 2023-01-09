package org.waa.sme.discordo.application.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.waa.sme.discordo.infrastructure.application.repository.IdTopicRepository;

@Data
@Service
public class IdTopicService {
    @Autowired
    private IdTopicRepository listeAmiRepository;

}
