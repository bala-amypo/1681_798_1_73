package com.example.demo.service.impl;

import com.example.demo.model.WorkflowStepConfig;
import com.example.demo.repository.WorkflowStepConfigRepository;
import com.example.demo.service.WorkflowStepConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkflowStepConfigServiceImpl implements WorkflowStepConfigService {
    
    @Autowired
    private WorkflowStepConfigRepository stepRepository;
    
    @Override
    public WorkflowStepConfig createStep(WorkflowStepConfig step) {
        return stepRepository.save(step);
    }
}