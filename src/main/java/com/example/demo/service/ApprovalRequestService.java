package com.example.demo.service;

import java.util.List;
import com.example.demo.entity.ApprovalRequest;

public interface ApprovalRequestService {
    ApprovalRequest createRequest(ApprovalRequest req);
    List<ApprovalRequest> getRequestsByRequester(Long userId);
    List<ApprovalRequest> getAllRequests();
}
