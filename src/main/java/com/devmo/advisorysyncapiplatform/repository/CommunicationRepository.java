package com.devmo.advisorysyncapiplatform.repository;

import com.devmo.advisorysyncapiplatform.model.Communication;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommunicationRepository extends JpaRepository<Communication,Long>
{
}
