package org.example.showcase.api.factoryDTO;

import org.example.showcase.api.dto.TaskDto;
import org.example.showcase.store.entity.TaskEntity;
import org.springframework.stereotype.Component;

@Component
public class TaskDtoFactory {
    public TaskDto makeTaskDto(TaskEntity taskEntity){
        return new TaskDto(taskEntity.getId(),taskEntity.getDetails(),taskEntity.getTaskStatus());
    }
}
