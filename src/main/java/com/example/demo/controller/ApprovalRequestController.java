package com.example.demo.controller;

import com.example.demo.entity.ApprovalRequest;
import com.example.demo.service.ApprovalRequestService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.lang.Long;

@RestController
@RequestMapping("/api/requests")
public class ApprovalRequestController {

    private final ApprovalRequestService approvalRequestService;

    public ApprovalRequestController(ApprovalRequestService approvalRequestService) {
        this.approvalRequestService = approvalRequestService;
    }

    @PostMapping
    public ResponseEntity<ApprovalRequest> createRequest(@RequestBody ApprovalRequest request) {
        return ResponseEntity.ok(approvalRequestService.createRequest(request));
    }

    @GetMapping
    public ResponseEntity<List<ApprovalRequest>> getAllRequests(
            @RequestParam(value = "requesterId", required = false) Long requesterId) {

        if (requesterId != null) {
            return ResponseEntity.ok(approvalRequestService.getRequestsByRequester(requesterId));
        }
        return ResponseEntity.ok(approvalRequestService.getAllRequests());
    }
}
