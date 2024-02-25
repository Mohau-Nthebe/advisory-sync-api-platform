package com.devmo.advisorysyncapiplatform.Service;

import com.devmo.advisorysyncapiplatform.model.ContactPerson;
import com.devmo.advisorysyncapiplatform.repository.ContactPersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class ContactPersonService {

    @Autowired
    private ContactPersonRepository contactPersonRepository;

    public ContactPerson createContactPerson(ContactPerson contactPerson) {
        return contactPersonRepository.save(contactPerson);
    }

    public List<ContactPerson> getAllContactPersons() {
        return contactPersonRepository.findAll();
    }

    public Optional<ContactPerson> getContactPersonById(Long contactId) {
        return contactPersonRepository.findById(contactId);
    }

    public Optional<ContactPerson> updateContactPerson(Long contactId, ContactPerson updatedContactPerson) {
        return contactPersonRepository.findById(contactId)
                .map(existingContactPerson -> {
                    existingContactPerson.setFullName(updatedContactPerson.getFullName());
                    existingContactPerson.setEmail(updatedContactPerson.getEmail());
                    existingContactPerson.setPhone(updatedContactPerson.getPhone());
                    existingContactPerson.setPosition(updatedContactPerson.getPosition());
                    existingContactPerson.setClient(updatedContactPerson.getClient());
                    existingContactPerson.setCreatedAt(updatedContactPerson.getCreatedAt());
                    return contactPersonRepository.save(existingContactPerson);
                });
    }

    public Optional<ContactPerson> patchContactPerson(Long contactId, Map<String, Object> updates) {
        return contactPersonRepository.findById(contactId)
                .map(existingContactPerson -> {
                    if (updates.containsKey("fullName")) {
                        existingContactPerson.setFullName((String) updates.get("fullName"));
                    }
                    if (updates.containsKey("email")) {
                        existingContactPerson.setEmail((String) updates.get("email"));
                    }
                    return contactPersonRepository.save(existingContactPerson);
                });
    }
}
