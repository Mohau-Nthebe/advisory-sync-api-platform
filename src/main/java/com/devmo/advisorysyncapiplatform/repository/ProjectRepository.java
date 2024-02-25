package com.devmo.advisorysyncapiplatform.repository;

import com.devmo.advisorysyncapiplatform.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project,Long>
{
}
