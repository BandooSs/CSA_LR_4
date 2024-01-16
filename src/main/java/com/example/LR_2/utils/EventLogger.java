package com.example.LR_2.utils;


import com.example.LR_2.models.AuditEvent;

public interface EventLogger {

    void log(Object entity, AuditEvent event);

}
