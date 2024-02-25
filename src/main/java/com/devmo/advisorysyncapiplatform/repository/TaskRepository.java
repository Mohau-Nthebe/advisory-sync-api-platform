package com.devmo.advisorysyncapiplatform.repository;

import com.devmo.advisorysyncapiplatform.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task,Long>
{
}
