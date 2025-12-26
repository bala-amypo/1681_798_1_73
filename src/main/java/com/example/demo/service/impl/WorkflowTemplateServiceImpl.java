package com.example.demo.service.impl;

import com.example.demo.model.WorkflowTemplate;
import com.example.demo.service.WorkflowTemplateService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        return templates.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Template not found with id: " + id));
    }

    @Override
    public WorkflowTemplate updateTemplate(Long id, WorkflowTemplate updated) {
        WorkflowTemplate template = getTemplateById(id);
        template.setTemplateName(updated.getTemplateName());
        template.setTotalLevels(updated.getTotalLevels());
        template.setDescription(updated.getDescription());
        template.setActive(updated.isActive());
        return template;
    }

    @Override
    public WorkflowTemplate activateTemplate(Long id, boolean active) {
        WorkflowTemplate template = getTemplateById(id);
        template.setActive(active);
        return template;
    }
}
