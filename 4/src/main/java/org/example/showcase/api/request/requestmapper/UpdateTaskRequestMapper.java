package org.example.showcase.api.request.requestmapper;

import org.example.showcase.api.request.requests.UpdateTaskRequest;
import org.example.showcase.store.entity.TaskEntity;
import org.springframework.stereotype.Component;

@Component
public class UpdateTaskRequestMapper {
    public TaskEntity toEntity(TaskEntity taskEntity,UpdateTaskRequest request) {
        TaskRequestMapperHelper.mapDetails(taskEntity,request.details());
        TaskRequestMapperHelper.mapTaskStatus(taskEntity, request.taskStatus());
        return taskEntity;
    }
}
