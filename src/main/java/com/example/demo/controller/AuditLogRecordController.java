package com.example.demo.controller;

import com.example.demo.model.AuditLogRecord;
import com.example.demo.service.AuditLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/audit")
public class AuditLogRecordController {

    @Autowired
    private AuditLogRecordService auditLogService;

    @PostMapping
    public AuditLogRecord save(@RequestBody AuditLogRecord record) {
        return auditLogService.save(record);
    }

    @GetMapping("/request/{requestId}")
    public List<AuditLogRecord> getByRequest(@PathVariable Long requestId) {
        return auditLogService.findByRequestId(requestId);
    }
}
