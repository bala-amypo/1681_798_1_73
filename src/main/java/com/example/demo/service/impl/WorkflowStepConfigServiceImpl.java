package com.example.demo.service.impl;

import com.example.demo.model.WorkflowStepConfig;
import com.example.demo.repository.WorkflowStepConfigRepository;
import com.example.demo.service.WorkflowStepConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkflowStepConfigServiceImpl implements WorkflowStepConfigService {

    @Autowired
    private WorkflowStepConfigRepository workflowStepConfigRepository;

    public WorkflowStepConfig createStep(WorkflowStepConfig step) {
        return workflowStepConfigRepository.save(step);
    }

    public List<WorkflowStepConfig> getStepsByTemplate(Long templateId) {
        return workflowStepConfigRepository.findByTemplateIdOrderByLevelNumberAsc(templateId);
    }
}
