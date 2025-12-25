package com.example.demo.controller;

import com.example.demo.model.WorkflowStepConfig;
import com.example.demo.service.WorkflowStepConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/steps")
public class WorkflowStepConfigController {

    @Autowired
    private WorkflowStepConfigService workflowStepConfigService;

    @PostMapping
    public WorkflowStepConfig create(@RequestBody WorkflowStepConfig step) {
        return workflowStepConfigService.createStep(step);
    }

    @GetMapping("/template/{templateId}")
    public List<WorkflowStepConfig> getByTemplate(@PathVariable Long templateId) {
        return workflowStepConfigService.getStepsByTemplate(templateId);
    }
}
