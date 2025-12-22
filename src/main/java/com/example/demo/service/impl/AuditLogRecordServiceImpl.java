package com.example.demo.service.impl;

import com.example.demo.entity.AuditLogRecord;
import com.example.demo.repository.AuditLogRecordRepository;
import com.example.demo.service.AuditLogService;
import org.springframework.stereotype.Service;

@Service
public class AuditLogRecordServiceImpl implements AuditLogRecordService {

    private final AuditLogRecordRepository auditLogRecordRepository;

    public AuditLogServiceImpl(AuditLogRecordRepository auditLogRecordRepository) {
        this.auditLogRecordRepository = auditLogRecordRepository;
    }

    public AuditLogRecord save(AuditLogRecord record) {
        return auditLogRecordRepository.save(record);
    }
}
