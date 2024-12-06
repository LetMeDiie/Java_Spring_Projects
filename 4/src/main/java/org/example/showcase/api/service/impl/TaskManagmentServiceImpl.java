package org.example.showcase.api.service.impl;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.showcase.api.dto.TaskDto;
import org.example.showcase.api.factoryDTO.TaskDtoFactory;
import org.example.showcase.api.request.requests.CreateNewTaskRequest;
import org.example.showcase.api.request.requestmapper.CreateNewTaskRequestMapper;
import org.example.showcase.api.service.TaskManagementService;
import org.example.showcase.store.entity.TaskEntity;
import org.example.showcase.store.enums.TaskStatus;
import org.example.showcase.store.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
@RequiredArgsConstructor
public class TaskManagmentServiceImpl implements TaskManagementService {
    TaskRepository repository;

    TaskDtoFactory taskDtoFactory;

    CreateNewTaskRequestMapper taskRequestMapper;

    @Override
    public List<TaskDto> findAllTasks() {
        return repository.findAll()
                .stream()
                .map(taskDtoFactory::makeTaskDto)
                .collect(Collectors.toList());
    }

    @Override
    public TaskDto createNewTask(CreateNewTaskRequest request) {
        TaskEntity taskEntity = taskRequestMapper.toEntity(request);
        TaskEntity savedTaskEntity = repository.save(taskEntity);
        return taskDtoFactory.makeTaskDto(savedTaskEntity);
    }



    @Override
    public List<TaskDto> findTasksByStatus(String status) {
        TaskStatus taskStatus = TaskStatus.fromString(status);
        return repository.findByTaskStatus(taskStatus)
                .stream()
                .map(taskDtoFactory::makeTaskDto)
                .collect(Collectors.toList());
    }
}