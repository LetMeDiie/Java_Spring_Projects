package org.example.showcase.api.controllers;

import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.example.showcase.api.dto.TaskDto;
import org.example.showcase.api.request.requests.UpdateTaskRequest;
import org.example.showcase.api.service.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/tasks/{taskId:\\d+}")
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE,makeFinal = true)
public class TaskRestController {

    TaskService taskService;
    @GetMapping
    public ResponseEntity<TaskDto> getTask(@PathVariable("taskId") Long id){
        TaskDto taskDto = taskService.findTask(id);
        return ResponseEntity.ok(taskDto);
    }

    @PutMapping()
    public ResponseEntity<TaskDto> updateTask(@PathVariable("taskId") Long id,
                                              @RequestBody UpdateTaskRequest request){
        TaskDto taskDto = taskService.updateTask(id,request);
        return ResponseEntity.ok(taskDto);
    }

    @DeleteMapping()
    public ResponseEntity<Void> deleteTask(@PathVariable("taskId") Long id){
        taskService.deleteTask(id);
        return ResponseEntity.noContent().build();
    }


}