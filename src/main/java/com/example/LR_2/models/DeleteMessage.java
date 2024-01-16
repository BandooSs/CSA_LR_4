package com.example.LR_2.models;

import lombok.Data;

@Data
public class DeleteMessage extends AuditMessage {

    private Object deletedObject;


    @Override
    public String getInfo() {
        return "объект был удален %s".formatted(deletedObject);
    }

}
