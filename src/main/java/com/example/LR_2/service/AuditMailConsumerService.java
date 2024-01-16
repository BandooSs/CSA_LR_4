package com.example.LR_2.service;


import com.example.LR_2.models.AuditMessage;
import com.example.LR_2.repository.MailingRulesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuditMailConsumerService {
    private final MailingRulesRepository mailingRulesRepository;

    private final MailingService mailingService;

    @JmsListener(destination = "${application.topic.audit}")
    public void receive(AuditMessage auditMessage) {
        List<String> emails = mailingRulesRepository.findEmailByTableName(auditMessage.getTable());
        emails.forEach(email -> mailingService.sendSimpleEmail(email, auditMessage));
    }
}
