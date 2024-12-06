package org.example.showcase.api.request.requests;


public record CreateNewTaskRequest(
        String details,
        String taskStatus
) {
}
