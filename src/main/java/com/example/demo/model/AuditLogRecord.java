package com.example.demo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "audit_log")
public class AuditLogRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long requestId;
    private String eventType;

    @Lob
    private String details;

    public Long getId() { return id; }
    public Long getRequestId() { return requestId; }
    public String getEventType() { return eventType; }
    public String getDetails() { return details; }

    public void setId(Long id) { this.id = id; }
    public void setRequestId(Long requestId) { this.requestId = requestId; }
    public void setEventType(String eventType) { this.eventType = eventType; }
    public void setDetails(String details) { this.details = details; }

    public AuditLogRecord() {}

    public AuditLogRecord(Long id, Long requestId, String eventType, String details) {
        this.id = id;
        this.requestId = requestId;
        this.eventType = eventType;
        this.details = details;
    }
}
