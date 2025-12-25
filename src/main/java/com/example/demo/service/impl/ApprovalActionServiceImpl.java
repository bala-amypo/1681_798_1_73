package com.example.demo.service.impl;

import com.example.demo.model.ApprovalAction;
import com.example.demo.repository.ApprovalActionRepository;
import com.example.demo.service.ApprovalActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ApprovalActionServiceImpl implements ApprovalActionService {

    @Autowired
    private ApprovalActionRepository approvalActionRepository;

    public ApprovalAction saveAction(ApprovalAction action) {
        return approvalActionRepository.save(action);
    }

    public List<ApprovalAction> findByLevelAndAction(Integer level, String action) {
        return approvalActionRepository.findByLevelAndAction(level, action);
    }
}
