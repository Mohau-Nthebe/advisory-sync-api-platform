package com.devmo.advisorysyncapiplatform.Service;

import com.devmo.advisorysyncapiplatform.model.Client;
import com.devmo.advisorysyncapiplatform.model.Communication;
import com.devmo.advisorysyncapiplatform.model.ContactPerson;
import com.devmo.advisorysyncapiplatform.model.Project;
import com.devmo.advisorysyncapiplatform.repository.ClientRepository;
import com.devmo.advisorysyncapiplatform.repository.CommunicationRepository;
import com.devmo.advisorysyncapiplatform.repository.ContactPersonRepository;
import com.devmo.advisorysyncapiplatform.repository.ProjectRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommunicationService {

    private final CommunicationRepository communicationRepository;

    @Autowired
    public CommunicationService(CommunicationRepository communicationRepository) {
        this.communicationRepository = communicationRepository;
    }

    public List<Communication> getAllCommunications() {
        return communicationRepository.findAll();
    }

    public Optional<Communication> getCommunicationById(Long logId) {
        return communicationRepository.findById(logId);
    }

    public Communication createCommunication(Communication newCommunication) {

        return communicationRepository.save(newCommunication);
    }


}
