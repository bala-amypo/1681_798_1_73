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

    @PostMapping
    public ApprovalAction create(@RequestBody ApprovalAction action) {
        return service.create(action);
    }

    @GetMapping("/{level}/{action}")
    public List<ApprovalAction> getByLevelAndAction(@PathVariable Integer level,
                                                    @PathVariable String action) {
        return service.getByLevelAndAction(level, action);
    }
}
