package com.assignment.springboot_assignments.entity;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum StudentStatus {

    ACTIVE,
    INACTIVE;

    @JsonValue
    public String toJson() {
        return name().toLowerCase();
    }

    @JsonCreator
    public static StudentStatus fromJson(String value) {
        for (StudentStatus status : StudentStatus.values()) {
            if (status.name().equalsIgnoreCase(value)) {
                return status;
            }
        }

        throw new IllegalArgumentException(
                "Invalid student status: " + value
        );
    }
}