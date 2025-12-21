package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.ApprovalRequest;
import com.example.demo.service.ApprovalRequestService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/requests")
public class ApprovalRequestController {

    @Autowired
    private ApprovalRequestService approvalRequestService;

    @PostMapping("/create")
    public ApprovalRequest createRequest(
            @RequestBody ApprovalRequest request) {

        return approvalRequestService.createRequest(request);
    }

    @GetMapping("/getAll")
    public List<ApprovalRequest> getAllRequests() {
        return approvalRequestService.getAllRequests();
    }

    @GetMapping("/getByUser/{userId}")
    public List<ApprovalRequest> getRequestsByUser(
            @PathVariable Long userId) {

        return approvalRequestService.getRequestsByRequester(userId);
    }
}
