package com.telecomw.investment_service.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InvestmentPlanResponseDTO {

    private Long id;
    private String planName;
    private Double minAmount;
    private Double interestRate;
    private Integer durationMonths;
}

