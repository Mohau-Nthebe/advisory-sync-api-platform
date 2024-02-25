package com.devmo.advisorysyncapiplatform.repository;

import com.devmo.advisorysyncapiplatform.model.Client;
import com.devmo.advisorysyncapiplatform.model.Project;
import jakarta.persistence.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface ClientRepository extends JpaRepository<Client,Long>
{
}
