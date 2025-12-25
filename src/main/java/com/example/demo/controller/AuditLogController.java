package com.example.demo.controller;

import com.example.demo.model.AuditLogRecord;
import com.example.demo.service.AuditLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/audit")
public class AuditLogController {

    @Autowired
    private AuditLogService auditLogService;

    @PostMapping
    public ResponseEntity<AuditLogRecord> createAuditLog(@RequestBody AuditLogRecord auditLog) {
        return ResponseEntity.ok(auditLogService.createAuditLog(auditLog));
    }

    @GetMapping("/request/{requestId}")
    public ResponseEntity<List<AuditLogRecord>> getAuditLogsByRequest(@PathVariable Long requestId) {
        return ResponseEntity.ok(auditLogService.getAuditLogsByRequestId(requestId));
    }
}