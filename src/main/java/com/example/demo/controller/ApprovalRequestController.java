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
    private ApprovalRequestService service;

    // Create a request
    @PostMapping
    public ApprovalRequest createRequest(@RequestBody ApprovalRequest request) {
        return service.create(request);       // matches service.create()
    }

    // Get requests by requester
    @GetMapping("/requester/{id}")
    public List<ApprovalRequest> getRequestsByRequester(@PathVariable Long id) {
        return service.getByRequester(id);    // matches service.getByRequester()
    }

    // Get all requests
    @GetMapping
    public List<ApprovalRequest> getAllRequests() {
        return service.getAllRequests();      // matches service.getAllRequests()
    }
}
