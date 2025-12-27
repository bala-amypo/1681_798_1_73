package com.example.demo.service;

import com.example.demo.model.AuditLogReord;
import java.util.List;

public interface AuditLogService {

    List<AuditLog> getByRequest(Long requestId);
}
