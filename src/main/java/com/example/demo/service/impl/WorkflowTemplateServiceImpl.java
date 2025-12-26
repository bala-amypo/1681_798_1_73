package com.example.demo.service.impl;

import com.example.demo.model.WorkflowTemplate;
import com.example.demo.repository.WorkflowTemplateRepository;
import com.example.demo.service.WorkflowTemplateService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkflowTemplateServiceImpl implements WorkflowTemplateService {

    private final WorkflowTemplateRepository repository;

    public WorkflowTemplateServiceImpl(WorkflowTemplateRepository repository) {
        this.repository = repository;
    }

    @Override
    public WorkflowTemplate createTemplate(WorkflowTemplate template) {
        return repository.save(template);
    }

    @Override
    public List<WorkflowTemplate> getAllTemplates() {
        return repository.findAll();
    }

    @Override
    public Optional<WorkflowTemplate> getTemplateById(Long id) {
        return repository.findById(id);
    }

    @Override
    public WorkflowTemplate updateTemplate(Long id, WorkflowTemplate updated) {
        WorkflowTemplate template = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Template not found"));

        template.setTemplateName(updated.getTemplateName());
        template.setDescription(updated.getDescription());
        template.setTotalLevels(updated.getTotalLevels());
        template.setActive(updated.getActive());

        return repository.save(template);
    }

    @Override
    public WorkflowTemplate activateTemplate(Long id, boolean active) {
        WorkflowTemplate template = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Template not found"));

        template.setActive(active);
        return repository.save(template);
    }
}
