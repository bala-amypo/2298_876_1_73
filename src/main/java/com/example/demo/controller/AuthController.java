package com.example.demo.controller;

import com.example.demo.model.ApprovalRequest;
import com.example.demo.model.ApprovalAction;
import com.example.demo.service.ApprovalRequestService;
import com.example.demo.service.ApprovalActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/approvals")
public class ApprovalController {

    @Autowired
    private ApprovalRequestService requestService;

    @Autowired
    private ApprovalActionService actionService;

    @PostMapping("/requests")
    public ResponseEntity<ApprovalRequest> createRequest(@RequestBody ApprovalRequest request) {
        return ResponseEntity.ok(requestService.save(request));
    }

    @PostMapping("/actions")
    public ResponseEntity<ApprovalAction> createAction(@RequestBody ApprovalAction action) {
        return ResponseEntity.ok(actionService.save(action));
    }
}
