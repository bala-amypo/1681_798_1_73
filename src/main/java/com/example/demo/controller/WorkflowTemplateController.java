package com.example.demo.controller;

import com.example.demo.model.WorkflowTemplate;
import com.example.demo.service.WorkflowTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/templates")
public class WorkflowTemplateController {

    @Autowired
    private WorkflowTemplateService service;

    @PostMapping
    public WorkflowTemplate createTemplate(@RequestBody WorkflowTemplate template) {
        return service.create(template);
    }

    @GetMapping
    public List<WorkflowTemplate> getAllTemplates() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public WorkflowTemplate getTemplateById(@PathVariable Long id) {
        return service.getTemplateById(id);
    }

    @PutMapping("/{id}")
    public WorkflowTemplate updateTemplate(@PathVariable Long id, @RequestBody WorkflowTemplate template) {
        return service.updateTemplate(id, template);
    }

    @PatchMapping("/{id}/activate")
    public WorkflowTemplate activateTemplate(@PathVariable Long id, @RequestParam boolean active) {
        return service.activateTemplate(id, active);
    }
}
