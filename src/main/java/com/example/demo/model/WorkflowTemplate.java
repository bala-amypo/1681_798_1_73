package com.example.demo.model;

public class WorkflowTemplate {

    private Long id;
    private String templateName;
    private int totalLevels;
    private String description;
    private boolean active;

    public WorkflowTemplate() {}

    public WorkflowTemplate(Long id, String templateName, int totalLevels, String description, boolean active) {
        this.id = id;
        this.templateName = templateName;
        this.totalLevels = totalLevels;
        this.description = description;
        this.active = active;
    }

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTemplateName() { return templateName; }
    public void setTemplateName(String templateName) { this.templateName = templateName; }

    public int getTotalLevels() { return totalLevels; }
    public void setTotalLevels(int totalLevels) { this.totalLevels = totalLevels; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public boolean getActive() { return active; }
    public void setActive(boolean active) { this.active = active; }
}
