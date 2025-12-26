package com.example.demo.controller;

import com.example.demo.model.WorkflowTemplate;
import com.example.demo.service.WorkflowTemplateService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/templates")
public class WorkflowTemplateController {

    private final WorkflowTemplateService service;

    public WorkflowTemplateController(WorkflowTemplateService service) {
        this.service = service;
    }

    @PostMapping
    public WorkflowTemplate create(@RequestBody WorkflowTemplate template) {
        return service.createTemplate(template); // ✅ FIXED
    }

    @GetMapping
    public List<WorkflowTemplate> getAll() {
        return service.getAllTemplates(); // ✅ FIXED
    }

    @GetMapping("/{id}")
    public WorkflowTemplate getById(@PathVariable Long id) {
        return service.getTemplateById(id)
                .orElseThrow(() -> new RuntimeException("Template not found")); // ✅ Optional handled
    }

    @PutMapping("/{id}")
    public WorkflowTemplate update(
            @PathVariable Long id,
            @RequestBody WorkflowTemplate template) {
        return service.updateTemplate(id, template);
    }

    @PutMapping("/{id}/activate")
    public WorkflowTemplate activate(
            @PathVariable Long id,
            @RequestParam boolean active) {
        return service.activateTemplate(id, active);
    }
}
