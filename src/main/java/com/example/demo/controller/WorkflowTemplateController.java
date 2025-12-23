package com.example.demo.controller;

import com.example.demo.entity.WorkflowTemplate;
import com.example.demo.service.WorkflowTemplateService;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.util.List;
import java.lang.Long;

@RestController
@RequestMapping("/api/templates")
public class WorkflowTemplateController {

    private final WorkflowTemplateService workflowTemplateService;

    public WorkflowTemplateController(WorkflowTemplateService workflowTemplateService) {
        this.workflowTemplateService = workflowTemplateService;
    }

    @PostMapping
    public ResponseEntity<WorkflowTemplate> createTemplate(@RequestBody WorkflowTemplate template) {
        return ResponseEntity.ok(workflowTemplateService.createTemplate(template));
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkflowTemplate> getTemplateById(@PathVariable Long id) {
    WorkflowTemplate template =workflowTemplateService.getTemplateById(id)
                    .orElseThrow(() -> new RuntimeException("Template not found"));

    return ResponseEntity.ok(template);
}


    @PutMapping("/{id}")
    public ResponseEntity<WorkflowTemplate> updateTemplate(@PathVariable Long id,
                                                           @RequestBody WorkflowTemplate template) {
        return ResponseEntity.ok(workflowTemplateService.updateTemplate(id, template));
    }

    @GetMapping
    public ResponseEntity<List<WorkflowTemplate>> getAllTemplates() {
        return ResponseEntity.ok(workflowTemplateService.getAllTemplates());
    }
}
