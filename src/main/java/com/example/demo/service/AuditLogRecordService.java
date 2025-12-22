package com.example.demo.service;

import com.example.demo.entity.AuditLogRecord;

public interface AuditLogService {

    AuditLogRecord save(AuditLogRecord record);
}
