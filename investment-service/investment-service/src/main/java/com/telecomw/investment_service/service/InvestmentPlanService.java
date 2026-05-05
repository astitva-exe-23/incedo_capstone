package com.telecomw.investment_service.service;

import com.telecomw.investment_service.dto.InvestmentPlanRequestDTO;
import com.telecomw.investment_service.dto.InvestmentPlanResponseDTO;
import com.telecomw.investment_service.entity.InvestmentPlan;
import com.telecomw.investment_service.repository.InvestmentPlanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InvestmentPlanService {

    private final InvestmentPlanRepository planRepository;

    // Create Plan
    public InvestmentPlanResponseDTO createPlan(InvestmentPlanRequestDTO request) {

        // Check duplicate plan name
        planRepository.findByPlanName(request.getPlanName())
                .ifPresent(plan -> {
                    throw new RuntimeException("Plan with this name already exists");
                });

        InvestmentPlan plan = InvestmentPlan.builder()
                .planName(request.getPlanName())
                .minAmount(request.getMinAmount())
                .interestRate(request.getInterestRate())
                .durationMonths(request.getDurationMonths())
                .build();

        InvestmentPlan savedPlan = planRepository.save(plan);

        return InvestmentPlanResponseDTO.builder()
                .id(savedPlan.getId())
                .planName(savedPlan.getPlanName())
                .minAmount(savedPlan.getMinAmount())
                .interestRate(savedPlan.getInterestRate())
                .durationMonths(savedPlan.getDurationMonths())
                .build();
    }

    // Fetch All Plans
    public List<InvestmentPlanResponseDTO> getAllPlans() {

        return planRepository.findAll()
                .stream()
                .map(plan -> InvestmentPlanResponseDTO.builder()
                        .id(plan.getId())
                        .planName(plan.getPlanName())
                        .minAmount(plan.getMinAmount())
                        .interestRate(plan.getInterestRate())
                        .durationMonths(plan.getDurationMonths())
                        .build())
                .collect(Collectors.toList());
    }
}

