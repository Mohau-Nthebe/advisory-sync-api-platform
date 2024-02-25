package com.devmo.advisorysyncapiplatform.controller;

import com.devmo.advisorysyncapiplatform.Service.CommunicationService;
import com.devmo.advisorysyncapiplatform.model.Communication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/communications")
public class CommunicationController
{
    private final CommunicationService communicationService;

    @Autowired
    public CommunicationController(CommunicationService communicationService) {
        this.communicationService = communicationService;
    }

    @GetMapping
    public List<Communication> getAllCommunications() {
        return communicationService.getAllCommunications();
    }

    @GetMapping("/{logId}")
    public Optional<Communication> getCommunicationById(@PathVariable Long logId) {
        return communicationService.getCommunicationById(logId);
    }

    @PostMapping
    public Communication newCommunication(@RequestBody Communication newCommunication) {
        return communicationService.createCommunication(newCommunication);
    }
}
