package com.example.demo.service;

import com.example.demo.model.WorkflowStepConfig;
import java.util.List;

public interface WorkflowStepConfigService {
    WorkflowStepConfig create(WorkflowStepConfig step);
    List<WorkflowStepConfig> getByTemplate(Long templateId);
}
