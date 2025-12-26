package com.example.demo.service.impl;

import com.example.demo.model.WorkflowTemplate;
import com.example.demo.service.WorkflowTemplateService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class WorkflowTemplateServiceImpl implements WorkflowTemplateService {

    private final List<WorkflowTemplate> templates = new ArrayList<>();

    @Override
    public WorkflowTemplate createTemplate(WorkflowTemplate template) {
        templates.add(template);
        return template;
    }

    @Override
    public List<WorkflowTemplate> getAllTemplates() {
        return templates;
    }

    @Override
    public WorkflowTemplate getTemplateById(Long id) {
        Optional<WorkflowTemplate> template = templates.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst();
        return template.orElseThrow(() -> new RuntimeException("Template not found with id: " + id));
    }
}
