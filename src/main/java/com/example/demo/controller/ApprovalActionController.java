package com.example.demo.controller;

import com.example.demo.model.ApprovalAction;
import com.example.demo.service.ApprovalActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/actions")
public class ApprovalActionController {

    @Autowired
    private ApprovalActionService approvalActionService;

    @PostMapping
    public ApprovalAction create(@RequestBody ApprovalAction action) {
        return approvalActionService.saveAction(action);
    }

    @GetMapping("/level/{level}/action/{action}")
    public List<ApprovalAction> getByLevelAndAction(
            @PathVariable Integer level,
            @PathVariable String action) {
        return approvalActionService.findByLevelAndAction(level, action);
    }
}
