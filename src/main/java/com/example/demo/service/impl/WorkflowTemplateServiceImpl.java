package com.example.demo.service;

import com.example.demo.model.WorkflowTemplate;
import com.example.demo.repository.WorkflowTemplateRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class WorkflowTemplateServiceImpl implements WorkflowTemplateService {

    private final WorkflowTemplateRepository repository;

    public WorkflowTemplateServiceImpl(WorkflowTemplateRepository repository) {
        this.repository = repository;
    }

    public WorkflowTemplate createTemplate(WorkflowTemplate template) {
        return repository.save(template);
    }

    public WorkflowTemplate getTemplateById(Long id) {
        return repository.findById(id).orElse(null);
    }

    public WorkflowTemplate updateTemplate(Long id, WorkflowTemplate template) {
        WorkflowTemplate existing = getTemplateById(id);
        existing.setName(template.getName());
        return repository.save(existing);
    }

    public WorkflowTemplate activateTemplate(Long id, boolean active) {
        WorkflowTemplate template = getTemplateById(id);
        template.setActive(active);
        return repository.save(template);
    }

    public List<WorkflowTemplate> getAllTemplates() {
        return repository.findAll();
    }
}
