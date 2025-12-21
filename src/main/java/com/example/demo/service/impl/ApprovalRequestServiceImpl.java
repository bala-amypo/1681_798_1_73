package com.example.demo.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.entity.ApprovalRequest;
import com.example.demo.repository.ApprovalActionRepository;
import com.example.demo.repository.ApprovalRequestRepository;
import com.example.demo.repository.WorkflowStepConfigRepository;
import com.example.demo.repository.WorkflowTemplateRepository;
import com.example.demo.service.ApprovalRequestService;

@Service
public class ApprovalRequestServiceImpl implements ApprovalRequestService {

    private final ApprovalRequestRepository requestRepo;
    private final WorkflowStepConfigRepository stepRepo;
    private final WorkflowTemplateRepository templateRepo;
    private final ApprovalActionRepository actionRepo;

    public ApprovalRequestServiceImpl(
            ApprovalRequestRepository requestRepo,
            WorkflowStepConfigRepository stepRepo,
            WorkflowTemplateRepository templateRepo,
            ApprovalActionRepository actionRepo) {

        this.requestRepo = requestRepo;
        this.stepRepo = stepRepo;
        this.templateRepo = templateRepo;
        this.actionRepo = actionRepo;
    }

    @Override
    public ApprovalRequest createRequest(ApprovalRequest req) {
        req.setStatus("PENDING");
        req.setCurrentLevel(1);
        return requestRepo.save(req);
    }

    @Override
    public List<ApprovalRequest> getRequestsByRequester(Long userId) {
        return requestRepo.findByRequesterId(userId);
    }

    @Override
    public List<ApprovalRequest> getAllRequests() {
        return requestRepo.findAll();
    }
}
