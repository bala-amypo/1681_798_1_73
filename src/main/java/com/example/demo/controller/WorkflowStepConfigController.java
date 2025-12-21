package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.WorkflowStepConfig;
import com.example.demo.service.WorkflowStepConfigService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/steps")
public class WorkflowStepConfigController {

    @Autowired
    private WorkflowStepConfigService workflowStepConfigService;

    @PostMapping("/create")
    public WorkflowStepConfig createStep(@RequestBody WorkflowStepConfig step) {
        return workflowStepConfigService.createStep(step);
    }

    @GetMapping("/template/{templateId}")
    public List<WorkflowStepConfig> getStepsByTemplate(
            @PathVariable Long templateId) {

        return workflowStepConfigService.getStepsForTemplate(templateId);
    }
}
