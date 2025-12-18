package com.example.demo.controller;

import com.example.demo.model.ApprovalRequest;
import com.example.demo.service.ApprovalRequestService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/requests")
@Tag(name = "Approval Requests")
public class ApprovalRequestController {

    private final ApprovalRequestService service;

    public ApprovalRequestController(ApprovalRequestService service) {
        this.service = service;
    }

    @PostMapping("/")
    public ApprovalRequest createRequest(@RequestBody ApprovalRequest request) {
        return service.createRequest(request);
    }

    @GetMapping("/")
    public List<ApprovalRequest> getAllRequests() {
        return service.getAllRequests();
    }

    @GetMapping("/requester/{userId}")
    public List<ApprovalRequest> getByRequester(@PathVariable Long userId) {
        return service.getRequestsByRequester(userId);
    }
}
