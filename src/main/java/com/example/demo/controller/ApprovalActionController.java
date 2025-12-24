package com.example.demo.controller;

import com.example.demo.model.ApprovalAction;
import com.example.demo.service.ApprovalActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/actions")
public class ApprovalActionController {

    @Autowired
    private ApprovalActionService actionService;

    @PostMapping
    public ResponseEntity<ApprovalAction> createAction(@RequestBody ApprovalAction action) {
        return ResponseEntity.ok(actionService.createAction(action));
    }

    @GetMapping("/request/{requestId}")
    public ResponseEntity<List<ApprovalAction>> getActionsByRequest(@PathVariable Long requestId) {
        return ResponseEntity.ok(actionService.getActionsByRequestId(requestId));
    }
}