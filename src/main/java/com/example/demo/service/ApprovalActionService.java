package com.example.demo.service;

import com.example.demo.repository.ApprovalActionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApprovalActionService {
    
    @Autowired
    private ApprovalActionRepository actionRepository;
}