package com.devmo.advisorysyncapiplatform.Service;

import com.devmo.advisorysyncapiplatform.model.Task;
import com.devmo.advisorysyncapiplatform.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(Long taskId) {
        return taskRepository.findById(taskId);
    }

    public Optional<Task> updateTask(Long taskId, Task updatedTask) {
        Optional<Task> existingTaskOptional = taskRepository.findById(taskId);
        if (existingTaskOptional.isPresent()) {
            Task existingTask = existingTaskOptional.get();
            existingTask.setTitle(updatedTask.getTitle());
            existingTask.setDescription(updatedTask.getDescription());
            existingTask.setDueDate(updatedTask.getDueDate());
            existingTask.setStatus(updatedTask.getStatus());
            existingTask.setAssignedTo(updatedTask.getAssignedTo());
            return Optional.of(taskRepository.save(existingTask));
        } else {
            return Optional.empty();
        }
    }


}
