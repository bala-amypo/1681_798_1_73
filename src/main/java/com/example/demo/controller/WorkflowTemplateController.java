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
    public WorkflowTemplate createTemplate(@RequestBody WorkflowTemplate template) {
        return service.createTemplate(template); // ✅ FIXED
    }

    @GetMapping
    public List<WorkflowTemplate> getAllTemplates() {
        return service.getAllTemplates(); // ✅ FIXED
    }

    @GetMapping("/{id}")
    public WorkflowTemplate getById(@PathVariable Long id) {
        return service.getTemplateById(id)
                .orElseThrow(() -> new RuntimeException("Template not found")); // ✅ Optional handled
    }

    @PutMapping("/{id}")
    public WorkflowTemplate updateTemplate(
            @PathVariable Long id,
            @RequestBody WorkflowTemplate template) {
        return service.updateTemplate(id, template);
    }

    @PutMapping("/{id}/activate")
    public WorkflowTemplate activateTemplate(
            @PathVariable Long id,
            @RequestParam boolean active) {
        return service.activateTemplate(id, active);
    }
}
