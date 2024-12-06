package org.example.showcase.api.request.requests;

public record UpdateTaskRequest(
        String details,
        String taskStatus
) {
}
