package org.example.showcase.api.service.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.showcase.api.dto.TaskDto;
import org.example.showcase.api.exception.TaskNotFoundException;
import org.example.showcase.api.factoryDTO.TaskDtoFactory;
import org.example.showcase.api.request.requests.UpdateTaskRequest;
import org.example.showcase.api.request.requestmapper.UpdateTaskRequestMapper;
import org.example.showcase.api.service.TaskService;
import org.example.showcase.store.entity.TaskEntity;
import org.example.showcase.store.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
@Service
public class TaskServiceImpl implements TaskService {
     TaskRepository repository;
     UpdateTaskRequestMapper updateTaskRequestMapper;
    TaskDtoFactory taskDtoFactory;

    @Override
    public TaskDto findTask(Long id) {
        return taskDtoFactory.makeTaskDto(findTaskWithId(id));
    }

    @Override
    public TaskDto updateTask(Long id, UpdateTaskRequest request) {
        TaskEntity taskEntity = findTaskWithId(id);
        updateTaskRequestMapper.toEntity(taskEntity,request);
        repository.save(taskEntity);
        return taskDtoFactory.makeTaskDto(taskEntity);
    }

    @Override
    public void deleteTask(Long id) {
        TaskEntity taskEntity = findTaskWithId(id);
        repository.delete(taskEntity);
    }

    private TaskEntity findTaskWithId(Long id){
        Optional<TaskEntity> taskEntity = repository.findById(id);
        if (taskEntity.isEmpty()) {
            throw new TaskNotFoundException("Task not found with id: " + id);
        }
        return taskEntity.get();
    }
}
