package com.example.demo.util;

import jakarta.persistence.Query;
import jakarta.persistence.EntityManager;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class HibernateQueryUtil {

    private final EntityManager entityManager;

    public HibernateQueryUtil(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public List<?> executeQuery(String hql) {
        Query query = entityManager.createQuery(hql);
        return query.getResultList();
    }
}
