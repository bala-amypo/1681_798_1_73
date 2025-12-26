package com.example.demo.service;

import com.example.demo.model.ApprovalRequest;
import java.util.List;

public interface ApprovalRequestService {

    ApprovalRequest create(ApprovalRequest request);      
    List<ApprovalRequest> getByRequester(Long requesterId); 
    List<ApprovalRequest> getAllRequests();
}
