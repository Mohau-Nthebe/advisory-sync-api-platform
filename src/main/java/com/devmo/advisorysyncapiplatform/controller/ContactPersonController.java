package com.devmo.advisorysyncapiplatform.controller;

import com.devmo.advisorysyncapiplatform.Service.ContactPersonService;
import com.devmo.advisorysyncapiplatform.model.ContactPerson;
import com.devmo.advisorysyncapiplatform.repository.ContactPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/contacts")
public class ContactPersonController {

    @Autowired
    private ContactPersonService contactPersonService;

    @PostMapping
    public ContactPerson createContactPerson(@RequestBody ContactPerson contactPerson) {
        return contactPersonService.createContactPerson(contactPerson);
    }

    @GetMapping
    public List<ContactPerson> getAllContactPersons() {
        return contactPersonService.getAllContactPersons();
    }

    @GetMapping("/{contactId}")
    public ResponseEntity<ContactPerson> getContactPersonById(@PathVariable Long contactId) {
        return ResponseEntity.of(contactPersonService.getContactPersonById(contactId));
    }

    @PutMapping("/{contactId}")
    public ResponseEntity<ContactPerson> updateContactPerson(@PathVariable Long contactId, @RequestBody ContactPerson updatedContactPerson) {
        return ResponseEntity.of(contactPersonService.updateContactPerson(contactId, updatedContactPerson));
    }

    @PatchMapping("/{contactId}")
    public ResponseEntity<ContactPerson> patchContactPerson(@PathVariable Long contactId, @RequestBody Map<String, Object> updates) {
        return ResponseEntity.of(contactPersonService.patchContactPerson(contactId, updates));
    }
}
