package com.example.demo.controller;

import com.example.demo.model.WorkflowTemplate;
import com.example.demo.service.WorkflowTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/templates")
public class WorkflowTemplateController {

    @Autowired
    private WorkflowTemplateService service;

    @PostMapping("/create")
    public ResponseEntity<WorkflowTemplate> create(@RequestBody WorkflowTemplate template) {
        WorkflowTemplate created = service.create(template);
        return ResponseEntity.ok(created);
    }

    @GetMapping("/all")
    public ResponseEntity<List<WorkflowTemplate>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<WorkflowTemplate> getById(@PathVariable Long id) {
        WorkflowTemplate template = service.getTemplateById(id);
        if (template != null) {
            return ResponseEntity.ok(template);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<WorkflowTemplate> update(@PathVariable Long id,
                                                   @RequestBody WorkflowTemplate template) {
        WorkflowTemplate updated = service.updateTemplate(id, template);
        return ResponseEntity.ok(updated);
    }

    @PatchMapping("/activate/{id}")
    public ResponseEntity<String> activate(@PathVariable Long id,
                                           @RequestParam boolean active) {
        service.activateTemplate(id, active);
        return ResponseEntity.ok("Template " + (active ? "activated" : "deactivated"));
    }
}
