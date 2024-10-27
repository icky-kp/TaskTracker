package com.kaustav.TaskTracker.service;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kaustav.TaskTracker.Task;
import com.kaustav.TaskTracker.repo.TaskRepository;

@Service
public class TaskService {
	@Autowired
	private TaskRepository taskRepository;
	
	public Task addTask(Task task) {
		task.setCreatedAt(LocalDateTime.now());
		task.setUpdatedAt(LocalDateTime.now());
		return taskRepository.save(task);
	}
	
	public List<Task> getAllTasks(){
		return taskRepository.findAll();
	}
	public Task updateTask(Task task) {
		task.setUpdatedAt(LocalDateTime.now());
		return taskRepository.save(task);
	}
	public void deleteTask(long id) {
		taskRepository.deleteById(id);
	}
	public Task getTaskById(Long id) {
        return taskRepository.findById(id).orElse(null);
    }
}
