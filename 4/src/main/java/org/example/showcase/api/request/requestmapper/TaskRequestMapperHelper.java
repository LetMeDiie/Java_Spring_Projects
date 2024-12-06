package org.example.showcase.api.request.requestmapper;
import org.example.showcase.api.exception.InvalidTaskRequestException;
import org.example.showcase.store.entity.TaskEntity;
import org.example.showcase.store.enums.TaskStatus;

public class TaskRequestMapperHelper {

    public static void mapDetails(TaskEntity taskEntity, String details) {
        if (details == null || details.isBlank()) {
            throw new InvalidTaskRequestException("Task details cannot be null or blank");
        }
        taskEntity.setDetails(details);
    }

    public static void mapTaskStatus(TaskEntity taskEntity, String taskStatus) {
        if (taskStatus == null || taskStatus.isBlank()) {
            taskEntity.setTaskStatus(TaskStatus.PENDING);
        } else {
            try {
                taskEntity.setTaskStatus(TaskStatus.fromString(taskStatus));
            } catch (IllegalArgumentException exception) {
                throw new InvalidTaskRequestException("Invalid task status: " + taskStatus, exception);
            }
        }
    }
}
