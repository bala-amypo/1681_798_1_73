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
    private ApprovalRequestService requestService;

    @PostMapping("/")
    public ApprovalRequest createRequest(@RequestBody ApprovalRequest request) {
        return requestService.createRequest(request);
    }

    @GetMapping("/")
    public List<ApprovalRequest> getAllRequests(@RequestParam(required = false) Long requesterId) {
        if (requesterId != null) {
            return requestService.getRequestsByRequester(requesterId);
        }
        return requestService.getAllRequests();
    }
}
