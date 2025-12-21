package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.demo.entity.WorkflowTemplate;
import com.example.demo.repository.WorkflowTemplateRepository;
import com.example.demo.service.WorkflowTemplateService;

@Service
public class WorkflowTemplateServiceImpl implements WorkflowTemplateService {

    private final WorkflowTemplateRepository workflowTemplateRepository;

    public WorkflowTemplateServiceImpl(
            WorkflowTemplateRepository workflowTemplateRepository) {
        this.workflowTemplateRepository = workflowTemplateRepository;
    }

    @Override
    public WorkflowTemplate createTemplate(WorkflowTemplate template) {
        if (workflowTemplateRepository
                .existsByTemplateName(template.getTemplateName())) {
            throw new RuntimeException("Template name already exists");
        }
        template.setActive(false);
        return workflowTemplateRepository.save(template);
    }

    @Override
    public Optional<WorkflowTemplate> getTemplateById(Long id) {
        return workflowTemplateRepository.findById(id);
    }

    @Override
    public List<WorkflowTemplate> getAllTemplates() {
        return workflowTemplateRepository.findAll();
    }

    @Override
    public WorkflowTemplate updateTemplate(Long id, WorkflowTemplate template) {
        template.setId(id);
        return workflowTemplateRepository.save(template);
    }

    @Override
    public WorkflowTemplate activateTemplate(Long id, boolean active) {
        WorkflowTemplate template =
                workflowTemplateRepository.findById(id).get();
        template.setActive(active);
        return workflowTemplateRepository.save(template);
    }
}
