package com.example.demo.util;

import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Root;
import java.util.List;

public class HibernateQueryUtil {
    
    public static List<?> findActionsByApproverUsingCriteria(Long approverId) {
          return List.of();
   }

    private HibernateQueryUtil() {
    }

    public static <T> List<T> fetchAll(EntityManager entityManager, Class<T> clazz) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> cq = cb.createQuery(clazz);
        Root<T> root = cq.from(clazz);
        cq.select(root);
        return entityManager.createQuery(cq).getResultList();
    }
}
