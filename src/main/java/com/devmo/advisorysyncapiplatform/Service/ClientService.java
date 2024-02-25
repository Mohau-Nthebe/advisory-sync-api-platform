package com.devmo.advisorysyncapiplatform.Service;


import com.devmo.advisorysyncapiplatform.model.Client;
import com.devmo.advisorysyncapiplatform.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ClientService
{
    private final ClientRepository clientRepository;

    @Autowired
    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public List<Client> getAllClients() {
        return clientRepository.findAll();
    }

    public Client createClient(Client newClient) {
        return clientRepository.save(newClient);
    }

    public Optional<Client> getClientById(Long clientId) {
        return clientRepository.findById(clientId);
    }

    public Client updateClient(Long clientId, Client updatedClient) {
        Optional<Client> existingClientOptional = clientRepository.findById(clientId);
        if (existingClientOptional.isPresent()) {
            Client existingClient = existingClientOptional.get();
            existingClient.setName(updatedClient.getName());
            existingClient.setEmail(updatedClient.getEmail());
            existingClient.setPhone(updatedClient.getPhone());
            existingClient.setCompany(updatedClient.getCompany());
            existingClient.setIndustry(updatedClient.getIndustry());
            existingClient.setAddress(updatedClient.getAddress());
            return clientRepository.save(existingClient);
        } else {
            // TODO: BUILD CUSTOM ERROR HANDLER
            return null;
        }
    }

    public Client patchClient(Long clientId, Map<String, Object> updates) {
        Optional<Client> existingClientOptional = clientRepository.findById(clientId);
        if (existingClientOptional.isPresent()) {
            Client existingClient = existingClientOptional.get();

            updates.forEach((key, value) -> {
                switch (key) {
                    case "name":
                        existingClient.setName((String) value);
                        break;
                    case "email":
                        existingClient.setEmail((String) value);
                        break;
                    case "phone":
                        existingClient.setPhone((String) value);
                        break;
                    case "company":
                        existingClient.setCompany((String) value);
                        break;
                    case "industry":
                        existingClient.setIndustry((String) value);
                        break;
                    case "address":
                        existingClient.setAddress((String) value);
                        break;

                }
            });


            return clientRepository.save(existingClient);
        } else {

            return null;
        }
    }
}
