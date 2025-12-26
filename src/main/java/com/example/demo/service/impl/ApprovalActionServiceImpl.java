package com.example.demo.service;

import com.example.demo.model.ApprovalAction;
import com.example.demo.repository.ApprovalActionRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ApprovalActionServiceImpl implements ApprovalActionService {

    private final ApprovalActionRepository repository;

    public ApprovalActionServiceImpl(ApprovalActionRepository repository) {
        this.repository = repository;
    }

    public ApprovalAction create(ApprovalAction action) {
        return repository.save(action);
    }

    public List<ApprovalAction> getByLevelAndAction(Integer level, String action) {
        return repository.findByLevelAndAction(level, action);
    }
}
