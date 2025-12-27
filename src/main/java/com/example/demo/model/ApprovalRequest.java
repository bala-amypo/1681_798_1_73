package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "approval_request")
public class ApprovalRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "template_id")
    private Long templateId;
    
    @Column(name = "requester_id")
    private Long requesterId;
    
    @Column(name = "request_title")
    private String requestTitle;
    
    @Lob
    @Column(name = "request_payload_json")
    private String requestPayloadJson;
    
    @Column(name = "status")
    private String status = "PENDING";

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
}