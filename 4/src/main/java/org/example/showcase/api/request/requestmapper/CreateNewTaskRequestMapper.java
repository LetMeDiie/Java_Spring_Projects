package org.example.showcase.api.request.requestmapper;

import org.example.showcase.api.request.requests.CreateNewTaskRequest;
import org.example.showcase.store.entity.TaskEntity;
import org.springframework.stereotype.Component;

@Component
public class CreateNewTaskRequestMapper {

    public TaskEntity toEntity(CreateNewTaskRequest request) {
        TaskEntity taskEntity = new TaskEntity();
        TaskRequestMapperHelper.mapDetails(taskEntity,request.details());
        TaskRequestMapperHelper.mapTaskStatus(taskEntity, request.taskStatus());
        return taskEntity;
    }
}
