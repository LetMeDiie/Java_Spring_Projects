package org.example.showcase.api.service;

import org.example.showcase.api.dto.TaskDto;
import org.example.showcase.api.request.requests.UpdateTaskRequest;

public interface TaskService {
    TaskDto findTask(Long id);
    TaskDto updateTask(Long id, UpdateTaskRequest request);
    void deleteTask(Long id);

}
