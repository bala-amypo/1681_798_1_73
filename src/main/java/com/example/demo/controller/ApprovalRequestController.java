package com.example.demo.controller;

import com.example.demo.model.ApprovalRequest;
import com.example.demo.service.ApprovalRequestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/requests")
public class ApprovalRequestController {

    private final ApprovalRequestService service;

    public ApprovalRequestController(ApprovalRequestService service) {
        this.service = service;
    }

    @PostMapping
    public ApprovalRequest create(@RequestBody ApprovalRequest request) {
        return service.createRequest(request); // ✅ FIXED
    }

    @GetMapping("/requester/{id}")
    public List<ApprovalRequest> getByRequester(@PathVariable Long id) {
        return service.getRequestsByRequester(id); // ✅ FIXED
    }
}
