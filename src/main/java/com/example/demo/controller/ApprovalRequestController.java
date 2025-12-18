package com.example.demo.controller;

import com.example.demo.model.ApprovalRequest;
import com.example.demo.service.ApprovalRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/requests")
public class ApprovalRequestController {

    @Autowired
    private ApprovalRequestService service;

    // CREATE
    @PostMapping
    public ApprovalRequest create(@RequestBody ApprovalRequest request) {
        return service.save(request);
    }

    // READ ALL
    @GetMapping
    public List<ApprovalRequest> getAll() {
        return service.getAll();
    }

    // READ BY ID
    @GetMapping("/{id}")
    public ApprovalRequest getById(@PathVariable Long id) {
        return service.getById(id);
    }

    // UPDATE
    @PutMapping("/{id}")
    public ApprovalRequest update(
            @PathVariable
