package com.example.demo.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class WorkflowStepConfig{
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    
}