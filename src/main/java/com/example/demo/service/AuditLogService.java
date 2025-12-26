package com.example.demo.service;

import com.example.demo.model.AuditLogRecord;
import java.util.List;

public interface AuditLogService {
    List<AuditLogRecord> getByRequest(Long requestId);
}
