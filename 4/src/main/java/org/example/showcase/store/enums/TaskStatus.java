package org.example.showcase.store.enums;


import com.fasterxml.jackson.annotation.JsonValue;

public enum TaskStatus {
    PENDING("Pending"),
    IN_PROGRESS("In Progress"),
    COMPLETED("Completed");

    private final String status;

    TaskStatus(String status) {
        this.status = status;
    }

    @JsonValue
    public String getStatus() {
        return status;
    }
    public static TaskStatus fromString(String status) throws IllegalArgumentException {
        for (TaskStatus value : values()) {
            if (value.getStatus().equalsIgnoreCase(status)) {
                return value;
            }
        }
        throw new IllegalArgumentException("The status you specified does not exist.\nStatus: " + status);
    }
}

