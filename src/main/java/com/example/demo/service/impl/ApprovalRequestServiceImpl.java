package com.example.demo.service.impl;

import com.example.demo.entity.ApprovalRequest;
import com.example.demo.repository.ApprovalRequestRepository;
import com.example.demo.repository.WorkflowStepConfigRepository;
import com.example.demo.repository.WorkflowTemplateRepository;
import com.example.demo.repository.ApprovalActionRepository;
import com.example.demo.service.ApprovalRequestService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.lang.Long;
import java.time.LocalDateTime;

@Service
public class ApprovalRequestServiceImpl implements ApprovalRequestService {

    private final ApprovalRequestRepository approvalRequestRepository;
    private final WorkflowStepConfigRepository workflowStepConfigRepository;
    private final WorkflowTemplateRepository workflowTemplateRepository;
    private final ApprovalActionRepository approvalActionRepository;

    public ApprovalRequestServiceImpl(ApprovalRequestRepository approvalRequestRepository,
                                      WorkflowStepConfigRepository workflowStepConfigRepository,
                                      WorkflowTemplateRepository workflowTemplateRepository,
                                      ApprovalActionRepository approvalActionRepository) {
        this.approvalRequestRepository = approvalRequestRepository;
        this.workflowStepConfigRepository = workflowStepConfigRepository;
        this.workflowTemplateRepository = workflowTemplateRepository;
        this.approvalActionRepository = approvalActionRepository;
    }

    public ApprovalRequest createRequest(ApprovalRequest req) {
        req.setStatus("PENDING");
        req.setCurrentLevel(1);
        req.setCreatedAt(LocalDateTime.now());
        return approvalRequestRepository.save(req);
    }

    public List<ApprovalRequest> getRequestsByRequester(Long userId) {
        return approvalRequestRepository.findByRequesterId(userId);
    }

    public List<ApprovalRequest> getAllRequests() {
        return approvalRequestRepository.findAll();
    }
}
