package com.example.demo.controller;

import com.example.demo.model.ApprovalRequest;
import com.example.demo.service.ApprovalRequestService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/requests")
@Tag(name = "Approval Requests")
public class ApprovalRequestController {

    private final ApprovalRequestService approvalRequestService;

    public ApprovalRequestController(
            ApprovalRequestService approvalRequestService
    ) {
        this.approvalRequestService = approvalRequestService;
    }

    @Operation(summary = "Create approval request")
    @PostMapping
    public ApprovalRequest createRequest(
            @RequestBody ApprovalRequest request
    ) {
        return approvalRequestService.createRequest(request);
    }

    @Operation(summary = "Get all approval requests")
    @GetMapping
    public List<ApprovalRequest> getRequests(
            @RequestParam(required = false) Long requesterId
    ) {
        if (requesterId != null) {
            return approvalRequestService.getRequestsByRequester(requesterId);
        }
        return approvalRequestService.getAllRequests();
    }
}
