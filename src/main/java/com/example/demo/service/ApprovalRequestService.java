package com.example.demo.service;

import com.example.demo.entity.ApprovalRequest;
import java.util.List;
import java.lang.Long;

public interface ApprovalRequestService {

    ApprovalRequest createRequest(ApprovalRequest req);

    List<ApprovalRequest> getRequestsByRequester(Long userId);

    List<ApprovalRequest> getAllRequests();
}
