package com.example.demo.service;

import com.example.demo.model.ApprovalRequest;
import com.example.demo.repository.ApprovalRequestRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ApprovalRequestServiceImpl implements ApprovalRequestService {

    private final ApprovalRequestRepository repository;

    public ApprovalRequestServiceImpl(ApprovalRequestRepository repository) {
        this.repository = repository;
    }

    public ApprovalRequest createRequest(ApprovalRequest request) {
        return repository.save(request);
    }

    public List<ApprovalRequest> getRequestsByRequester(long requesterId) {
        return repository.findByRequesterId(requesterId);
    }

    public List<ApprovalRequest> getAllRequests() {
        return repository.findAll();
    }
}
