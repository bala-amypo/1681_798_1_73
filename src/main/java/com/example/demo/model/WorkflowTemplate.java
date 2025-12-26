package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(
        name = "workflow_templates",
        uniqueConstraints = @UniqueConstraint(columnNames = "template_name")
)
public class WorkflowTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "template_name", nullable = false)
    private String templateName;

    private Integer totalLevels;
    private Boolean active;
    private String description;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTemplateName() { return templateName; }
    public void setTemplateName(String templateName) { this.templateName = templateName; }
    public Integer getTotalLevels() { return totalLevels; }
    public void setTotalLevels(Integer totalLevels) { this.totalLevels = totalLevels; }
    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public WorkflowTemplate() {}

    public WorkflowTemplate(Long id, String templateName, Integer totalLevels, Boolean active, String description) {
        this.id = id;
        this.templateName = templateName;
        this.totalLevels = totalLevels;
        this.active = active;
        this.description = description;
    }
}
