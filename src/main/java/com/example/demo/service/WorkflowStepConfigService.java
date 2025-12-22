package com.example.demo.service;

import com.example.demo.entity.WorkflowStepConfig;
import java.util.List;
import java.lang.Long;

public interface WorkflowStepConfigService {

    WorkflowStepConfig createStep(WorkflowStepConfig step);

    List<WorkflowStepConfig> getStepsForTemplate(Long templateId);
}
