package com.devmo.advisorysyncapiplatform.repository;

import com.devmo.advisorysyncapiplatform.model.ContactPerson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactPersonRepository extends JpaRepository<ContactPerson,Long>
{
}
