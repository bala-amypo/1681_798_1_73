package com.example.demo.service.impl;

import com.example.demo.entity.AuditLogRecord;
import com.example.demo.repository.AuditLogRecordRepository;
import com.example.demo.service.AuditLogRecordService;
import org.springframework.stereotype.Service;

@Service
public class AuditLogRecordServiceImpl implements AuditLogRecordService {

    private final AuditLogRecordRepository auditLogRecordRepository;

    public AuditLogRecordServiceImpl(AuditLogRecordRepository auditLogRecordRepository) {
        this.auditLogRecordRepository = auditLogRecordRepository;
    }

    public AuditLogRecord save(AuditLogRecord record) {
        return auditLogRecordRepository.save(record);
    }
}
