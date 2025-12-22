package com.example.demo.repository;

import com.example.demo.entity.ApprovalRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.lang.Long;

public interface ApprovalRequestRepository extends JpaRepository<ApprovalRequest, Long> {

    List<ApprovalRequest> findByRequesterId(Long requesterId);
}
