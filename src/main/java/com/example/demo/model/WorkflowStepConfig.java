package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "workflow_step_config")
public class WorkflowStepConfig {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long templateId;
    private Integer levelNumber;
    private String approverRole;
    private String instructions;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getTemplateId() { return templateId; }
    public void setTemplateId(Long templateId) { this.templateId = templateId; }
    public Integer getLevelNumber() { return levelNumber; }
    public void setLevelNumber(Integer levelNumber) { this.levelNumber = levelNumber; }
    public String getApproverRole() { return approverRole; }
    public void setApproverRole(String approverRole) { this.approverRole = approverRole; }
    public String getInstructions() { return instructions; }
    public void setInstructions(String instructions) { this.instructions = instructions; }

    public WorkflowStepConfig() {}

    public WorkflowStepConfig(Long id, Long templateId, Integer levelNumber, String approverRole, String instructions) {
        this.id = id;
        this.templateId = templateId;
        this.levelNumber = levelNumber;
        this.approverRole = approverRole;
        this.instructions = instructions;
    }
}
