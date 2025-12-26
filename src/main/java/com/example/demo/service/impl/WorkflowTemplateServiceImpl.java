package com.example.demo.service.impl;

import com.example.demo.model.WorkflowTemplate;
import com.example.demo.service.WorkflowTemplateService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class WorkflowTemplateServiceImpl implements WorkflowTemplateService {

    private final List<WorkflowTemplate> templates = new ArrayList<>();

    @Override
    public WorkflowTemplate create(WorkflowTemplate template) {
        templates.add(template);
        return template;
    }

    @Override
    public List<WorkflowTemplate> getAll() {
        return templates;
    }
    @Override
    public WorkflowTemplate getTemplateById(Long id) {
         return templateRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Template not found with id: " + id));
    }


    @Override
    public WorkflowTemplate updateTemplate(Long id, WorkflowTemplate updated) {
        for (WorkflowTemplate t : templates) {
            if (t.getId().equals(id)) {
                t.setTemplateName(updated.getTemplateName());
                t.setTotalLevels(updated.getTotalLevels());
                t.setDescription(updated.getDescription());
                t.setActive(updated.getActive());
                return t;
            }
        }
        return null;
    }

    @Override
    public WorkflowTemplate activateTemplate(Long id, boolean active) {
        for (WorkflowTemplate t : templates) {
            if (t.getId().equals(id)) {
                t.setActive(active);
                return t;
            }
        }
        return null;
    }
}
