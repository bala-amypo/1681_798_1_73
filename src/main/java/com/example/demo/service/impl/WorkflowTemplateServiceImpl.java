package com.example.demo.service.impl;

import com.example.demo.entity.WorkflowTemplate;
import com.example.demo.repository.WorkflowTemplateRepository;
import com.example.demo.service.WorkflowTemplateService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.lang.Long;

@Service
public class WorkflowTemplateServiceImpl implements WorkflowTemplateService {

    private final WorkflowTemplateRepository workflowTemplateRepository;

    public WorkflowTemplateServiceImpl(WorkflowTemplateRepository workflowTemplateRepository) {
        this.workflowTemplateRepository = workflowTemplateRepository;
    }

    public WorkflowTemplate createTemplate(WorkflowTemplate t) {
        if (t.getActive() == null) {
            t.setActive(false);
        }
        return workflowTemplateRepository.save(t);
    }

    public Optional<WorkflowTemplate> getTemplateById(Long id) {
        return workflowTemplateRepository.findById(id);
    }

    public List<WorkflowTemplate> getAllTemplates() {
        return workflowTemplateRepository.findAll();
    }

    public WorkflowTemplate updateTemplate(Long id, WorkflowTemplate t) {
        WorkflowTemplate existing = workflowTemplateRepository.findById(id).orElseThrow();
        existing.setTemplateName(t.getTemplateName());
        existing.setDescription(t.getDescription());
        existing.setTotalLevels(t.getTotalLevels());
        return workflowTemplateRepository.save(existing);
    }

    public WorkflowTemplate activateTemplate(Long id, boolean active) {
        WorkflowTemplate template = workflowTemplateRepository.findById(id).orElseThrow();
        template.setActive(active);
        return workflowTemplateRepository.save(template);
    }
}
