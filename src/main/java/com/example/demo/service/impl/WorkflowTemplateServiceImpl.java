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
    public Optional<WorkflowTemplate> getTemplateById(Long id) {
        return templates.stream()
                .filter(t -> t.getId().equals(id))
                .findFirst();
    }

    @Override
    public WorkflowTemplate updateTemplate(Long id, WorkflowTemplate updated) {
        WorkflowTemplate template = getTemplateById(id)
                .orElseThrow(() -> new RuntimeException("Template not found"));

        template.setTemplateName(updated.getTemplateName());
        template.setDescription(updated.getDescription());
        template.setTotalLevels(updated.getTotalLevels());
        template.setActive(updated.getActive());

        return template;
    }

    @Override
    public WorkflowTemplate activateTemplate(Long id, boolean active) {
        WorkflowTemplate template = getTemplateById(id)
                .orElseThrow(() -> new RuntimeException("Template not found"));

        template.setActive(active);
        return template;
    }
}
