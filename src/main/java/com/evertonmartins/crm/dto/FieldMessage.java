package com.evertonmartins.crm.dto;

public class FieldMessage {

    private String fieldName;
    private String message;

    public FieldMessage(String fieldName, String message) {
        this.fieldName = fieldName;
        this.message = message;
    }

    public String getFieldname() {
        return fieldName;
    }

    public String getMessage() {
        return message;
    }
}
