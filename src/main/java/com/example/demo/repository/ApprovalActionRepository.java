package com.example.demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.ApprovalAction;

public interface ApprovalActionRepository extends JpaRepository<ApprovalAction,Long> {
    Optional<ApprovalAction>findByLevelAndAction(Integer levelNumber,String action);
}
