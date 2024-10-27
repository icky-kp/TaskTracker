package com.kaustav.TaskTracker.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kaustav.TaskTracker.Task;
@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
	
}

