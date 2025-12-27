package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "approval_action")
public class ApprovalAction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "request_id")
    private Long requestId;
    
    @Column(name = "approver_id")
    private Long approverId;
    
    @Column(name = "level_number")
    private Integer levelNumber;
    
    @Column(name = "action")
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
}