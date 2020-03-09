package com.d365lab.eatery.restaurantcustomerorchestrator.model;

import java.io.Serializable;

public class UpdateFieldValuePair implements Serializable {
    private String fieldName;
    private String newValue;

    public UpdateFieldValuePair() {
    }

    public UpdateFieldValuePair(String fieldName, String newValue) {
        this.fieldName = fieldName;
        this.newValue = newValue;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getNewValue() {
        return newValue;
    }

    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }
}
