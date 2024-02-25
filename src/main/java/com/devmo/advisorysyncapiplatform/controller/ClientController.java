package com.devmo.advisorysyncapiplatform.controller;

import com.devmo.advisorysyncapiplatform.Service.ClientService;
import com.devmo.advisorysyncapiplatform.model.Client;
import com.devmo.advisorysyncapiplatform.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/api/clients")
public class ClientController
{

    @Autowired
    private ClientService clientService;

    @PostMapping
    public Client newClient(@RequestBody Client newClient) {
        return clientService.createClient(newClient);
    }

    @GetMapping
    public List<Client> getAllClients() {
        return clientService.getAllClients();
    }

    @GetMapping("/{clientId}")
    public ResponseEntity<Client> getClientById(@PathVariable Long clientId) {
        Optional<Client> clientOptional = clientService.getClientById(clientId);
        return clientOptional.map(client -> new ResponseEntity<>(client, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/{clientId}")
    public ResponseEntity<Client> updateClient(@PathVariable Long clientId, @RequestBody Client updatedClient) {
        Client client = clientService.updateClient(clientId, updatedClient);
        return (client != null) ? new ResponseEntity<>(client, HttpStatus.OK)
                : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PatchMapping("/{clientId}")
    public Client patchClient(@PathVariable Long clientId, @RequestBody Map<String, Object> updates) {
        return clientService.patchClient(clientId, updates);
    }
}
