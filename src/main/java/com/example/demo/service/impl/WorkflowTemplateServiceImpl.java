package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.example.demo.entity.WorkflowTemplate;
import com.example.demo.repository.WorkflowTemplateRepository;
import com.example.demo.service.WorkflowTemplateService;

@Service
public class WorkflowTemplateServiceImpl implements WorkflowTemplateService {

    private final WorkflowTemplateRepository templateRepo;

    public WorkflowTemplateServiceImpl(WorkflowTemplateRepository templateRepo) {
        this.templateRepo = templateRepo;
    }

    @Override
    public WorkflowTemplate createTemplate(WorkflowTemplate t) {
        if (templateRepo.existsByTemplateName(t.getTemplateName())) {
            throw new RuntimeException("Template name already exists");
        }
        t.setActive(false);
        return templateRepo.save(t);
    }

    @Override
    public Optional<WorkflowTemplate> getTemplateById(Long id) {
        return templateRepo.findById(id);
    }

    @Override
    public List<WorkflowTemplate> getAllTemplates() {
        return templateRepo.findAll();
    }

    @Override
    public WorkflowTemplate updateTemplate(Long id, WorkflowTemplate t) {
        WorkflowTemplate existing = templateRepo.findById(id).orElseThrow();
        existing.setTemplateName(t.getTemplateName());
        return templateRepo.save(existing);
    }

    @Override
    public WorkflowTemplate activateTemplate(Long id, boolean active) {
        WorkflowTemplate template = templateRepo.findById(id).orElseThrow();
        template.setActive(active);
        return templateRepo.save(template);
    }
}
