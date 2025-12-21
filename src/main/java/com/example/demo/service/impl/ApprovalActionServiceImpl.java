package com.example.demo.service.impl;

import org.springframework.stereotype.Service;
import com.example.demo.entity.ApprovalAction;
import com.example.demo.entity.ApprovalRequest;
import com.example.demo.repository.ApprovalActionRepository;
import com.example.demo.repository.ApprovalRequestRepository;
import com.example.demo.service.ApprovalActionService;

@Service
public class ApprovalActionServiceImpl implements ApprovalActionService {

    private final ApprovalActionRepository actionRepo;
    private final ApprovalRequestRepository requestRepo;

    public ApprovalActionServiceImpl(
            ApprovalActionRepository actionRepo,
            ApprovalRequestRepository requestRepo) {
        this.actionRepo = actionRepo;
        this.requestRepo = requestRepo;
    }

    @Override
    public ApprovalAction recordAction(ApprovalAction action) {
        ApprovalRequest req = action.getApprovalRequest();
        req.setCurrentLevel(req.getCurrentLevel() + 1);
        requestRepo.save(req);
        return actionRepo.save(action);
    }
}
