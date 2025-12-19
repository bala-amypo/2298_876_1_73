package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.ApprovalRequest;
import com.example.demo.service.ApprovalRequestService;

@RestController
@RequestMapping("/api/requests")
@CrossOrigin
public class ApprovalRequestController {

    private final ApprovalRequestService service;

    public ApprovalRequestController(ApprovalRequestService service) {
        this.service = service;
    }

    @PostMapping
    public ApprovalRequest create(@RequestBody ApprovalRequest request) {
        return service.createRequest(request);
    }

    @GetMapping
    public List<ApprovalRequest> getAll() {
        return service.getAllRequests();
    }

    @GetMapping("/{id}")
    public ApprovalRequest getById(@PathVariable Long id) {
        return service.getRequestById(id);
    }

    @PutMapping("/{id}")
    public ApprovalRequest update(
            @PathVariable Long id,
            @RequestBody ApprovalRequest request) {
        return service.updateRequest(id, request);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.deleteRequest(id);
    }
}
