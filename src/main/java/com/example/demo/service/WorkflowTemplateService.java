package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import com.example.demo.entity.WorkflowTemplate;

public interface WorkflowTemplateService {

    WorkflowTemplate createTemplate(WorkflowTemplate template);

    Optional<WorkflowTemplate> getTemplateById(Long id);

    List<WorkflowTemplate> getAllTemplates();

    WorkflowTemplate updateTemplate(Long id, WorkflowTemplate template);

    WorkflowTemplate activateTemplate(Long id, boolean active);
}
