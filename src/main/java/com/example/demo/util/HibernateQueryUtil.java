package com.example.demo.util;

import com.example.demo.model.ApprovalAction;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HibernateQueryUtil {

    @PersistenceContext
    private EntityManager entityManager;

    public List<ApprovalAction> findActionsByApproverUsingCriteria(Long approverId) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<ApprovalAction> cq = cb.createQuery(ApprovalAction.class);
        Root<ApprovalAction> root = cq.from(ApprovalAction.class);

        if (approverId != null) {
            cq.where(cb.equal(root.get("approverId"), approverId));
        }

        return entityManager.createQuery(cq).getResultList();
    }
}
