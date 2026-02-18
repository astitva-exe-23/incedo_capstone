package com.telecomw.investment_service.controller;

import com.telecomw.investment_service.dto.InvestmentRequestDTO;
import com.telecomw.investment_service.dto.InvestmentResponseDTO;
import com.telecomw.investment_service.service.InvestmentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class InvestmentController {

    private final InvestmentService investmentService;

    // INVEST
    @PostMapping("/invest")
    public InvestmentResponseDTO invest(
            @Valid @RequestBody InvestmentRequestDTO request) {
        return investmentService.invest(request);
    }

    // FETCH BY CUSTOMER
    @GetMapping("/investments/{customerId}")
    public List<InvestmentResponseDTO> getByCustomer(
            @PathVariable Long customerId) {
        return investmentService.getByCustomerId(customerId);
    }

    // REDEEM
    @PostMapping("/redeem/{investmentId}")
    public InvestmentResponseDTO redeem(
            @PathVariable Long investmentId) {
        return investmentService.redeem(investmentId);
    }
}
