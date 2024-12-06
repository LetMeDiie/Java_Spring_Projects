package org.example.showcase.api.service;

import org.example.showcase.api.dto.TaskDto;
import org.example.showcase.api.request.requests.CreateNewTaskRequest;

import java.util.List;

public interface TaskManagementService {
     List<TaskDto> findAllTasks();
     TaskDto createNewTask(CreateNewTaskRequest request);
     List<TaskDto> findTasksByStatus(String status);


}
