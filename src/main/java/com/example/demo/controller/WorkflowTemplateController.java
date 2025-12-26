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

    @PostMapping("/create")
    public WorkflowTemplate create(@RequestBody WorkflowTemplate template) {
        return service.create(template);
    }

    @GetMapping("/all")
    public List<WorkflowTemplate> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public WorkflowTemplate getById(@PathVariable Long id) {
        return service.getTemplateById(id); // Make sure this method exists in the service
    }

    @PutMapping("/update/{id}")
    public WorkflowTemplate update(@PathVariable Long id, @RequestBody WorkflowTemplate template) {
        return service.updateTemplate(id, template);
    }

    @PutMapping("/activate/{id}")
    public WorkflowTemplate activate(@PathVariable Long id, @RequestParam boolean active) {
        return service.activateTemplate(id, active);
    }
}
