package com.example.demo.service.impl;

import com.example.demo.model.ApprovalRequest;
import com.example.demo.repository.ApprovalRequestRepository;
import com.example.demo.service.ApprovalRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApprovalRequestServiceImpl implements ApprovalRequestService {

    @Autowired
    private ApprovalRequestRepository approvalRequestRepository;

    public ApprovalRequest createRequest(ApprovalRequest request) {
        return approvalRequestRepository.save(request);
    }

    public List<ApprovalRequest> getRequestsByRequester(Long requesterId) {
        return approvalRequestRepository.findByRequesterId(requesterId);
    }

    public List<ApprovalRequest> getAllRequests() {
        return approvalRequestRepository.findAll();
    }
}
