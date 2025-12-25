package com.example.demo.service.impl;

import com.example.demo.model.WorkflowTemplate;
import com.example.demo.repository.WorkflowTemplateRepository;
import com.example.demo.service.WorkflowTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WorkflowTemplateServiceImpl implements WorkflowTemplateService {

    @Autowired
    private WorkflowTemplateRepository workflowTemplateRepository;

    public WorkflowTemplate createTemplate(WorkflowTemplate template) {
        return workflowTemplateRepository.save(template);
    }

    public Optional<WorkflowTemplate> getTemplateById(Long id) {
        return workflowTemplateRepository.findById(id);
    }

    public WorkflowTemplate updateTemplate(Long id, WorkflowTemplate template) {
        WorkflowTemplate existing = workflowTemplateRepository.findById(id).orElseThrow();
        existing.setTemplateName(template.getTemplateName());
        existing.setDescription(template.getDescription());
        existing.setTotalLevels(template.getTotalLevels());
        return workflowTemplateRepository.save(existing);
    }

    public WorkflowTemplate activateTemplate(Long id, boolean active) {
        WorkflowTemplate template = workflowTemplateRepository.findById(id).orElseThrow();
        template.setActive(active);
        return workflowTemplateRepository.save(template);
    }

    public List<WorkflowTemplate> getAllTemplates() {
        return workflowTemplateRepository.findAll();
    }
}
