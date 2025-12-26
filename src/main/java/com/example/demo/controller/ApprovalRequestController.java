package com.example.demo.controller;

import com.example.demo.model.ApprovalRequest;
import com.example.demo.service.ApprovalRequestService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/approval/requests")
public class ApprovalRequestController {

    private final ApprovalRequestService service;

    public ApprovalRequestController(ApprovalRequestService service) {
        this.service = service;
    }

    @PostMapping
    public ApprovalRequest create(@RequestBody ApprovalRequest request) {
        return service.create(request);
    }

    @GetMapping("/user/{userId}")
    public List<ApprovalRequest> getByUser(@PathVariable Long userId) {
        return service.getByRequester(userId);
    }
}
