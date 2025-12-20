package com.example.demo.util;

import java.util.Collections;
import java.util.List;

public class HibernateQueryUtil {

    public List<?> findActionsByApproverUsingCriteria(Long approverId) {
        return Collections.emptyList();
    }

    // overloaded version to satisfy primitive long calls
    public List<?> findActionsByApproverUsingCriteria(long approverId) {
        return Collections.emptyList();
    }
}
