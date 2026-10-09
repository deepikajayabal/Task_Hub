package com.campus.Task_Hub.service;

import com.campus.Task_Hub.entity.Task;
import com.campus.Task_Hub.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    public Task updateTask(Long id, Task task) {

        Optional<Task> existingTask = taskRepository.findById(id);

        if (existingTask.isPresent()) {

            Task updatedTask = existingTask.get();

            updatedTask.setTitle(task.getTitle());
            updatedTask.setDescription(task.getDescription());
            updatedTask.setStatus(task.getStatus());
            updatedTask.setPriority(task.getPriority());

            return taskRepository.save(updatedTask);
        }

        return null;
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}