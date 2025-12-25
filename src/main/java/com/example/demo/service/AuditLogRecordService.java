package com.example.demo.service;

import com.example.demo.model.AuditLogRecord;

import java.util.List;

public interface AuditLogRecordService {

    AuditLogRecord save(AuditLogRecord record);

    List<AuditLogRecord> findByRequestId(Long requestId);
}
