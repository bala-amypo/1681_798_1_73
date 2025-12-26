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
    private WorkflowTemplateRepository repository;

    // Controller/TestNG expects `create`
    @Override
    public WorkflowTemplate create(WorkflowTemplate template) {
        return repository.save(template);
    }

    // Controller/TestNG expects `getAll`
    @Override
    public List<WorkflowTemplate> getAll() {
        return repository.findAll();
    }

    @Override
    public WorkflowTemplate getTemplateById(Long id) {
        Optional<WorkflowTemplate> template = repository.findById(id);
        return template.orElse(null);
    }

    @Override
    public WorkflowTemplate updateTemplate(Long id, WorkflowTemplate updatedTemplate) {
        WorkflowTemplate template = getTemplateById(id);
        if (template != null) {
            template.setName(updatedTemplate.getName());
            template.setActive(updatedTemplate.isActive());
            // copy other fields if any
            return repository.save(template);
        }
        return null;
    }

    @Override
    public WorkflowTemplate activateTemplate(Long id, boolean active) {
        WorkflowTemplate template = getTemplateById(id);
        if (template != null) {
            template.setActive(active);
            return repository.save(template);
        }
        return null;
    }
}
