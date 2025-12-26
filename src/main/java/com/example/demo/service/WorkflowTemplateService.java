package com.example.demo.service;

import com.example.demo.model.WorkflowTemplate;
import java.util.List;

public interface WorkflowTemplateService {

    WorkflowTemplate create(WorkflowTemplate template);
    List<WorkflowTemplate> getAll();                     
    WorkflowTemplate getTemplateById(Long id);
    WorkflowTemplate updateTemplate(Long id, WorkflowTemplate template);
    WorkflowTemplate activateTemplate(Long id, boolean active);
}
