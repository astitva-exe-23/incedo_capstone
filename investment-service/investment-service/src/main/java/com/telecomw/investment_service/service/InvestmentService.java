package com.telecomw.investment_service.service;

import com.telecomw.investment_service.dto.InvestmentRequestDTO;
import com.telecomw.investment_service.dto.InvestmentResponseDTO;
import com.telecomw.investment_service.entity.Investment;
import com.telecomw.investment_service.entity.InvestmentPlan;
import com.telecomw.investment_service.exception.BadRequestException;
import com.telecomw.investment_service.exception.ResourceNotFoundException;
import com.telecomw.investment_service.repository.InvestmentPlanRepository;
import com.telecomw.investment_service.repository.InvestmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class InvestmentService {

    private final InvestmentRepository investmentRepository;
    private final InvestmentPlanRepository planRepository;

    // INVEST IN PLAN
    public InvestmentResponseDTO invest(InvestmentRequestDTO request) {

        // 1️⃣ Check if plan exists
        InvestmentPlan plan = planRepository.findById(request.getPlanId())
                .orElseThrow(() -> new ResourceNotFoundException("Investment plan not found"));

        // 2️⃣ Check minimum amount
        if (request.getAmount() < plan.getMinAmount()) {
            throw new BadRequestException("Investment amount is less than minimum required");
        }

        // 3️⃣ Create investment
        Investment investment = Investment.builder()
                .customerId(request.getCustomerId())
                .planId(request.getPlanId())
                .amount(request.getAmount())
                .investmentDate(LocalDateTime.now())
                .status("ACTIVE")
                .build();

        Investment saved = investmentRepository.save(investment);

        return mapToResponse(saved);
    }

    // FETCH INVESTMENTS BY CUSTOMER
    public List<InvestmentResponseDTO> getByCustomerId(Long customerId) {

        return investmentRepository.findByCustomerId(customerId)
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    // REDEEM INVESTMENT
    public InvestmentResponseDTO redeem(Long investmentId) {

        Investment investment = investmentRepository.findById(investmentId)
                .orElseThrow(() -> new ResourceNotFoundException("Investment not found"));

        if ("REDEEMED".equals(investment.getStatus())) {
            throw new BadRequestException("Investment already redeemed");
        }

        investment.setStatus("REDEEMED");

        Investment updated = investmentRepository.save(investment);

        return mapToResponse(updated);
    }


    // Helper Mapper
    private InvestmentResponseDTO mapToResponse(Investment investment) {

        return InvestmentResponseDTO.builder()
                .id(investment.getId())
                .customerId(investment.getCustomerId())
                .planId(investment.getPlanId())
                .amount(investment.getAmount())
                .investmentDate(investment.getInvestmentDate())
                .status(investment.getStatus())
                .build();
    }
}
