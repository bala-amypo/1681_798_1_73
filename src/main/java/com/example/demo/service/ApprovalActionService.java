package com.example.demo.service;

import com.example.demo.model.ApprovalAction;
import java.util.List;

public interface ApprovalActionService {

    ApprovalAction create(ApprovalAction action);

    List<ApprovalAction> getByLevelAndAction(Integer level, String action);

    List<ApprovalAction> getByRequestId(Long requestId);
}
