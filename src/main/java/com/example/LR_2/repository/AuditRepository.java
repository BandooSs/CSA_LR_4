package com.example.LR_2.repository;


import com.example.LR_2.models.AuditEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuditRepository extends JpaRepository<AuditEntity, UUID> {
}