package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entity.WorkflowTemplate;
import com.example.demo.service.WorkflowTemplateService;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/templates")
public class WorkflowTemplateController {

    @Autowired
    private WorkflowTemplateService workflowTemplateService;

    @PostMapping("/create")
    public WorkflowTemplate createTemplate(@RequestBody WorkflowTemplate template) {
        return workflowTemplateService.createTemplate(template);
    }

    @GetMapping("/get/{id}")
    public Optional<WorkflowTemplate> getTemplate(@PathVariable Long id) {
        return workflowTemplateService.getTemplateById(id);
    }

    @GetMapping("/getAll")
    public List<WorkflowTemplate> getAllTemplates() {
        return workflowTemplateService.getAllTemplates();
    }

    @PutMapping("/update/{id}")
    public String updateTemplate(
            @PathVariable Long id,
            @RequestBody WorkflowTemplate template) {

        workflowTemplateService.updateTemplate(id, template);
        return "Updated Successfully";
    }

    @PutMapping("/activate/{id}")
    public String activateTemplate(
            @PathVariable Long id,
            @RequestParam boolean active) {

        workflowTemplateService.activateTemplate(id, active);
        return "Status Updated";
    }
}
