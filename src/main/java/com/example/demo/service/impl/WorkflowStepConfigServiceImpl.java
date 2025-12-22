package com.example.demo.service.impl;

import com.example.demo.entity.WorkflowStepConfig;
import com.example.demo.repository.WorkflowStepConfigRepository;
import com.example.demo.service.WorkflowStepConfigService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.lang.Long;

@Service
public class WorkflowStepConfigServiceImpl implements WorkflowStepConfigService {

    private final WorkflowStepConfigRepository workflowStepConfigRepository;

    public WorkflowStepConfigServiceImpl(WorkflowStepConfigRepository workflowStepConfigRepository) {
        this.workflowStepConfigRepository = workflowStepConfigRepository;
    }

    public WorkflowStepConfig createStep(WorkflowStepConfig step) {
        return workflowStepConfigRepository.save(step);
    }

    public List<WorkflowStepConfig> getStepsForTemplate(Long templateId) {
        return workflowStepConfigRepository.findByTemplateIdOrderByLevelNumberAsc(templateId);
    }
}
