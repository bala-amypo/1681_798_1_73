package com.example.demo.service;

import com.example.demo.model.WorkflowStepConfig;
import com.example.demo.repository.WorkflowStepConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class WorkflowStepConfigServiceImpl implements WorkflowStepConfigService {
    @Autowired
    private final WorkflowStepConfigRepository repository;

    public WorkflowStepConfigServiceImpl(WorkflowStepConfigRepository repository) {
        this.repository = repository;
    }

    @Override
    public WorkflowStepConfig create(WorkflowStepConfig step) {
        return repository.save(step);
    }

    @Override
    public List<WorkflowStepConfig> getByTemplate(Long templateId) {
        return repository.findByTemplateIdOrderByLevelNumberAsc(templateId);
    }
}
