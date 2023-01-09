package org.waa.sme.discordo.application.service;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.waa.sme.discordo.infrastructure.application.repository.EtatRelationRepository;

@Data
@Service
public class EtatRelationService {
    @Autowired
    private EtatRelationRepository etatRelationRepository;

}
