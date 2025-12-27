package com.example.demo.service;

import com.example.demo.model.AuditLog;
import java.util.List;

public interface AuditLogService {

    List<AuditLog> getByRequest(Long requestId);
}
