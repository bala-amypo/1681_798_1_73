package com.example.demo.service.impl;

import com.example.demo.model.WorkflowStepConfig;
import com.example.demo.repository.WorkflowStepConfigRepository;
import com.example.demo.service.WorkflowStepConfigService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkflowStepConfigServiceImpl implements WorkflowStepConfigService {

    private final WorkflowStepConfigRepository repository;

    public WorkflowStepConfigServiceImpl(WorkflowStepConfigRepository repository) {
        this.repository = repository;
    }

    @Override
    public WorkflowStepConfig create(WorkflowStepConfig config) {
        return repository.save(config);
    }

    @Override
    public List<WorkflowStepConfig> getByTemplate(Long templateId) {
        return repository.findByTemplateId(templateId);
    }
}
