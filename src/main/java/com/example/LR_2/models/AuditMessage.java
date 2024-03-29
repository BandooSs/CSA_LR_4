package com.example.LR_2.models;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public abstract class AuditMessage {

    private AuditEvent event;

    private String table;

    private LocalDateTime datetime;

    public abstract String getInfo();

}
