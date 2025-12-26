package com.example.demo.service.impl;

import com.example.demo.model.WorkflowTemplate;
import com.example.demo.repository.WorkflowTemplateRepository;
import com.example.demo.service.WorkflowTemplateService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkflowTemplateServiceImpl implements WorkflowTemplateService {

    private final WorkflowTemplateRepository templateRepository;

    public WorkflowTemplateServiceImpl(WorkflowTemplateRepository templateRepository) {
        this.templateRepository = templateRepository;
    }

    @Override
    public WorkflowTemplate create(WorkflowTemplate template) {
        return templateRepository.save(template);
    }

    @Override
    public List<WorkflowTemplate> getAll() {
        return templateRepository.findAll();
    }

    @Override
    public WorkflowTemplate getTemplateById(Long id) {
        return templateRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Template not found with id: " + id));
    }

    @Override
    public WorkflowTemplate updateTemplate(Long id, WorkflowTemplate updated) {
        WorkflowTemplate existing = getTemplateById(id);
        existing.setTemplateName(updated.getTemplateName());
        existing.setTotalLevels(updated.getTotalLevels());
        existing.setDescription(updated.getDescription());
        existing.setActive(updated.isActive());
        return templateRepository.save(existing);
    }

    @Override
    public WorkflowTemplate activateTemplate(Long id, boolean active) {
        WorkflowTemplate existing = getTemplateById(id);
        existing.setActive(active);
        return templateRepository.save(existing);
    }
}
