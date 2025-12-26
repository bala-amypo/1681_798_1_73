package com.example.demo.controller;

import com.example.demo.model.ApprovalAction;
import com.example.demo.service.ApprovalActionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/approval/actions")
public class ApprovalActionController {

    private final ApprovalActionService service;

    public ApprovalActionController(ApprovalActionService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping
    public ApprovalAction create(@RequestBody ApprovalAction action) {
        return service.create(action);
    }

    // GET BY LEVEL + ACTION
    @GetMapping("/{level}/{action}")
    public List<ApprovalAction> getByLevelAndAction(
            @PathVariable Integer level,
            @PathVariable String action) {
        return service.getByLevelAndAction(level, action);
    }

    // GET BY REQUEST ID
    @GetMapping("/request/{requestId}")
    public List<ApprovalAction> getByRequest(@PathVariable Long requestId) {
        return service.getByRequestId(requestId);
    }
}
