package com.example.demo.controller;

import com.example.demo.model.AuditLogRecord;
import com.example.demo.service.AuditLogService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/audit")
public class AuditLogController {

    private final AuditLogService service;

    public AuditLogController(AuditLogService service) {
        this.service = service;
    }

    @GetMapping("/{requestId}")
    public List<AuditLogRecord> getByRequest(@PathVariable Long requestId) {
        return service.getByRequest(requestId);
    }
}
