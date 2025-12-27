package com.example.demo.service.impl;

import com.example.demo.model.AuditLogRecord;
import com.example.demo.repository.AuditLogReordRepository;
import com.example.demo.service.AuditLogService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuditLogServiceImpl implements AuditLogService {

    private final AuditLogReordRepository repository;

    public AuditLogServiceImpl(AuditLogRecordRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<AuditLog> getByRequest(Long requestId) {
        return repository.findByRequestId(requestId);
    }
}
