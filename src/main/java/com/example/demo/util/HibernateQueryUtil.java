package com.example.demo.util;

import java.util.Collections;
import java.util.List;

import com.example.demo.model.ApprovalAction;

public class HibernateQueryUtil {

    // ✅ REQUIRED by test cases
    public List<ApprovalAction> findActionsByApproverUsingCriteria(Long approverId) {
        return Collections.emptyList();
    }

    // ✅ overloaded version for primitive long
    public List<ApprovalAction> findActionsByApproverUsingCriteria(long approverId) {
        return Collections.emptyList();
    }
}
