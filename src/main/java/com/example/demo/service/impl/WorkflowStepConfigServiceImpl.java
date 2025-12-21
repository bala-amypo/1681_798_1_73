package com.example.demo.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import com.example.demo.entity.WorkflowStepConfig;
import com.example.demo.repository.WorkflowStepConfigRepository;
import com.example.demo.service.WorkflowStepConfigService;

@Service
public class WorkflowStepConfigServiceImpl implements WorkflowStepConfigService {

    private final WorkflowStepConfigRepository stepRepo;

    public WorkflowStepConfigServiceImpl(WorkflowStepConfigRepository stepRepo) {
        this.stepRepo = stepRepo;
    }

    @Override
    public WorkflowStepConfig createStep(WorkflowStepConfig step) {
        return stepRepo.save(step);
    }

    @Override
    public List<WorkflowStepConfig> getStepsForTemplate(Long templateId) {
        return stepRepo.findByTemplateIdOrderByLevelNumberAsc(templateId);
    }
}
