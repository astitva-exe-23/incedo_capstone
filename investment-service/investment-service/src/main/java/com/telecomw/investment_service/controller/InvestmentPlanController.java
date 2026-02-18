package com.telecomw.investment_service.controller;

import com.telecomw.investment_service.dto.InvestmentPlanRequestDTO;
import com.telecomw.investment_service.dto.InvestmentPlanResponseDTO;
import com.telecomw.investment_service.service.InvestmentPlanService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/plans")
@RequiredArgsConstructor
public class InvestmentPlanController {

    private final InvestmentPlanService planService;

    // Create Investment Plan
    @PostMapping
    public InvestmentPlanResponseDTO createPlan(
            @Valid @RequestBody InvestmentPlanRequestDTO request) {
        return planService.createPlan(request);
    }

    // Fetch All Plans
    @GetMapping
    public List<InvestmentPlanResponseDTO> getAllPlans() {
        return planService.getAllPlans();
    }
}

