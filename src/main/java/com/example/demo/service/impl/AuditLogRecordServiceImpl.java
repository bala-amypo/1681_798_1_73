package com.example.demo.service.impl;

import com.example.demo.model.AuditLogRecord;
import com.example.demo.repository.AuditLogRecordRepository;
import com.example.demo.service.AuditLogRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditLogRecordServiceImpl implements AuditLogRecordService {

    @Autowired
    private AuditLogRecordRepository auditLogRecordRepository;

    public AuditLogRecord save(AuditLogRecord record) {
        return auditLogRecordRepository.save(record);
    }

    public List<AuditLogRecord> findByRequestId(Long requestId) {
        return auditLogRecordRepository.findByRequestId(requestId);
    }
}
