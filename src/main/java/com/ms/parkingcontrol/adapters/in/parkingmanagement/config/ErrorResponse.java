package com.ms.parkingcontrol.adapters.in.parkingmanagement.config;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class ErrorResponse {
    private final String message;
    private final int code;
    private final String status;
    @JsonProperty("object_name")
    private String objectName;
    private List<ErrorObject> errors;

    public ErrorResponse(String message, int code, String status, String objectName, List<ErrorObject> errors) {
        this.message = message;
        this.code = code;
        this.status = status;
        this.objectName = objectName;
        this.errors = errors;
    }

    public ErrorResponse(String message, int code, String status) {
        this.message = message;
        this.code = code;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }

    public String getStatus() {
        return status;
    }

    public String getObjectName() {
        return objectName;
    }

    public List<ErrorObject> getErrors() {
        return errors;
    }
}
