package com.example.demo.repository;

import com.example.demo.entity.WorkflowStepConfig;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.lang.Long;

public interface WorkflowStepConfigRepository extends JpaRepository<WorkflowStepConfig, Long> {

    List<WorkflowStepConfig> findByTemplateIdOrderByLevelNumberAsc(Long templateId);
}
