package org.waa.sme.discordo.infrastructure.application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.waa.sme.discordo.infrastructure.application.model.Topic;
import org.waa.sme.discordo.infrastructure.application.service.TopicService;

import java.util.List;
@RestController
public class IdTopicController {
    @Autowired
    private TopicService topicService;

    // TOUT LES SET DE TOPIC
    @PutMapping("/topic/{idUsers1}/setTopic/{idUsers2}")
    public Topic setTopic(@PathVariable Long idUsers1, @PathVariable Long idUsers2) {
        return topicService.setTopic(idUsers1, idUsers2);
    }
    @PutMapping("/topic/{idUsers1}/setMessageEnAttente/{idUsers2}")
    public void setMessageEnAttente(@PathVariable Long idUsers1, @PathVariable Long idUsers2, @RequestBody String message) {
        topicService.setMessageEnAttente(idUsers1, idUsers2, message);
    }
    @PutMapping("/topic/{idUsers1}/setPath/{idUsers2}")
    public void setPath(@PathVariable Long idUsers1, @PathVariable Long idUsers2, @RequestBody String path) {
        topicService.setPath(idUsers1, idUsers2, path);
    }

    //TOUT LES GET DE TOPIC
    @GetMapping("/topic/{idUsers1}/getTopic/{idUsers2}")
    public Topic getTopic(@PathVariable Long idUsers1, @PathVariable Long idUsers2) {
        return topicService.getTopic(idUsers1, idUsers2);
    }
    @GetMapping("/topic/{idUsers1}/getTopicId/{idUsers2}")
    public Long getTopicId(@PathVariable Long idUsers1, @PathVariable Long idUsers2) {
        return topicService.getTopicId(idUsers1, idUsers2);
    }
    @GetMapping("/topic/{idUsers1}/getMessageEnAttente/{idUsers2}")
    public String getMessageEnAttente(@PathVariable Long idUsers1, @PathVariable Long idUsers2) {
        return topicService.getMessageEnAttente(idUsers1, idUsers2);
    }
    @GetMapping("/topic/{idUsers1}/getPath/{idUsers2}")
    public String getPath(@PathVariable Long idUsers1, @PathVariable Long idUsers2) {
        return topicService.getPath(idUsers1, idUsers2);
    }

    //TOUT LES DELETE DE TOPIC
    @DeleteMapping("/topic/{idUsers1}/deleteMessageEnAttente/{idUsers2}")
    public void deleteMessageEnAttente(@PathVariable Long idUsers1, @PathVariable Long idUsers2) {
        topicService.deleteMessageEnAttente(idUsers1, idUsers2);
    }

}
