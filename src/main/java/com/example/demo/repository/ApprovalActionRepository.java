package com.example.demo.repository;

import com.example.demo.model.ApprovalAction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ApprovalActionRepository extends JpaRepository<ApprovalAction, Long> {

    @Query("select a from ApprovalAction a where a.levelNumber = :level and a.action = :action")
    List<ApprovalAction> findByLevelAndAction(Integer level, String action);
}
