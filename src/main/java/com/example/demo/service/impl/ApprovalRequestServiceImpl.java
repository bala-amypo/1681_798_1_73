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
    private ApprovalRequestRepository requestRepository;
    
    @Override
    public ApprovalRequest createRequest(ApprovalRequest request) {
        return requestRepository.save(request);
    }
    
    @Override
    public List<ApprovalRequest> getRequestsByRequester(Long requesterId) {
        return requestRepository.findByRequesterId(requesterId);
    }
    
    @Override
    public List<ApprovalRequest> getAllRequests() {
        return requestRepository.findAll();
    }
}