package com.example.demo.service.impl;

import com.example.demo.model.ApprovalAction;
import com.example.demo.model.ApprovalRequest;
import com.example.demo.model.AuditLogRecord;
import com.example.demo.repository.ApprovalActionRepository;
import com.example.demo.repository.ApprovalRequestRepository;
import com.example.demo.repository.AuditLogRecordRepository;
import com.example.demo.service.ApprovalActionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class ApprovalActionServiceImpl implements ApprovalActionService {

    private final ApprovalActionRepository actionRepository;
    private final ApprovalRequestRepository requestRepository;
    private final AuditLogRecordRepository auditRepository;

    public ApprovalActionServiceImpl(ApprovalActionRepository actionRepository,
                                     ApprovalRequestRepository requestRepository,
                                     AuditLogRecordRepository auditRepository) {
        this.actionRepository = actionRepository;
        this.requestRepository = requestRepository;
        this.auditRepository = auditRepository;
    }

    @Override
    public ApprovalAction recordAction(ApprovalAction action) {
        ApprovalAction saved = actionRepository.save(action);

        ApprovalRequest request = requestRepository.findById(action.getRequestId()).orElseThrow();
        request.setCurrentLevel(action.getLevelNumber() + 1);
        if ("REJECTED".equals(action.getAction())) {
            request.setStatus("REJECTED");
        } else if ("APPROVED".equals(action.getAction())) {
            request.setStatus("IN_PROGRESS");
        }
        requestRepository.save(request);

        AuditLogRecord log = new AuditLogRecord();
        log.setRequestId(request.getId());
        log.setEventType("ACTION_RECORDED");
        log.setDetails("Action: " + action.getAction());
        auditRepository.save(log);

        return saved;
    }
}
