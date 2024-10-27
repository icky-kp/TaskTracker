package com.kaustav.TaskTracker;

import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kaustav.TaskTracker.service.TaskService;

@SpringBootApplication
public class TasktrackerApplication implements CommandLineRunner{
	@Autowired
	private TaskService taskService;

	public static void main(String[] args) {
		SpringApplication.run(TasktrackerApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception{
		Scanner sc = new Scanner(System.in);
		while(true) {
			System.out.println("Enter Command: ");
			String command = sc.nextLine();
			String[] commandParts = command.split(" ");
			switch(commandParts[0]) {
			case "add":
				Task newTask = new Task();
				newTask.setDescription(commandParts[1]);
				newTask.setStatus("todo");
				taskService.addTask(newTask);
				System.out.println("Task added successfully.");
				break;
			case "list":
                taskService.getAllTasks().forEach(task -> System.out.println(task.getDescription()));
				break;
			case "update":
				long taskId = Long.parseLong(commandParts[1]);
				Task taskToUpdate = taskService.getTaskById(taskId);
				if (taskToUpdate != null) {
                    taskToUpdate.setDescription(commandParts[2]);
                    taskToUpdate.setStatus(commandParts[3]);
                    taskService.updateTask(taskToUpdate);
                    System.out.println("Task updated successfully.");
                } else {
                    System.out.println("Task not found.");
                }
                break;

			case "delete":
				Long taskIdToDelete = Long.parseLong(commandParts[1]);
                taskService.deleteTask(taskIdToDelete);
                System.out.println("Task deleted successfully.");
                break;
			case "exit":
                System.out.println("Exiting application...");
                System.exit(0);
                break;
			default:
				System.out.println("Unknown command.");
			}
		}
	}
}
