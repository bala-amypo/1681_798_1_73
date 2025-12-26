package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "approval_actions")
public class ApprovalAction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long requestId;
    private Long approverId;
    private Integer levelNumber;
    private String action;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getRequestId() { return requestId; }
    public void setRequestId(Long requestId) { this.requestId = requestId; }
    public Long getApproverId() { return approverId; }
    public void setApproverId(Long approverId) { this.approverId = approverId; }
    public Integer getLevelNumber() { return levelNumber; }
    public void setLevelNumber(Integer levelNumber) { this.levelNumber = levelNumber; }
    public String getAction() { return action; }
    public void setAction(String action) { this.action = action; }

    public ApprovalAction() {}

    public ApprovalAction(Long id, Long requestId, Long approverId, Integer levelNumber, String action) {
        this.id = id;
        this.requestId = requestId;
        this.approverId = approverId;
        this.levelNumber = levelNumber;
        this.action = action;
    }
}
