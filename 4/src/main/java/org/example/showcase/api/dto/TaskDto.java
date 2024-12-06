package org.example.showcase.api.dto;

import org.example.showcase.store.enums.TaskStatus;

public record TaskDto(
        Long id,
        String details,
        TaskStatus taskStatus
) {
}
