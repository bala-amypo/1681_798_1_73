package com.example.demo.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class WorkflowTemplate{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true)
    private String templateName;
    private String description;
    private Integer totalLevels;
    private Boolean active;
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTemplateName() {
        return templateName;
    }
    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public Integer getTotalLevels() {
        return totalLevels;
    }
    public void setTotalLevels(Integer totalLevels) {
        this.totalLevels = totalLevels;
    }
    public Boolean getActive() {
        return active;
    }
    public void setActive(Boolean active) {
        this.active = active;
    }
    public WorkflowTemplate() {
    }
    public WorkflowTemplate(Long id, String templateName, String description, Integer totalLevels, Boolean active) {
        this.id = id;
        this.templateName = templateName;
        this.description = description;
        this.totalLevels = totalLevels;
        this.active = active;
    }
     
}