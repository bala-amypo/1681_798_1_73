package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "approval_requests")
public class ApprovalRequest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long templateId;
    private Long requesterId;
    private String requestTitle;

    @Lob
    private String requestPayloadJson;

    private String status;
    private Integer currentLevel;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getTemplateId() { return templateId; }
    public void setTemplateId(Long templateId) { this.templateId = templateId; }
    public Long getRequesterId() { return requesterId; }
    public void setRequesterId(Long requesterId) { this.requesterId = requesterId; }
    public String getRequestTitle() { return requestTitle; }
    public void setRequestTitle(String requestTitle) { this.requestTitle = requestTitle; }
    public String getRequestPayloadJson() { return requestPayloadJson; }
    public void setRequestPayloadJson(String requestPayloadJson) { this.requestPayloadJson = requestPayloadJson; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public Integer getCurrentLevel() { return currentLevel; }
    public void setCurrentLevel(Integer currentLevel) { this.currentLevel = currentLevel; }

    public ApprovalRequest() {}

    public ApprovalRequest(Long id, Long templateId, Long requesterId, String requestTitle,
                           String requestPayloadJson, String status, Integer currentLevel) {
        this.id = id;
        this.templateId = templateId;
        this.requesterId = requesterId;
        this.requestTitle = requestTitle;
        this.requestPayloadJson = requestPayloadJson;
        this.status = status;
        this.currentLevel = currentLevel;
    }
}
