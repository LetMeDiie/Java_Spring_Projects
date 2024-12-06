package org.example.showcase.api.controllers;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.showcase.api.dto.TaskDto;
import org.example.showcase.api.request.requests.CreateNewTaskRequest;
import org.example.showcase.api.service.TaskManagementService;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api/tasks")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class TasksRestController {
    TaskManagementService taskService;

    @GetMapping()
    public ResponseEntity<List<TaskDto>> fetchAllTasks() {
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(taskService.findAllTasks());
    }

    @PostMapping
    public ResponseEntity<TaskDto> createNewTask(
            @RequestBody CreateNewTaskRequest request,
            UriComponentsBuilder builder) {
        TaskDto taskDto = taskService.createNewTask(request);
        return ResponseEntity.created(
                        builder.path("api/tasks/{taskId}")
                                .build(Map.of("taskId", taskDto.id())))
                .contentType(MediaType.APPLICATION_JSON)
                .body(taskDto);
    }

    @GetMapping("/{status:[a-zA-Z\\s]+}")
    public ResponseEntity<List<TaskDto>> findTaskByTaskStatus(@PathVariable("status") String taskStatus){
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(taskService.findTasksByStatus(taskStatus));
    }
}