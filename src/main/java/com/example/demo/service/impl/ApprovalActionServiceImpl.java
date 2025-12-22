package com.example.demo.service.impl;

import com.example.demo.entity.ApprovalAction;
import com.example.demo.entity.ApprovalRequest;
import com.example.demo.repository.ApprovalActionRepository;
import com.example.demo.repository.ApprovalRequestRepository;
import com.example.demo.service.ApprovalActionService;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class ApprovalActionServiceImpl implements ApprovalActionService {

    private final ApprovalActionRepository approvalActionRepository;
    private final ApprovalRequestRepository approvalRequestRepository;

    public ApprovalActionServiceImpl(ApprovalActionRepository approvalActionRepository,
                                     ApprovalRequestRepository approvalRequestRepository) {
        this.approvalActionRepository = approvalActionRepository;
        this.approvalRequestRepository = approvalRequestRepository;
    }

    public ApprovalAction recordAction(ApprovalAction action) {
        action.setActionDate(LocalDateTime.now());
        ApprovalAction saved = approvalActionRepository.save(action);

        ApprovalRequest request = approvalRequestRepository.findById(action.getRequestId()).orElseThrow();
        if ("APPROVED".equals(action.getAction())) {
            request.setCurrentLevel(request.getCurrentLevel() + 1);
        } else {
            request.setStatus("REJECTED");
        }
        approvalRequestRepository.save(request);

        return saved;
    }
}
