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
    private WorkflowStepConfigService stepService;

    @PostMapping("/")
    public WorkflowStepConfig createStep(@RequestBody WorkflowStepConfig step) {
        return stepService.createStep(step);
    }

    @GetMapping("/template/{templateId}")
    public List<WorkflowStepConfig> getStepsForTemplate(@PathVariable Long templateId) {
        return stepService.getStepsForTemplate(templateId);
    }
}
