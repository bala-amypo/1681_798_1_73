package com.example.demo.model;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "workflow_templates", uniqueConstraints = @UniqueConstraint(columnNames = "template_name"))
public class WorkflowTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "template_name", nullable = false, unique = true)
    private String templateName;

    private String description;

    @Column(nullable = false)
    private Integer totalLevels;

    private Boolean active = true;

    public Long getId() { return id; }
    public String getTemplateName() { return templateName; }
    public String getDescription() { return description; }
    public Integer getTotalLevels() { return totalLevels; }
    public Boolean getActive() { return active; }

    public void setId(Long id) { this.id = id; }
    public void setTemplateName(String templateName) { this.templateName = templateName; }
    public void setDescription(String description) { this.description = description; }
    public void setTotalLevels(Integer totalLevels) { this.totalLevels = totalLevels; }
    public void setActive(Boolean active) { this.active = active; }

    public WorkflowTemplate() {}

    public WorkflowTemplate(Long id, String templateName, String description, Integer totalLevels, Boolean active) {
        this.id = id;
        this.templateName = templateName;
        this.description = description;
        this.totalLevels = totalLevels;
        this.active = active;
    }
}
