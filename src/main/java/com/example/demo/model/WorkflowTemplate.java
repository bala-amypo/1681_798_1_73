package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class WorkflowTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer totalLevels;
    private Boolean active;
    private String description;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public Integer getTotalLevels() { return totalLevels; }
    public void setTotalLevels(Integer totalLevels) { this.totalLevels = totalLevels; }

    public Boolean getActive() { return active; }
    public void setActive(Boolean active) { this.active = active; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public WorkflowTemplate() {}

    public WorkflowTemplate(Long id, String name, Integer totalLevels, Boolean active, String description) {
        this.id = id;
        this.name = name;
        this.totalLevels = totalLevels;
        this.active = active;
        this.description = description;
    }
}
