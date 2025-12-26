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
    private WorkflowTemplateService templateService;

    @PostMapping("/")
    public WorkflowTemplate createTemplate(@RequestBody WorkflowTemplate template) {
        return templateService.createTemplate(template);
    }

    @GetMapping("/{id}")
    public Optional<WorkflowTemplate> getTemplate(@PathVariable Long id) {
        return templateService.getTemplateById(id);
    }

    @PutMapping("/{id}")
    public WorkflowTemplate updateTemplate(@PathVariable Long id, @RequestBody WorkflowTemplate template) {
        return templateService.updateTemplate(id, template);
    }

    @GetMapping("/")
    public List<WorkflowTemplate> getAllTemplates() {
        return templateService.getAllTemplates();
    }
}
