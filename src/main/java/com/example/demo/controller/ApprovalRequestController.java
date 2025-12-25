package com.example.demo.controller;

import com.example.demo.model.ApprovalRequest;
import com.example.demo.service.ApprovalRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/requests")
public class ApprovalRequestController {

    @Autowired
    private ApprovalRequestService approvalRequestService;

    @PostMapping
    public ApprovalRequest create(@RequestBody ApprovalRequest request) {
        return approvalRequestService.createRequest(request);
    }

    @GetMapping
    public List<ApprovalRequest> getAll() {
        return approvalRequestService.getAllRequests();
    }

    @GetMapping("/requester/{requesterId}")
    public List<ApprovalRequest> getByRequester(@PathVariable Long requesterId) {
        return approvalRequestService.getRequestsByRequester(requesterId);
    }
}
