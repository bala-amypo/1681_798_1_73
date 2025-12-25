package com.example.demo.controller;

import com.example.demo.model.WorkflowTemplate;
import com.example.demo.service.WorkflowTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/templates")
public class WorkflowTemplateController {

    @Autowired
    private WorkflowTemplateService workflowTemplateService;

    @PostMapping
    public WorkflowTemplate create(@RequestBody WorkflowTemplate template) {
        return workflowTemplateService.createTemplate(template);
    }

    @GetMapping("/{id}")
    public Optional<WorkflowTemplate> getById(@PathVariable Long id) {
        return workflowTemplateService.getTemplateById(id);
    }

    @PutMapping("/{id}")
    public WorkflowTemplate update(@PathVariable Long id, @RequestBody WorkflowTemplate template) {
        return workflowTemplateService.updateTemplate(id, template);
    }

    @PutMapping("/{id}/activate")
    public WorkflowTemplate activate(@PathVariable Long id, @RequestParam boolean active) {
        return workflowTemplateService.activateTemplate(id, active);
    }

    @GetMapping
    public List<WorkflowTemplate> getAll() {
        return workflowTemplateService.getAllTemplates();
    }
}
