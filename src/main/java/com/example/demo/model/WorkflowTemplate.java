package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class WorkflowTemplate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;       // make sure `getName()` exists
    private boolean active;

    // getters & setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public boolean isActive() { return active; }
    public void setActive(boolean active) { this.active = active; }


    public WorkflowTemplate() {}

    public WorkflowTemplate(Long id, String name, Integer totalLevels, Boolean active, String description) {
        this.id = id;
        this.name = name;
        this.totalLevels = totalLevels;
        this.active = active;
        this.description = description;
    }
}
