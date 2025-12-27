package com.example.demo.service.impl;

import com.example.demo.model.ApprovalAction;
import com.example.demo.repository.ApprovalActionRepository;
import com.example.demo.service.ApprovalActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApprovalActionServiceImpl implements ApprovalActionService {
    
    @Autowired
    private ApprovalActionRepository actionRepository;
    
    @Override
    public ApprovalAction createAction(ApprovalAction action) {
        return actionRepository.save(action);
    }
}