package com.example.demo.service;

import com.example.demo.repository.WorkflowStepConfigRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WorkflowStepConfigService {
    
    @Autowired
    private WorkflowStepConfigRepository stepRepository;
}