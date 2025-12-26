package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "workflow_templates", uniqueConstraints = {@UniqueConstraint(columnNames = "templateName")})
public class WorkflowTemplate {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String templateName;
    private String description;
    private Integer totalLevels;
    private Boolean active;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTemplateName() { return templateName; }
    public void setTemplateName(String templateName) { this.templateName = templateName; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public Integer getTotalLevels() { return totalLevels; }
    public void setTotalLevels(Integer totalLevels) { this.totalLevels = totalLevels; }
    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }

    public WorkflowTemplate() {}
    public WorkflowTemplate(String templateName, String description, Integer totalLevels, Boolean active) {
        this.templateName = templateName;
        this.description = description;
        this.totalLevels = totalLevels;
        this.active = active;
    }
}
