package com.telecomw.investment_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class InvestmentSummaryDTO {

    private Double totalInvestment;
    private Integer activePlans;
}
