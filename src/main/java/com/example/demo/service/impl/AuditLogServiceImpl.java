package com.example.demo.service.impl;

import com.example.demo.model.AuditLogRecord;
import com.example.demo.repository.AuditLogRecordRepository;
import com.example.demo.service.AuditLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuditLogServiceImpl implements AuditLogService {
    
    @Autowired
    private AuditLogRecordRepository auditRepository;
    
    @Override
    public AuditLogRecord createLog(AuditLogRecord log) {
        return auditRepository.save(log);
    }
}