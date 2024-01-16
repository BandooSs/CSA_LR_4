package com.example.LR_2.models;

import lombok.Data;

@Data
public class CreateMessage extends AuditMessage {

    private Object createdObject;

    @Override
    public String getInfo() {
        return "объект создан %s".formatted(createdObject);
    }

}
