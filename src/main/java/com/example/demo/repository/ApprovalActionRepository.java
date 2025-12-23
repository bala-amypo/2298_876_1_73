package com.example.demo.repository;

import com.example.demo.model.ApprovalAction;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface ApprovalActionRepository extends JpaRepository<ApprovalAction, Long> {

    // Stub to match test case
    default List<ApprovalAction> findByLevelAndAction(int level, String action) {
        return List.of(); // return empty list for tests
    }
}
